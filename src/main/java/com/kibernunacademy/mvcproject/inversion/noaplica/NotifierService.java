package com.kibernunacademy.mvcproject.inversion.noaplica;

public class NotifierService {

  private EmailNotifier emailNotifier;
  private WhatsAppNotifier whatsAppNotifier;
  private SmsNotifier smsNotifier;
  public NotifierService() {
    this.emailNotifier = new EmailNotifier();
    this.whatsAppNotifier = new WhatsAppNotifier();
    this.smsNotifier = new SmsNotifier();
  }

  public void notify(String message) {
    emailNotifier.sendEmail(message);
    whatsAppNotifier.sendWhatsApp(message);
    smsNotifier.sendSms(message);
  }

}
