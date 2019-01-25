package n30;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

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