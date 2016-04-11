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

  private JsonSerializerFactory factory;

  public JsonSerializer(JsonSerializerFactory factory){

    this.factory = factory;
  }

  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType();
    Serializer serializer = factory.getSerializer(type);
    serializer.serialize(shape, os);

  }

}
