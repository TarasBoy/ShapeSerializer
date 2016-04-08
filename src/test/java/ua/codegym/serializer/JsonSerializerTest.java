package ua.codegym.serializer;

import org.junit.Test;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;
import ua.codegym.serializer.shape.Square;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {

  @Test

  public void verifyThatSingleTriangleIsWritingCorrectlyToJson() throws IOException {
    Shape shape = new Triangle(1,2,3,4,5,6);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    // when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("{\"Triangle\":{\"xA\":1,\"yA\":2,\"xB\":3,\"yB\":4,\"xC\":5,\"yC\":6},", output);


  }
  @Test

  public void verifyThatSingleSquareIsWritingCorrectlyToJson() throws IOException {
    Shape shape = new Square(1,2,3);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    // when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("{\"Square\":{\"x\":1,\"y\":2,\"side\":3},", output);


  }
  @Test

  public void verifyThatGroupIsWritingCorrectlyToJson() throws IOException {
    Group shape = new Group();
    shape.add(new Triangle(1,2,3,4,5,6));
    shape.add(new Square(1,2,3));

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    // when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("{\"group\":[{\"Triangle\":{\"xA\":1,\"yA\":2,\"xB\":3,\"yB\":4,\"xC\":5,\"yC\":6},{\"Square\":{\"x\":1,\"y\":2,\"side\":3},]}", output);


  }
}
