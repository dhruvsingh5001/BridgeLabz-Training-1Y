import java.util.*;
import java.time.*;

class Policy implements Comparable<Policy> {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    public Policy(int policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return this.policyNumber == p.policyNumber;
    }

    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | " + expiryDate + " | " + coverageType + " | " + premium;
    }
}

class PolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedSet.add(p);
        treeSet.add(p);
    }

    public void showAll() {
        for (Policy p : hashSet) {
            System.out.println(p);
        }
    }

    public void expiringSoon() {
        LocalDate today = LocalDate.now();
        for (Policy p : hashSet) {
            if (!p.expiryDate.isBefore(today) && p.expiryDate.isBefore(today.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    public void filterByType(String type) {
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void showSorted() {
        for (Policy p : treeSet) {
            System.out.println(p);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PolicyManager pm = new PolicyManager();

        pm.addPolicy(new Policy(101, "Amit", LocalDate.now().plusDays(10), "Health", 5000));
        pm.addPolicy(new Policy(102, "Rahul", LocalDate.now().plusDays(40), "Auto", 7000));
        pm.addPolicy(new Policy(103, "Neha", LocalDate.now().plusDays(20), "Home", 6000));
        pm.addPolicy(new Policy(101, "Amit", LocalDate.now().plusDays(10), "Health", 5000));

        System.out.println("All Policies:");
        pm.showAll();

        System.out.println("\nExpiring Soon:");
        pm.expiringSoon();

        System.out.println("\nHealth Policies:");
        pm.filterByType("Health");

        System.out.println("\nSorted by Expiry:");
        pm.showSorted();
    }
}