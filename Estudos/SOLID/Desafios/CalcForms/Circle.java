package Desafios.CalcForms;

public class Circle implements Shape{
  double raio;
  public Circle(double raio){
    this.raio = raio;
  }

  @Override
  public double calculateArea() {
    return 3.14 * raio;
  }
}
