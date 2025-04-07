package abstractFactory;

public class VictorianChair implements Chair{
@Override
public void hasLegs() {
  System.out.println("tem duas pernas");
}
@Override
public void sitOn() {
System.out.println("Uma cadeira da realeza");
}
}
