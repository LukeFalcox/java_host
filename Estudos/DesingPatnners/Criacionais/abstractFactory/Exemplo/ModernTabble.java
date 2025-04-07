package abstractFactory;

public class ModernTabble implements Tabble{
  @Override
  public void hasLegs() {
    System.out.println("4 pernas grossas");
  }

  @Override
  public void sitOn() {
    System.out.println("Mesa Moderna");
  }
}
