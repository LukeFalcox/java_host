package abstractFactory;

public class ModernFactory implements GUIFactory{
  @Override
  public Chair createChair() {
    return new ModernChair();
  }
  @Override
  public Tabble createTabble() {
    return new ModernTabble();
  }
}
