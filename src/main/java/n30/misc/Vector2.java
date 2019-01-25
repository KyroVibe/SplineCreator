package n30.misc;

import java.util.Vector;

public class Vector2 {

  public double x, y;

  public Vector2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getMag() {
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
  }

  public Vector2 Normalize() {
    /*double newX = Math.pow(x, 2) / (Math.pow(x, 2) + Math.pow(y, 2));
    double newY = Math.pow(y, 2) / (Math.pow(x, 2) + Math.pow(y, 2));
    x = (Math.abs(x) / x) * newX;
    y = (Math.abs(y) / y) * newY;
    return this;*/
    return setMagnitude(getMag(), 1);
  }

  /*public Vector2 Normalize() {

    //System.out.println(x + " " + y);
    if (Math.abs(x) > Math.abs(y)) {
      y = y / Math.abs(x);
      x = Math.abs(x) / x;
    } else if (Math.abs(x) > Math.abs(y)) {
      x = x / Math.abs(y);
      y = Math.abs(y) / y;
    } else {
      x = Math.abs(x) / x;
      y = Math.abs(y) / y;
    }

    return this;
  }*/

  public Vector2 setMagnitude(double prev, double mag) {
    double a = Math.pow(prev, 2);
    double b = Math.pow(x, 2);
    double c = Math.pow(y, 2);
    double d = Math.pow(mag, 2);
    x = (Math.abs(x) / x) * Math.sqrt(d * (b / a));
    y = (Math.abs(y) / y) * Math.sqrt(d * (c / a));
    return this;
  }

  public Vector2 multiply(double a) {
    x *= a;
    y *= a;
    return this;
  }

  public Vector2 add(Vector2 a) {
    //System.out.println(x + " " + y);
    x += a.x;
    y += a.y;
    //System.out.println(x + " " + y);
    return this;
  }

  public Vector2 add(double a) {
    //System.out.println(x + " " + y);
    x += a;
    y += a;
    //System.out.println(x + " " + y);
    return this;
  }

  public Vector2 clone() {
    return new Vector2(x, y);
  }

  public double dist(Vector2 a) {
    double b = Math.pow((x - a.x), 2) + Math.pow((y - a.y), 2);
    return Math.sqrt(b);
  }

}