package bai_4_oop.bai_tap.Fan;

public class Fan {

    int speed = 1;
    boolean on = false;
    double radius = 5;
    String color = "blue";

    public Fan( int speed, boolean on, double radius, String color) {

        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String message = "";

        if (isOn()) {
            message += "speed: " + this.speed + "\n color: " + this.color + "\nRadius: " + this.radius + " \nFan is on";
        } else {
            message += "speed: " + this.speed + "\ncolor: " + this.color + "\nRadius: " + this.radius + " \nFan is off";
        }
        return message;
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan( 3 , true, 10,"yellow" );
        Fan fan2 = new Fan(2,false,5,"blue");
        System.out.println(" Fan 1:" + fan1.toString() );
        System.out.println(" Fan 2:" + fan2.toString() );
    }
}
