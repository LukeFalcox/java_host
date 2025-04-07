package abstractFactory;

public class ModernChair implements Chair{
  @Override
  public void hasLegs() {
    System.out.println("tem duas 4");
  }
  @Override
  public void sitOn() {
  System.out.println("Uma cadeira da moderna");
  }
}
