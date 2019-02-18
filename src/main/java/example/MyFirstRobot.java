package example;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.Battery;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class MyFirstRobot {

    public static void main(final String[] args){

        final EV3LargeRegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
        final EV3LargeRegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);


        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                motorLeft.stop();
                motorRight.stop();
            }
        }));

        motorLeft.brake();
        motorRight.brake();

        final int motorSpeed = 200;
        motorLeft.setSpeed(motorSpeed);
        motorRight.setSpeed(motorSpeed);

        motorLeft.forward();
        motorRight.forward();

        Delay.msDelay(2000);

        motorLeft.stop();
        motorRight.stop();

        motorLeft.backward();
        motorRight.backward();

        Delay.msDelay(2000);

        motorLeft.stop();
        motorRight.stop();

        System.out.println("Votage: " + Battery.getInstance().getVoltage());

        System.exit(0);
    }
}
