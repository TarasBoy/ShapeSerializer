package ua.codegym.serializer.shape;

import java.util.List;
import java.util.ArrayList;

public class Group extends AbstractShape {

  private List<Shape> shapes = new ArrayList<>();

  public void add(Shape shape) {
    shapes.add(shape);
  }

  public List<Shape> getShapes() {
    return shapes;
  }
}

