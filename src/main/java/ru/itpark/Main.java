package ru.itpark;

public class Main {
    public static void main(String[] args) {

        int sumDeposit = 100_000;
        int period = 14;
        double percentDeposit = 10;
        String dateStart = "21.10.2018";

        DepositCalculatorService depositCalculator = new DepositCalculatorService();
        int deposit = depositCalculator.depositCalculate(sumDeposit, dateStart, period, percentDeposit);

        System.out.println(deposit);
    }

}
