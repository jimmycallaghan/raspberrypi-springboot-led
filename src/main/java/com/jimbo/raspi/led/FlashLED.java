package com.jimbo.raspi.led;

import com.pi4j.io.gpio.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FlashLED {

    private static final Logger logger = LogManager.getLogger(FlashLED.class.getName());

    @PostConstruct
    public void run() {

        final GpioController gpio;

        try {
            gpio = GpioFactory.getInstance();
            final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.HIGH);

            // set shutdown state for this pin
            pin.setShutdownOptions(true, PinState.LOW);

            logger.info("--> GPIO state should toggle every second, for five minutes.");
            pin.blink(1000);

            // Just keep the service running for 5 minutes
            Thread.sleep(5 * 60 * 1000);

        } catch (Exception e) {
            logger.error("Something went wrong", e);
        } finally {
            if (gpio !=null) gpio.shutdown();
        }




    }
}
