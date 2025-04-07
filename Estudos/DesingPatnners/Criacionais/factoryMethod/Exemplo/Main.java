public class Main {
  public static void main(String[] args) {
    Logistics logistics; // Criação de uma Classe Abstrata

    logistics = new RoadLogistics();// Cria um objeto da logistica de carro
    logistics.planDelivery(); // Chama a a função responsavel pela criação de carro
    //! A função planDelivery é extendida da classe Logistic

    logistics = new SeaLogistics();// Cria um objeto da logistica de navio
    logistics.planDelivery(); // Chama a a função responsavel pela criação de navio
    //! A função planDelivery é extendida da classe Logistic
  }
}
