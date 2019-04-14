package com.jimbo.raspi.led;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FlashLED {

    @PostConstruct
    public void run() throws Exception {

        // Create GPIO controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.HIGH);

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        pin.blink(1000);

        

    }
}
