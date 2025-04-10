package Desafios.AuthFlex;

public class FacebookAuth implements Authenticator{
    @Override
    public void authenticate(String username, String password) {
      System.out.println("Authenticação do User: "+username+", Password: "+password+", no FACEBOOK");   
    }
}
