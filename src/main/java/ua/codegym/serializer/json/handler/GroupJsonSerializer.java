package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;
import ua.codegym.serializer.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class GroupJsonSerializer implements Serializer<Group> {
    private JsonSerializerFactory factory;

  public GroupJsonSerializer(JsonSerializerFactory factory){

    this.factory = factory;
  }
  @Override
  public void serialize(Group group, OutputStream os) throws IOException {
    int size = group.getShapes().size();
    int counter = 0;
    os.write("{\"group\":[".getBytes());
    for (Shape innerShape : group.getShapes()) {
      Serializer serializer = factory.getSerializer(innerShape.getType());
      serializer.serialize(innerShape,os);
      counter++;
      if (counter < size) os.write(",".getBytes());
    }
    os.write("]}".getBytes());

  }
}
