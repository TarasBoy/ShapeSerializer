
package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.SerializerFactory;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlSerializer implements Serializer {

  private XmlSerializerFactory factory;


  public XmlSerializer(XmlSerializerFactory factory) {

    this.factory = factory;
  }

  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType();
    Serializer serializer = factory.getSerrializer(type);
    serializer.serialize(shape, os);
  }

}
