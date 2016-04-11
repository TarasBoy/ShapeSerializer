package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class GroupXmlSerializer implements Serializer<Group>{
   private XmlSerializerFactory factory;

  public GroupXmlSerializer(XmlSerializerFactory factory) {

    this.factory = factory;
  }

  @Override
  public void serialize(Group group, OutputStream os) throws IOException {
    os.write("<group>".getBytes());

    for(Shape innerShape : group.getShapes()){
      Serializer serializer =factory.getSerrializer(innerShape.getType());
      serializer.serialize(innerShape, os);
    }
    os.write("</group>".getBytes());
  }
}
