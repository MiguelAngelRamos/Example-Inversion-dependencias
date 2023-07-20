package com.kibernunacademy.mvcproject.inversion.aplica.services;

import com.kibernunacademy.mvcproject.inversion.aplica.classes.EmailNotifier;
import com.kibernunacademy.mvcproject.inversion.aplica.interfaces.INotifier;
import com.kibernunacademy.mvcproject.inversion.noaplica.SmsNotifier;
import com.kibernunacademy.mvcproject.inversion.noaplica.WhatsAppNotifier;

public class NotifierService {

  private INotifier [] notifiers;

  public NotifierService(INotifier [] notifiers) {
    this.notifiers = notifiers;
  }

  public void notify(String message) {
    // ciclo for each

    for(INotifier notifier: notifiers) {
      notifier.send(message);
    }
  }

}
