package ua.codegym.serializer.xml.handler;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class CircleXmlSerializer implements Serializer<Circle >{
  @Override
  public void serialize(Circle circle, OutputStream os) throws IOException {

    int x = circle.getX();
    int y = circle.getY();
    int radius = circle.getRadius();

    String out = String.format("<circle x=\"%d\" y=\"%d\" side=\"%d\"></circle>", x, y, radius);

    os.write(out.getBytes());
  }
}
