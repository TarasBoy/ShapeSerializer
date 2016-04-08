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

public class GroupJsonSerializer implements Serializer {
  private Map<String, Serializer> serializers = new HashMap<>();

  public GroupJsonSerializer() {
    serializers.put(Square.class.getCanonicalName(), new SquareJsonSerializer());
    serializers.put(Triangle.class.getCanonicalName(), new TriangleJsonSerializer());
    serializers.put(Group.class.getCanonicalName(),this);
  }
  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    Group group = (Group)shape;
    int size = group.getShapes().size();
    int counter = 0;
    os.write("{\"group\":[".getBytes());
    for (Shape innerShape : group.getShapes()) {
      Serializer serializer = serializers.get(innerShape.getType());
      serializer.serialize(innerShape,os);
      counter++;
      if (counter < size) os.write(",".getBytes());
    }
    os.write("]}".getBytes());

  }
}
