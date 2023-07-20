package com.kibernunacademy.mvcproject.inversion.noaplica;

public class Main {

  public static void main(String[] args) {
    // vamos a crear una instancia del Servicio

    NotifierService service = new NotifierService();

    service.notify("Hola Mundo, para el curso de Microservicios");
  }
}
