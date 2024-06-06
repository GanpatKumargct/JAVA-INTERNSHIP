package Week1.EMS;

import java.util.*;

public class PerformanceTracking {
    private Map<Integer, Map<String, Double>> performanceMetrics; // Employee ID -> Metric Name -> Value
    private Map<Integer, List<String>> feedback; // Employee ID -> List of feedback
    private Map<Integer, Integer> attendanceRecords; // Employee ID -> Attendance count

    // Constructor
    public PerformanceTracking() {
        this.performanceMetrics = new HashMap<>();
        this.feedback = new HashMap<>();
        this.attendanceRecords = new HashMap<>();
    }

    // Method to track performance for an employee
    public void trackPerformance(int employeeId, String metric, double value) {
        performanceMetrics.putIfAbsent(employeeId, new HashMap<>());
        performanceMetrics.get(employeeId).put(metric, value);
    }

    // Method to add feedback for an employee
    public void addFeedback(int employeeId, String feedbackEntry) {
        feedback.putIfAbsent(employeeId, new ArrayList<>());
        feedback.get(employeeId).add(feedbackEntry);
    }

    // Method to track attendance for an employee
    public void trackAttendance(int employeeId, int daysAttended) {
        attendanceRecords.put(employeeId, daysAttended);
    }

    // Method to generate performance reports for an employee
    public void generateReport(int employeeId) {
        System.out.println("Performance Report for Employee ID: " + employeeId);
        System.out.println("Performance Metrics: " + performanceMetrics.getOrDefault(employeeId, Collections.emptyMap()));
        System.out.println("Feedback: " + feedback.getOrDefault(employeeId, Collections.emptyList()));
        System.out.println("Attendance: " + attendanceRecords.getOrDefault(employeeId, 0) + " days");
    }

    // Method to identify top performers
    public void identifyTopPerformers() {
        System.out.println("Top Performers:");
        // Simple logic to identify top performers based on a single metric "productivity"
        performanceMetrics.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().getOrDefault("productivity", 0.0), e1.getValue().getOrDefault("productivity", 0.0)))
                .limit(5)
                .forEach(entry -> System.out.println("Employee ID: " + entry.getKey() + ", Productivity: " + entry.getValue().get("productivity")));
    }
}

