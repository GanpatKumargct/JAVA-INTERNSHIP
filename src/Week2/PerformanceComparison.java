package Week2;

import java.util.List;

public class PerformanceComparison {
    public static void main(String[] args) {
        List<Point> points = DeliveryPointsGenerator.generateRandomPoints(1000);

        // Brute-force approach
        long startTime = System.currentTimeMillis();
        double bruteForceClosestDistance = ClosestPairBruteForce.findClosestPair(points);
        long endTime = System.currentTimeMillis();
        long bruteForceTime = endTime - startTime;
        double bruteForceTotalDistance = DroneDeliverySimulator.calculateTotalDistance(points);

        // Divide-and-conquer approach
        startTime = System.currentTimeMillis();
        double divideAndConquerClosestDistance = ClosestPairDivideAndConquer.findClosestPair(points);
        endTime = System.currentTimeMillis();
        long divideAndConquerTime = endTime - startTime;
        double divideAndConquerTotalDistance = DroneDeliverySimulator.calculateTotalDistance(points);

        System.out.println("Brute-Force:");
        System.out.println("Closest Distance: " + bruteForceClosestDistance);
        System.out.println("Total Distance: " + Math.ceil(bruteForceTotalDistance));
        System.out.println("Time Taken: " + bruteForceTime + " ms");

        System.out.println("\nDivide-and-Conquer:");
        System.out.println("Closest Distance: " + divideAndConquerClosestDistance);
        System.out.println("Total Distance: " + Math.ceil(divideAndConquerTotalDistance));
        System.out.println("Time Taken: " + divideAndConquerTime + " ms");
    }
}

