This is my basic proof of concept to have a Spring Boot application running on a Raspberry PI that I can use to control the GPIO pins.
It simply blinks an LED.
I use it as a basic test that everything is set up correctly (Java, WiringPi, pi4j etc.).
The goal is, obviously, not to simply flash an LED but to get Spring Boot running so that I can take advantage of all of its features in addition to being able to control the GPIO.
For example, I could access a webpage being served by the Pi and remotely turn on a device in my house/garden.

The project uses gradle to manage dependencies and builds.

It needs to be compiled with Java 1.8 as I didn't get around to adding Java10 to my RaspPi (which is tricky and wasn't the part of the problem I was trying to solve).

To build an executable Jar, just do a "gradle build" from command line.
This creates a led-1.0-SNAPSHOT-boot.jar in the build/libs directory.

To run the jar, do:

`java -jar led-1.0-SNAPSHOT-boot.jar`.

This will run the code as a Spring Boot application.

You will need to install WiringPi on your RaspberryPi by doing:

`cd /tmp`

 `wget https://lion.drogon.net/wiringpi-2.50-1.deb`
 
 `sudo dpkg -i wiringpi-2.50-1.deb`
 
 The GPIO is controlled through pi4j. I found that I had to update my Pi to use the latest Kernal, otherwise I got a "Unable to determine hardware version" error.
 To do the upgrade, do:
 
 `sudo apt-get update`
 
 `sudo apt-get dist-upgrade`