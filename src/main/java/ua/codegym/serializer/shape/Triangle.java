package ua.codegym.serializer.shape;

public class Triangle extends AbstractShape {
  int xA, yA, xB, yB, xC, yC;

  public Triangle(int xA, int yA, int xB, int yB, int xC, int yC) {
    this.xA = xA;
    this.yA = yA;
    this.xB = xB;
    this.yB = yB;
    this.xC = xC;
    this.yC = yC;
  }

  public int getxA() {
    return xA;
  }

  public int getyA() {
    return yA;
  }

  public int getxB() {
    return xB;
  }

  public int getyB() {
    return yB;
  }

  public int getxC() {
    return xC;
  }

  public int getyC() {
    return yC;
  }
}
