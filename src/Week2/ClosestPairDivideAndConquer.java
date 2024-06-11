package Week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ClosestPairDivideAndConquer {
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static double closestPairRec(List<Point> points, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        int mid = left + (right - left) / 2;
        Point midPoint = points.get(mid);

        double dl = closestPairRec(points, left, mid);
        double dr = closestPairRec(points, mid + 1, right);
        double d = Math.min(dl, dr);

        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points.get(i).x - midPoint.x) < d) {
                strip.add(points.get(i));
            }
        }

        return Math.min(d, stripClosest(strip, d));
    }

    public static double bruteForce(List<Point> points, int left, int right) {
        double min = Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double dist = distance(points.get(i), points.get(j));
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    public static double stripClosest(List<Point> strip, double d) {
        double min = d;
        Collections.sort(strip, Comparator.comparingInt(point -> point.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; j++) {
                double dist = distance(strip.get(i), strip.get(j));
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    public static double findClosestPair(List<Point> points) {
        List<Point> pointsSortedByX = new ArrayList<>(points);
        pointsSortedByX.sort(Comparator.comparingInt(point -> point.x));

        return closestPairRec(pointsSortedByX, 0, pointsSortedByX.size() - 1);
    }

    public static void main(String[] args) {
        List<Point> points = DeliveryPointsGenerator.generateRandomPoints(1000);
        double closestDistance = findClosestPair(points);
        System.out.println("Closest Distance (Divide-and-Conquer): " + closestDistance);
    }
}

