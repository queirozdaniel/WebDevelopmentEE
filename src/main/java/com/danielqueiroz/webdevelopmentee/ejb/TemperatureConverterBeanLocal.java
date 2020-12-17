package com.danielqueiroz.webdevelopmentee.ejb;

import javax.ejb.Local;

@Local
public interface TemperatureConverterBeanLocal {

    double convertCelsiusToFahrenheit(double tc);
}
