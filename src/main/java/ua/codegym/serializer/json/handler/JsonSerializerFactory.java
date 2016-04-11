package ua.codegym.serializer.json.handler;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Square;
import ua.codegym.serializer.shape.Triangle;

import java.util.HashMap;
import java.util.Map;

public class JsonSerializerFactory {
  private Map<String, Serializer> serializers = new HashMap<>();
  public JsonSerializerFactory(){
    serializers.put(Square.class.getCanonicalName(), new SquareJsonSerializer());
    serializers.put(Triangle.class.getCanonicalName(), new TriangleJsonSerializer());
    serializers.put(Group.class.getCanonicalName(),new GroupJsonSerializer(this));
    }

   public Serializer getSerializer(String type) {return serializers.get(type);}
}
