package Desafios.SitemasNoti;

public class SmsNotification implements Notification{
  @Override
  public void send(String message, String recipient) {
    System.out.println("Enviando SMS para "+ recipient +": "+ message);
  }
}
