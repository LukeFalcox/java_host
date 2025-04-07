package abstractFactory;

public class VictorianTabble implements Tabble{
  @Override
  public void hasLegs() {
    System.out.println("4 pernas finas");
  }
  @Override
  public void sitOn() {
    System.out.println("Mesa da Realeza");
  }
}
