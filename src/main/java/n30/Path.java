package n30;

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

  public Path[] splitTrack(double width) {
    tracks = new Path[];
  }

}