package abstractFactory;

public class Cliente {
  private Chair chair;
  private Tabble tabble;

  public Cliente(GUIFactory factory){
    chair = factory.createChair();
    tabble = factory.createTabble();
  }

  public void renderUI(){
    chair.sitOn();
    tabble.sitOn();
  }


}
