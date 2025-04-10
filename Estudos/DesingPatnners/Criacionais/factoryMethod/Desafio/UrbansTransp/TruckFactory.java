public class TruckFactory extends FactoryCars{
  @Override
  public Transporte createTransport() {
    return new Truck();
  }
} 