package ru.itpark;

import static org.junit.jupiter.api.Assertions.*;

class DepositCalculatorServiceTest {

    @org.junit.jupiter.api.Test
    void depositCalculate() {
        {
            double sumDeposit = 100_000;
            int period = 12;
            double percentDeposit = 10;
            String dateStart = "21.10.2018";

            DepositCalculatorService depositCalculator = new DepositCalculatorService();
            int deposit = depositCalculator.depositCalculate(sumDeposit, dateStart, period, percentDeposit);

            assertEquals(110_000, deposit);
        }
        {
            double sumDeposit = 150_000;
            int period = 14;
            double percentDeposit = 8;
            String dateStart = "21.10.2018";

            DepositCalculatorService depositCalculator = new DepositCalculatorService();
            int deposit = depositCalculator.depositCalculate(sumDeposit, dateStart, period, percentDeposit);

            assertEquals(164_005, deposit);
        }
        {
            double sumDeposit = 700_000;
            int period = 24;
            double percentDeposit = 9.2;
            String dateStart = "21.10.2018";

            DepositCalculatorService depositCalculator = new DepositCalculatorService();
            int deposit = depositCalculator.depositCalculate(sumDeposit, dateStart, period, percentDeposit);

            assertEquals(828_835, deposit);
        }

    }
}