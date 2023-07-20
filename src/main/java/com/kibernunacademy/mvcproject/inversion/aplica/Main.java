package com.kibernunacademy.mvcproject.inversion.aplica;

import com.kibernunacademy.mvcproject.inversion.aplica.classes.EmailNotifier;
import com.kibernunacademy.mvcproject.inversion.aplica.classes.SmsNotifier;
import com.kibernunacademy.mvcproject.inversion.aplica.classes.TwitterNotifier;
import com.kibernunacademy.mvcproject.inversion.aplica.classes.WhatsAppNotifier;
import com.kibernunacademy.mvcproject.inversion.aplica.interfaces.INotifier;
import com.kibernunacademy.mvcproject.inversion.aplica.services.NotifierService;


public class Main {

  public static void main(String[] args) {

    INotifier [] notifiers = new INotifier[] {
            new EmailNotifier(),
            new WhatsAppNotifier(),
            new SmsNotifier(),
            new TwitterNotifier()
    };

    NotifierService service = new NotifierService(notifiers);

    service.notify("Hola a todos desde curso de Microservicios con SpringBoot con Inversion de dependencias");
  }
}
