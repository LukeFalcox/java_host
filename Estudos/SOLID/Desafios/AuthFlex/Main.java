package Desafios.AuthFlex;

public class Main {
  public static void main(String[] args) {
    Authenticator authenticator = new FacebookAuth();
    AuthenticatorService authenticatorService = new AuthenticatorService(authenticator);
    authenticatorService.auth("TesteNEW", "123452");
    
  }
}
