package ua.codegym.serializer;

import ua.codegym.serializer.json.handler.JsonSerializer;
import ua.codegym.serializer.json.handler.JsonSerializerFactory;
import ua.codegym.serializer.xml.handler.XmlSerializer;
import ua.codegym.serializer.xml.handler.XmlSerializerFactory;

public final class SerializerFactory {

    private SerializerFactory() {}

    public static Serializer newXmlSerializer() {return new XmlSerializer(new XmlSerializerFactory());
    }
    public static Serializer newJsonSerializer(){return new JsonSerializer(new JsonSerializerFactory()); }
}
