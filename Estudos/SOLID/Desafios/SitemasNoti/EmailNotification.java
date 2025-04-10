package Desafios.SitemasNoti;

public class EmailNotification implements Notification{
    @Override
    public void send(String message, String recipient) {
      System.out.println("Enviando Email para"+ recipient+": "+message);
    }
}
