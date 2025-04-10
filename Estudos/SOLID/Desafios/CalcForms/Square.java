package Desafios.CalcForms;

public class Square implements Shape{
  private double lado;

  public Square(double lado){
    this.lado = lado;
  }

  @Override
  public double calculateArea() {
    return lado * lado;
  }

}
