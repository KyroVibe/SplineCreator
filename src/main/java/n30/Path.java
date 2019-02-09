package n30;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import n30.misc.Vector2;

public class Path {

  private Vector2 p0, p1, p2, p3;

  public Path(Vector2 p0, Vector2 p1, Vector2 p2, Vector2 p3) {
    this.p0 = p0;
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  public Vector2 get(double t) {
    return cubicBezier(t);
  }

  public Vector2 cubicBezier(double t) {
    double x = (Math.pow((1 - t), 3) * 3 * p0.x) + (Math.pow((1 - t), 2) * 3 * t * p1.x) +
                ((1 - t) * 3 * t * t * p2.x) + (t * t * t * p3.x);
    double y = (Math.pow((1 - t), 3) * 3 * p0.y) + (Math.pow((1 - t), 2) * 3 * t * p1.y) +
                ((1 - t) * 3 * t * t * p2.y) + (t * t * t * p3.y);
    Vector2 finalPoint = new Vector2(x, y);
    return finalPoint;
  }

  public Vector2 deriv(double t, double delta) {
    Vector2 a;
    if (t - delta < 0) {
      a = cubicBezier(0); //System.out.println("Ahh A");
    } else {
      a = cubicBezier(t - delta);// System.out.println(t + delta);
    }
    Vector2 b;
    if (t + delta > 1) {
      b = cubicBezier(1); //System.out.println("Ahh B");
    } else {
      b = cubicBezier(t + delta);
    }

    Vector2 d = new Vector2(b.x - a.x, b.y - a.y);
    return d.Normalize();
  }

  /**
   * @param offset distance perpendicular to the left
   */
  public ArrayList<ArrayList<Vector2>> getSplitPath(double offset) {
    ArrayList<Vector2> leftSet = new ArrayList<Vector2>();
    ArrayList<Vector2> rightSet = new ArrayList<Vector2>(); 

    for (double i = 0; i <= 1; i+=0.01) {
      System.out.println("Calculating: " + i);
      Vector2 point = cubicBezier(i);
      Vector2 d = deriv(i, 0.001);
      //System.out.println(d.getMag());
      Vector2 perp = new Vector2(d.y, -d.x);

      //Vector2 leftOffset = perp.clone().setMagnitude(perp.getMag(), offset);
      //Vector2 rightOffset = perp.clone().multiply(-1).setMagnitude(perp.getMag(), offset);

      Vector2 left = point.clone().add(perp.clone().setMagnitude(1, offset));
      Vector2 right = point.clone().add(perp.clone().multiply(-1).setMagnitude(1, offset));

      //System.out.println(left.x + " " + left.y);
      //System.out.println(right.x + " " + right.y);
      System.out.println(left.dist(right));

      leftSet.add(left);
      rightSet.add(right);
    }

    ArrayList<ArrayList<Vector2>> paths = new ArrayList<ArrayList<Vector2>>();
    paths.add(leftSet);
    paths.add(rightSet);

    return paths;
  }

  public void printCords(ArrayList<ArrayList<Vector2>> paths) {
    File a = new File("paths/PathData.spart");
    try {
      a.createNewFile();
      FileWriter writer = new FileWriter(a);
      for (int i = 0; i < paths.get(0).size(); i++) {
        writer.write(paths.get(0).get(i).x + "%" + paths.get(0).get(i).y + "," +
          paths.get(1).get(i).x + "%" + paths.get(1).get(i).y + "\n");
      }
      writer.flush();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}