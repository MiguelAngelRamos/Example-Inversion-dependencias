package com.kibernunacademy.mvcproject.inversion.aplica.classes;

import com.kibernunacademy.mvcproject.inversion.aplica.interfaces.INotifier;

public class SmsNotifier implements INotifier {

  @Override
  public void send(String message) {
    System.out.println("Enviando un mensaje de Sms: " + message);
  }
}
