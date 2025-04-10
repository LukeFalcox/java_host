public abstract class FactoryCars{
  public abstract Transporte createTransport();

  public void acel(){
    Transporte transport = createTransport();
    transport.mover();
  }
}
