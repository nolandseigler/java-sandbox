//probably need to import this somehow? worked in codecademy.

import java.util.Arrays;

public class TransitCalculator {
    int daysUsingTransit;
    int totalNumberOfRides;
    String[] fareStrArr = {"Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};
    double[] fareDblArr = {2.75, 33.00, 127.00};
    //class constructor
    TransitCalculator(int days, int rides) {
        daysUsingTransit = days;
        totalNumberOfRides = rides;
    }
    //
    //method with return type of double that solves unlimited 7 day rides
    public double unlimited7Price() {
        double daysSeven = Math.ceil(daysUsingTransit / 7.0);
        double totalSevenDayCost = daysSeven * fareDblArr[1];
        return totalSevenDayCost / totalNumberOfRides;
    }
    //
    //get price per ride for each option
    public double[] getRidePrices() {
        double pricePerRide = fareDblArr[0];
        double unlimited7DayRides = unlimited7Price();
        double unlimited30DayRides = fareDblArr[2] / totalNumberOfRides;
        double[] ridePrices = {pricePerRide, unlimited7DayRides, unlimited30DayRides};
        return ridePrices;
    }
    //
    public String getBestFare() {
        double[] ridePrices = getRidePrices();
        int bestDealIndex = 0;

        for (int i = 0; i < ridePrices.length; i++) {
            if (ridePrices[i] < ridePrices[bestDealIndex]) {
                bestDealIndex = i;
            }
        }
        return "The best deal is the " + fareStrArr[bestDealIndex] + " package." + " It cost " + Math.round(ridePrices[bestDealIndex] * 100.0) / 100.0 + " per ride.";
    }
    public static void main(String[] args) {

    }
}
