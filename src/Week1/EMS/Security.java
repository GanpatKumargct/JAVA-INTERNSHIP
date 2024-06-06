package Week1.EMS;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    private Map<String, String> userCredentials; // Username -> Hashed Password
    private Map<String, String> userRoles; // Username -> Role (e.g., "employee", "admin")
    private Map<String, List<String>> accessControlPolicies; // Role -> List of allowed functions
    private String encryptionKey;

    // Constructor
    public Security(String encryptionKey) {
        this.userCredentials = new HashMap<>();
        this.userRoles = new HashMap<>();
        this.accessControlPolicies = new HashMap<>();
        this.encryptionKey = encryptionKey;
        initializeDefaultPolicies();
    }

    // Method to initialize default access control policies
    private void initializeDefaultPolicies() {
        accessControlPolicies.put("employee", Arrays.asList("view_self_info", "update_self_info"));
        accessControlPolicies.put("admin", Arrays.asList("view_all_info", "update_all_info", "manage_users"));
    }

    // Method to authenticate a user
    public boolean authenticateUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(hashedPassword);
    }

    // Method to enforce access control
    public boolean enforceAccessControl(String username, String function) {
        String role = userRoles.get(username);
        return role != null && accessControlPolicies.get(role).contains(function);
    }

    // Method to hash a password
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to encrypt data (simplified example)
    public String encryptData(String data) {
        // For simplicity, we'll use a basic XOR encryption with the encryption key
        char[] key = encryptionKey.toCharArray();
        char[] dataChars = data.toCharArray();
        char[] encryptedData = new char[data.length()];

        for (int i = 0; i < data.length(); i++) {
            encryptedData[i] = (char) (dataChars[i] ^ key[i % key.length]);
        }

        return new String(encryptedData);
    }

    // Method to change user credentials
    public void changeCredentials(String username, String newPassword) {
        if (userCredentials.containsKey(username)) {
            userCredentials.put(username, hashPassword(newPassword));
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to add a new user
    public void addUser(String username, String password, String role) {
        if (!userCredentials.containsKey(username)) {
            userCredentials.put(username, hashPassword(password));
            userRoles.put(username, role);
        } else {
            System.out.println("User already exists.");
        }
    }

    // Getters and Setters
    public Map<String, String> getUserCredentials() {
        return userCredentials;
    }

    public Map<String, String> getUserRoles() {
        return userRoles;
    }

    public Map<String, List<String>> getAccessControlPolicies() {
        return accessControlPolicies;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }
}

