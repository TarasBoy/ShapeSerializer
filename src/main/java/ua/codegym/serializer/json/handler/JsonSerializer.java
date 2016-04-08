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

  public JsonSerializer() {
    serializers.put(Square.class.getCanonicalName(), new SquareJsonSerializer());
    serializers.put(Triangle.class.getCanonicalName(), new TriangleJsonSerializer());
    serializers.put(Group.class.getCanonicalName(),new GroupJsonSerializer());
  }

  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType();
    Serializer serializer = serializers.get(type);
    serializer.serialize(shape, os);

  }

}
