/*
package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class GroupJsonSerializer implements Serializer {
  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    //Group group = shape;
    os.write("{\"group\":[".getBytes());
    for (Shape innerShape : group.getShapes()) {
      serialize(innerShape, os);
    }
    os.write("]}".getBytes());

  }
}
*/
