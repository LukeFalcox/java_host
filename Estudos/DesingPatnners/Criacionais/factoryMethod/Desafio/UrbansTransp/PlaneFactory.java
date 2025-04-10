public class PlaneFactory extends FactoryCars {
  @Override
  public Transporte createTransport() {
    return new Plane();
  }
}
