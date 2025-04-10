package Desafios.SitemasNoti;

public class Aplication {
  public static void main(String[] args) {
    Notification emailNotification = new EmailNotification();
    NotificationService emailService = new NotificationService(emailNotification);
    emailService.send("Olá, mundo", "user@example.com");

    Notification smsNotification = new SmsNotification();
    NotificationService smService  = new NotificationService(smsNotification);
    smService.send("Olá via SMS", "+5511999999999");
  }
}
