package ua.codegym.serializer;

import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public interface Serializer <T extends Shape> {
  void serialize(T shape, OutputStream os) throws IOException;
}