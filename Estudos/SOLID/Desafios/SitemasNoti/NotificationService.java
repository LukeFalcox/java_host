package Desafios.SitemasNoti;

public class NotificationService {
 private final Notification notification;

 public NotificationService(Notification notification){
  this.notification = notification;
 }

 public void send(String message, String recipient){
  notification.send(message, recipient);
 }
}