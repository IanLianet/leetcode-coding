package org.ianlai.dailyTest;

/**
 * hsbc test1
 *
 * @author IanLai
 * @date 2023-01-18 17:27:40
 */
public class InsuranceBenefitCalculation {

    public static void main(String[] args) {

        double cost1 = 3600;
        double cost2 = 3990;
        double annualInflationRatio = 0.017;
        double costPerYear = cost1 + cost2;
        double totalCost = 0;

        int i = 0;
        while (i < 20) {
            totalCost = totalCost * (1 + annualInflationRatio);
            totalCost += costPerYear;
            System.out.println("第" + (i + 1) + "年:" + totalCost);
            i++;
        }
        while (i < 40) {
            totalCost = totalCost * (1 + annualInflationRatio);
            System.out.println("第" + (i + 1) + "年:" + totalCost);
            i++;
        }


    }

}

