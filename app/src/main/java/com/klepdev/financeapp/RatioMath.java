package com.klepdev.financeapp;

public class RatioMath {

    public static double currentRatio(double curAsset, double curLiab) {
        return curAsset / curLiab;
    }
    public static double acidTestRatio(double curAsset, double inventory, double curLiab) {
        return (curAsset - inventory) / curLiab;
    }
    public static double cashRatio(double securities, double curLiab) {
        return securities / curLiab;
    }
    public static double invTurnover(double salesOrCostOfGoodsSold, double inventory) {
        return salesOrCostOfGoodsSold / inventory;
    }
    public static double daysSalesInInv(double inventory, boolean leapYear, double salesOrCostOfGoodsSold) {
        int numOfDays = 365;
        if(leapYear) numOfDays = 366;
        return (inventory * numOfDays) / salesOrCostOfGoodsSold;
    }
    public static double aRTurnover(double creditSales, double accountsReceivable) {
        return creditSales / accountsReceivable;
    }
    public static double averageCollectPeriod(double accountsReceivable, boolean leapYear, double creditSales) {
        int numOfDays = 365;
        if(leapYear) numOfDays = 366;
        return (accountsReceivable * numOfDays) / creditSales;
    }
    public static double aPTurnover(double costOfGoodsSold, double accountsPayable) {
        return costOfGoodsSold / accountsPayable;
    }
    public static double averagePaymentPeriod(double accountsPayable, boolean leapYear, double costOfGoodsSold) {
        int numOfDays = 365;
        if(leapYear) numOfDays = 366;
        return (accountsPayable * numOfDays) / costOfGoodsSold;
    }
    public static double fixedAssetTurnover(double sales, double netFixedAssets) {
        return sales / netFixedAssets;
    }
    public static double salesToWorkingCapital(double sales, double workingCapital) {
        return sales / workingCapital;
    }
    public static double salesToWorkingCapital(double sales, double curAsset, double curLiab) {
        return sales / (curAsset - curLiab);
    }
    public static double totalAssetTurnover(double sales, double totalAsset) {
        return sales / totalAsset;
    }
    public static double capitalIntensity(double totalAsset, double sales) {
        return totalAsset / sales;
    }
    public static double debtRatio(double totalDebt, double totalAsset) {
        return totalDebt / totalAsset;
    }
    public static double debtToEquity(double totalDebt, double totalEquity) {
        return totalDebt / totalEquity;
    }

}
