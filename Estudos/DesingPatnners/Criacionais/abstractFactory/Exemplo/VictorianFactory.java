package abstractFactory;

public class VictorianFactory implements GUIFactory{
   @Override
   public Chair createChair() {
     return new VictorianChair();
   }

   @Override
   public Tabble createTabble() {
     return new VictorianTabble();
   }
}
