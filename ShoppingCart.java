public class ShoppingCart {
    public static double calculateTotal(double[] prices, String customerType) {
        if (prices == null || prices.length == 0) return 0;

        double total = 0;

        for (double price : prices) {
            total += price;
        }


        switch (customerType.toUpperCase()) {
            case "PREMIUM":
                total *= 0.9;
                break;
            case "VIP":
                total *= 0.8;
                break;
            case "REGULAR":
            default:

                break;
        }

        return total;
    }


    public static double findMostExpensive(double[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        double maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
        }
        return maxPrice;
    }


    public static int countExpensiveItems(double[] prices, double threshold) {
        if (prices == null) return 0;

        int count = 0;
        for (double price : prices) {
            if (price > threshold) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};


        System.out.println("Regular customer total: $" + calculateTotal(cart, "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart, "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart, "VIP"));


        double maxItem = findMostExpensive(cart);
        System.out.println("Most expensive item: $" + maxItem);


        int expensiveCount = countExpensiveItems(cart, 30);
        System.out.println("Items over $30: " + expensiveCount);
    }
}
