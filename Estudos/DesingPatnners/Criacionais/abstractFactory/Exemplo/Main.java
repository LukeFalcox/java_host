package abstractFactory;

public class Main {
  public static void main(String[] args) {
    GUIFactory factory;

    String os = "Victorian";
    if (os == "Victorian") {
      factory = new VictorianFactory();
    } else {
      factory = new ModernFactory();
    }

    Cliente app = new Cliente(factory);
    app.renderUI();
  }
}
