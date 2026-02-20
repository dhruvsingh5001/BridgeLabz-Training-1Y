package com.bank.util;

import static java.lang.Math.*;

public class InterestCalculator {

    public static double calculateSimpleInterest(double P, double R, double T) {
        double SI = (P * R * T) / 100;
        return SI;
    }

    public static double calculateCompoundInterest(double P, double R, double T) {
        double CI = P * (pow((1 + R / 100), T)) - P;
        return CI;
    }
}
