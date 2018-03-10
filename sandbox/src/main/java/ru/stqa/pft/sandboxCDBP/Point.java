package ru.stqa.pft.sandboxCDBP;

public class Point {
    public double a;
    public double b;
    public double c;
    public double d;

    public Point (double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Point (double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
    }

    public static double distance () {
        return Math.sqrt((this.a - this.c) * (this.a - this.c) + (this.b - this.d) * (this.b - this.d));
    }


}
