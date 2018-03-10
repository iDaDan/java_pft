package ru.stqa.pft.sandboxCDBP;

public class CalculateDistanceBetweenPoints {
    public static void main(String[] args) {
        hello("world");
        hello("freedom");
        hello("atheists");
        Point s = new Point();
        s.a = 3;
        s.b = 4;
        Point g = new Point();
        g.a = 10;
        g.b = 8;
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

    public static double area(Point s, Point g) {
        return Math.sqrt((s.a - g.a) *)
    }


}
