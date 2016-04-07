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

public class GroupXmlSerializer implements Serializer{
  private Map<String, Serializer> serializers = new HashMap<>();

  public GroupXmlSerializer() {
    serializers.put(Square.class.getCanonicalName(), new SquareXmlSerializer());
    serializers.put(Circle.class.getCanonicalName(), new CircleXmlSerializer());
    serializers.put(Group.class.getCanonicalName(), this );

  }

  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    Group group = (Group) shape;


    os.write("<group>".getBytes());

    for(Shape innerShape : group.getShapes()){
      Serializer serializer = serializers.get(innerShape.getType());
      serializer.serialize(innerShape, os);
    }
    os.write("</group>".getBytes());
  }
}
