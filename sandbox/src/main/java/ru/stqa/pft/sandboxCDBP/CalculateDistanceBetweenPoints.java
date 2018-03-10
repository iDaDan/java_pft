package ru.stqa.pft.sandboxCDBP;

public class CalculateDistanceBetweenPoints {
    public static void main(String[] args) {
        Point s = new Point();
        s.a = 3;
        s.b = 4;
        Point g = new Point();
        g.a = 10;
        g.b = 8;
        System.out.println("Расстояние между точками равно " + distance(s, g));
    }

    public static double distance (Point s, Point g) {
        return Math.sqrt((s.a - g.a) * (s.a - g.a) + (s.b - g.b) * (s.b - g.b));
    }


}
