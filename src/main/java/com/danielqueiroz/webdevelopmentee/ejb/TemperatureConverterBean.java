package com.danielqueiroz.webdevelopmentee.ejb;

import javax.ejb.Stateless;

@Stateless
public class TemperatureConverterBean implements  TemperatureConverterBeanLocal {

    @Override
    public double convertCelsiusToFahrenheit(double tc) {
        return 9 * (tc / 5) + 32;
    }

}
