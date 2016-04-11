package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Square;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class XmlSerializerFactory {
  private Map<String, Serializer> serializers = new HashMap<>();

  public XmlSerializerFactory() {
    serializers.put(Square.class.getCanonicalName(), new SquareXmlSerializer());
    serializers.put(Circle.class.getCanonicalName(), new CircleXmlSerializer());
    serializers.put(Group.class.getCanonicalName(), new GroupXmlSerializer(this));

  }

  public Serializer getSerrializer(String type) {
    return serializers.get(type);
  }
}
