package ru.itpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositCalculatorServiceTest {

    @Test
    void depositCalculate() {
        {

            DepositCalculatorService depositCalculator = new DepositCalculatorService();
            int deposit = depositCalculator.depositCalculate(100_000, "21.10.2018", 12, 10);

            assertEquals(110_000, deposit);
        }
        {

            DepositCalculatorService depositCalculator = new DepositCalculatorService();
            int deposit = depositCalculator.depositCalculate(150_000, "21.10.2018", 14, 8);

            assertEquals(164_005, deposit);
        }
        {
            DepositCalculatorService depositCalculator = new DepositCalculatorService();
            int deposit = depositCalculator.depositCalculate(700_000, "21.10.2018", 24, 9.2);

            assertEquals(828_835, deposit);
        }

    }
}