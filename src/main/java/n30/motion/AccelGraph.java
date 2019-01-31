package n30.motion;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import n30.misc.Vector2;

/**
 * This class is used to calculate the points for a curve to follow in order to
 * go at a set acceleration and to stop accelerating when you reach a max speed.
 * also to decelerate at the same pace.
 */
public class AccelGraph {

  private double accel = 0;
  private double maxVel = 0;
  private double totalDist = 0;

  public double totalTime;
  public double cruisePeriod;
  public double accelPeriod;
  public double accelDist;

  public AccelGraph(double _accel, double _maxVel, double _totalDist) {
    accel = _accel;
    maxVel = _maxVel;
    totalDist = _totalDist;
  }

  /**
   * Calculate out all the points in the graph using the varibles assigned in the
   * constructor.
   * 
   * @return List of points as Vector2's. They aren't actually Vectors.
   */
  public ArrayList<Vector2> calcPoints() {
    ArrayList<Vector2> points = new ArrayList<Vector2>();

    totalTime = 0;
    cruisePeriod = 0;
    accelPeriod = accel / maxVel;
    accelDist = (0.5 * accel) * Math.pow(accelPeriod, 2);
    if (accelDist >= totalDist / 2) {
      accelPeriod = Math.sqrt(-4 * (0.5 * accel) * (-(totalDist / 2))) / (2 * (0.5 * accel));
      cruisePeriod = 0;
    } else {
      cruisePeriod = maxVel / (totalDist - (2 * accelDist));
    }

    totalTime += (accelPeriod * 2) + cruisePeriod;

    for (double t = 0; t <= totalTime; t += 0.01) {

      double y;
      if (t >= totalTime - accelPeriod) {
        y = ((0.5 * (-accel)) * Math.pow(t - (totalTime - accelPeriod), 2)) +
          (maxVel * (t - (totalTime - accelPeriod))) + points.get(points.size() - 1).y;
        System.out.println("Decelerate: " + t);
      } else if (t >= accelPeriod) {
        y = (maxVel * (t - points.get(points.size() - 1).x)) + points.get(points.size() - 1).y;
        System.out.println("Cruise: " + t);
      } else {
        y = (0.5 * accel) * Math.pow(t, 2);
        System.out.println("Accelerate: " + t);
      }

      points.add(new Vector2(t, y));
    }

    printCords(points);

    return points;
  }

  /*public ArrayList<Vector2> FUCK() {
    ArrayList<Vector2> points = new ArrayList<Vector2>();

    totalTime = 0;
    cruisePeriod = 0;
    accelPeriod = accel / maxVel;
    accelDist = (0.5 * accel) * Math.pow(accelPeriod, 2);
    if (accelDist >= totalDist / 2) {
      accelPeriod = (Math.sqrt(-4 * (0.5 * accel) * (-(totalDist / 2)))) / (2 * (0.5 * accel));
      cruisePeriod = 0;
    } else {
      cruisePeriod = maxVel / (totalDist - (2 * accelDist));
    }

    totalTime = cruisePeriod + (2 * accelPeriod);

    points.add(new Vector2(0, 0));

    for (double i = 0; i <= totalTime; i += 0.01) {
      double v = getVel(i, points.get(points.size() - 1));
      double y = v * i;
      points.add(new Vector2(i, y));
    }

    printCords(points);

    return points;
  }*/

  public double getVel(double t, Vector2 last) {
    double totalTime = 0;
    double cruisePeriod = 0;
    double accelPeriod = accel / maxVel;
    double accelDist = (0.5 * accel) * Math.pow(accelPeriod, 2);
    if (accelDist >= totalDist / 2) {
      accelPeriod = Math.sqrt(-4 * (0.5 * accel) * (-(totalDist / 2))) / (2 * (0.5 * accel));
      cruisePeriod = 0;
    } else {
      cruisePeriod = maxVel / (totalDist - (2 * accelDist));
    }

    totalTime = cruisePeriod + (2 * accelPeriod);

    if (t >= totalTime - accelPeriod) {
      return (t * (-accel)) + maxVel;
    } else if (t > accelPeriod) {
      return maxVel;
    } else {
      return (t * (05 * accel));
    }
  }

  public void printCords(ArrayList<Vector2> cords) {
    File a = new File("/home/n30b4rt/Desktop/AccelCords.spart");
    try {
      a.createNewFile();
      FileWriter writer = new FileWriter(a);
      for (int i = 0; i < cords.size(); i++) {
        String bah = cords.get(i).x + "," + cords.get(i).y;
        System.out.println("'" + bah + "'");
        writer.write(bah + "\n");
      }
      writer.flush();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}