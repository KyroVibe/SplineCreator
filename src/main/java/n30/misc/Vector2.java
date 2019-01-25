package n30.misc;

public class Vector2 {

  public double x, y;

  public Vector2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Vector2 Normalize() {

    if (x > y) {
      y = y / x;
      x = 1;
    } else if (y > x) {
      x = x / y;
    }

    return this;
  }

  public Vector2 multiply(double a) {
    x *= a;
    y *= a;
    return this;
  }

  public Vector2 add(Vector2 a) {
    x += a.x;
    y += a.y;
    return this;
  }

  public Vector2 add(double a) {
    x += a;
    y += a;
    return this;
  }

}