public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Error: Negative values are not allowed.");
            return 0.0;
        }
        double pay = 0.0;

        switch (employeeType.toUpperCase()) {
            case "FULL_TIME":
                if (hoursWorked > 40) {
                    pay = (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
                } else {
                    pay = hoursWorked * hourlyRate;
                }
                break;

            case "PART_TIME":
                if (hoursWorked > 25) {
                    System.out.println("Warning: PART_TIME employee cannot work more than 25 hours. Using 25 hours.");
                    hoursWorked = 25;
                }
                pay = hoursWorked * hourlyRate;
                break;

            case "CONTRACTOR":
                pay = hoursWorked * hourlyRate;
                break;

            case "INTERN":
                if (hoursWorked > 20) {
                    System.out.println("Warning: INTERN cannot work more than 20 hours. Using 20 hours.");
                    hoursWorked = 20;
                }
                pay = hoursWorked * (hourlyRate * 0.8);
                break;

            default:
                System.out.println("Error: Invalid employee type (" + employeeType + ").");
        }

        return pay;
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double taxRate;
        if (grossPay <= 500) {
            taxRate = 0.10;
        } else if (grossPay <= 1000) {
            taxRate = 0.15;
        } else if (grossPay <= 2000) {
            taxRate = 0.20;
        } else {
            taxRate = 0.25;
        }

        double tax = grossPay * taxRate;
        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int n = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));

        double totalPay = 0;
        double highestPay = Double.MIN_VALUE;
        double lowestPay = Double.MAX_VALUE;
        String highestPaidEmployee = "";
        String lowestPaidEmployee = "";
        int overtimeCount = 0;

        System.out.printf("%-10s %-12s %-10s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Rate", "Gross", "Tax");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            double grossPay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(grossPay, true);
            double netPay = grossPay - tax;

            System.out.printf("%-10s %-12s %-10.2f %-10.2f %-10.2f %-10.2f\n",
                    names[i], employeeTypes[i], hours[i], rates[i], grossPay, tax);

            totalPay += netPay;

            if (grossPay > highestPay) {
                highestPay = grossPay;
                highestPaidEmployee = names[i];
            }

            if (grossPay < lowestPay) {
                lowestPay = grossPay;
                lowestPaidEmployee = names[i];
            }

            if (hours[i] > 40) {
                overtimeCount++;
            }
        }

        double averagePay = totalPay / n;

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Highest Paid: " + highestPaidEmployee + " ($" + highestPay + ")");
        System.out.println("Lowest Paid: " + lowestPaidEmployee + " ($" + lowestPay + ")");
        System.out.println("Average Net Pay: $" + String.format("%.2f", averagePay));
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    public static void main(String[] args) {

        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};


        double pay = calculateWeeklyPay("FULL_TIME", 45, 25.0);
        System.out.println("Alice's Weekly Pay: $" + pay);
        double tax = calculateTaxDeduction(pay, true);
        System.out.println("Alice's Tax: $" + tax);


        processPayroll(types, hours, rates, names);
    }
}