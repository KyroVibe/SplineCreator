package n30.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import n30.misc.Point;

public class MouseStuff implements MouseListener {

  public static ArrayList<Point> points = new ArrayList<Point>();

  public MouseStuff() {

  }

  @Override
  public void mouseExited(MouseEvent event) {

  }

  @Override
  public void mouseReleased(MouseEvent event) {

  }

  @Override
  public void mouseClicked(MouseEvent event) {
    int x = event.getX();
    int y = event.getY();

    // points =
  }

  @Override
  public void mousePressed(MouseEvent event) {

  }

  @Override
  public void mouseEntered(MouseEvent event) {

  }

}