package n30;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import n30.misc.Vector2;
import n30.visual.Window;

public class Main {
  public static void main(String[] args) { new Main(); }
  private static Main inst;
  public static Main getInstance() {
    return inst;
  }

  public BufferStrategy bs;
  public Graphics g;

  public Window window;

  public Main() {
    inst = this;

    Vector2 p0 = new Vector2(0, 0);
    Vector2 p1 = new Vector2(7.5, 0);
    Vector2 p2 = new Vector2(2.5, 10);
    Vector2 p3 = new Vector2(10, 10);
    System.out.println("Creating Path...");
    Path path = new Path(p0, p1, p2, p3);
    System.out.println("Created Path.");
    System.out.println("Splitting Path...");
    ArrayList<ArrayList<Vector2>> a = path.getSplitPath(1);

    for (int i = 0; i < a.get(0).size(); i++) {
      //System.out.println(a.get(0).get(i).dist(a.get(1).get(i)));
    }

    System.out.println("Path Split.");
    System.out.println("Printing Cordinates...");
    path.printCords(a);
    System.out.println("Done");
  }

  public void Init() {
    window = new Window(600, 600, "BAH");
  }

  public void Tick() {

  }

  public void Render() {
    bs = window.getCanvas().getBufferStrategy();
    if (bs == null) {
      window.getCanvas().createBufferStrategy(3);
    }
    g = bs.getDrawGraphics();

    g.clearRect(0, 0, window.width, window.height);
    g.setColor(Color.DARK_GRAY);
    g.fillRect(0, 0, window.width, window.height);



    bs.show();
    g.dispose();
  }

}