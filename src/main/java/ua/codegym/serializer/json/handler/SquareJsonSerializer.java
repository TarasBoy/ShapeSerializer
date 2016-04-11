package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;

public class SquareJsonSerializer implements Serializer<Square>{
  @Override
  public void serialize(Square square, OutputStream os) throws IOException {
    int x = square.getX();
    int y = square.getY();
    int side = square.getSide();

    String out = String.format("{\"Square\":{\"x\":%d,\"y\":%d,\"side\":%d}", x, y, side);

    os.write(out.getBytes());
  }
}
