package Desafios.AuthFlex;

public class AuthenticatorService {
  private final Authenticator authenticator;

  AuthenticatorService(Authenticator authenticator){
    this.authenticator = authenticator;
  }

  public void auth(String username, String password){
    authenticator.authenticate(username, password);
  }

}
