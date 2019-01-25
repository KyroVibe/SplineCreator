package n30.visual;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Window {

  public int width, height;
  public String title;

  private JFrame frame;
  private Canvas canvas;

  public Window(int width, int height, String title) {
    this.width = width;
    this.height = height;
    this.title = title;
    frame = new JFrame();
    canvas = new Canvas();

    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setResizable(false);

    canvas.setSize(width, height);
    canvas.setFocusable(false);
    
    frame.add(canvas);
    frame.pack();
  }

  public Canvas getCanvas() { return canvas; }

}