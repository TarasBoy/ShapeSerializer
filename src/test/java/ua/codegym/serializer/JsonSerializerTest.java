package ua.codegym.serializer;

import org.junit.Test;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {

  @Test

  public void serializeSingleTriangleToJson() throws IOException {
    Shape shape = new Triangle(1,2,3,4,5,6);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    // when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("{\"xA\":1,\"yA\":2,\"xB\":3,\"yB\":4,\"xC\":5,\"yC\":6,}", output);


  }
}
