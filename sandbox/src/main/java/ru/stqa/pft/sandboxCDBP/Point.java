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
        this.c = c;
        this.d = d;
    }

    public double distance () {
        return Math.sqrt((this.a - this.c) * (this.a - this.c) + (this.b - this.d) * (this.b - this.d));
    }

    public static double distance (double a, double b, double c, double d) {
        return Math.sqrt((a - c) * (a - c) + (b - d) * (b - d));
    }
}
