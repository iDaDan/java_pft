package ru.stqa.pft.sandboxCDBP;

public class CalculateDistanceBetweenPoints {
    public static void main(String[] args) {
        Point s = new Point(3, 4);
        Point g = new Point(10,8);
        Point f = new Point (3, 4, 5, 6); //вариант 1 - через другой конструктор
        System.out.println("Расстояние между точками равно " + distance(s, g));
        System.out.println("Расстояние между точками равно " + f.distance());
    }

    public static double distance (Point p1, Point p2) {
        return Math.sqrt((p1.a - p2.a) * (p1.a - p2.a) + (p1.b - p2.b) * (p1.b - p2.b));
    }


}
