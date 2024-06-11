package Week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class DeliveryPointsGenerator {
    public static List<Point> generateRandomPoints(int n) {
        Random rand = new Random();
        List<Point> points = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            points.add(new Point(rand.nextInt(101), rand.nextInt(101)));
        }
        return points;
    }

    public static void main(String[] args) {
        List<Point> points = generateRandomPoints(1000);
        for (Point point : points) {
            System.out.println(point);
        }
    }
}

