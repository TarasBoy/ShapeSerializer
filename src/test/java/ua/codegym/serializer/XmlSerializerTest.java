package ua.codegym.serializer;

import org.junit.Test;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import static org.junit.Assert.assertEquals;

public class XmlSerializerTest {

  @Test

  public void verifyThatSingleCircleIsWritingCorrectly() throws IOException {
    //given
    Shape shape = new Circle(0, 1, 5);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    // when
    xml.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("<circle x=\"0\" y=\"1\" side=\"5\"></circle>", output);

  }


  @Test
  public void verifyThatSingleSquareIsWritingCorrectly() throws IOException {
    // given  
    Shape shape = new Square(1, 2, 10);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    // when
    xml.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("<square x=\"1\" y=\"2\" side=\"10\"></square>", output);
  }

  @Test
  public void verifyThatGroupedShapeWritingCorrectly() throws IOException {
    // given
    Group group = new Group();
    group.add(new Square(0, 1, 2));

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    // when
    xml.serialize(group, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("<group><square x=\"0\" y=\"1\" side=\"2\"></square></group>", output);
  }
}
