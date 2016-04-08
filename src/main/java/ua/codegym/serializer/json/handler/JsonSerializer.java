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

public class JsonSerializer implements Serializer {
  private Map<String, Serializer> serializers = new HashMap<>();
  public JsonSerializer(){
    serializers.put(Square.class.getCanonicalName(),new SquareJsonSerializer());
    serializers.put(Triangle.class.getCanonicalName(),new TriangleJsonSerializer());
  }
  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType();
    if (type.equals(Group.class.getCanonicalName())) {
      serializeGroup((Group) shape, os);
    }else{
      Serializer serializer = serializers.get(type);
      serializer.serialize(shape,os);
    }
  }

  private void serializeGroup(Group shape, OutputStream os) throws IOException {
    Group group = shape;
    os.write("{\"group\":[".getBytes());
    for (Shape innerShape : group.getShapes()) {
      serialize(innerShape, os);
    }
    os.write("]}".getBytes());
  }
}
