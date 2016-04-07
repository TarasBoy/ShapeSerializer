package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;

public class JsonSerializer implements Serializer {
  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType();
    if(type.equals(Triangle.class.getCanonicalName())){
      Triangle triangle = (Triangle)shape;
      int xA = triangle.getxA();
      int yA = triangle.getyA();
      int xB = triangle.getxB();
      int yB = triangle.getyB();
      int xC = triangle.getxC();
      int yC = triangle.getyC();

      String out = String.format("{\"xA\":%d,\"yA\":%d,\"xB\":%d,\"yB\":%d,\"xC\":%d,\"yC\":%d,}", xA, yA,xB,yB,xC,yC);

      os.write(out.getBytes());

    }
  }
}
