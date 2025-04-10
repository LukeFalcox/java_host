public class Principal {
  public static void main(String[] args) {
    FactoryCars factoryCars;
    factoryCars = new PlaneFactory();
    factoryCars.acel();
    factoryCars = new CarFactory();
    factoryCars.acel();
    factoryCars = new TruckFactory();
    factoryCars.acel();
  }
}
