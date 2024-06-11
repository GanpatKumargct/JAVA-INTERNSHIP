package Week2;

import java.util.List;

public class ClosestPairBruteForce {
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static double findClosestPair(List<Point> points) {
        double minDistance = Double.MAX_VALUE;

        int n = points.size();


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(points.get(i), points.get(j));
                if (dist < minDistance) {
                    minDistance = dist;
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        List<Point> points = DeliveryPointsGenerator.generateRandomPoints(1000);
        double closestDistance = findClosestPair(points);
        System.out.println("Closest Distance (Brute-Force): " + closestDistance);
    }
}

