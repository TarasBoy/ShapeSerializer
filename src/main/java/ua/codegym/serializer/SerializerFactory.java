package ua.codegym.serializer;

import ua.codegym.serializer.json.handler.JsonSerializer;
import ua.codegym.serializer.xml.handler.XmlSerializer;

public final class SerializerFactory {

    private SerializerFactory() {}

    public static Serializer newXmlSerializer() {
        return new XmlSerializer();
    }
    public static Serializer newJsonSerializer(){return new JsonSerializer(); }
}
