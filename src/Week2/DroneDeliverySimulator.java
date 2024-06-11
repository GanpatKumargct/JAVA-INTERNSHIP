package Week2;

import java.util.List;

public class DroneDeliverySimulator {
    public static double calculateTotalDistance(List<Point> points) {
        double totalDistance = 0;
        for (int i = 1; i < points.size(); i++) {
            totalDistance += ClosestPairBruteForce.distance(points.get(i - 1), points.get(i));
        }
        return totalDistance;
    }

    public static void main(String[] args) {
        List<Point> points = DeliveryPointsGenerator.generateRandomPoints(1000);
        double bruteForceDistance = ClosestPairBruteForce.findClosestPair(points);
        double divideAndConquerDistance = ClosestPairDivideAndConquer.findClosestPair(points);

        System.out.println("Total Distance (Brute-Force): " + bruteForceDistance);
        System.out.println("Total Distance (Divide-and-Conquer): " + divideAndConquerDistance);
    }
}

