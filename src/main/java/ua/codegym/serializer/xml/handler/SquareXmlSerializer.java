package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;

public class SquareXmlSerializer implements Serializer{

  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    Square square = (Square)shape;
    int x = square.getX();
    int y = square.getY();
    int side = square.getSide();

    String out = String.format("<square x=\"%d\" y=\"%d\" side=\"%d\"></square>", x, y, side);

    os.write(out.getBytes());

  }

}