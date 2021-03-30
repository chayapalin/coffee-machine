import java.util.Scanner;

public class Stage3 {
    public static void main(String[] args) {
        /*
         * Stage 1 System.out.println("Starting to make a coffee");
         * System.out.println("Grinding coffee beans");
         * System.out.println("Boiling water");
         * System.out.println("Mixing boiled water with crushed coffee beans");
         * System.out.println("Pouring coffee into the cup");
         * System.out.println("Pouring some milk into the cup");
         * System.out.println("Coffee is ready!");
         */

        /*
         * Stage 2 Scanner scanner = new Scanner(System.in);
         * System.out.println("Write how many cups of coffee you will need:");
         * 
         * int amount = scanner.nextInt(); // The user should input the amount of coffee
         * he needs, in cups, for all the guests. int water = 200 * amount; // contains
         * 200 ml of water, int milk = 50 * amount; // 50 ml of milk, int beans = 15 *
         * amount; // and 15 g of coffee beans
         * 
         * System.out.println("For " + amount + " cups of coffee you will need:");
         * System.out.println(water + " ml of water"); System.out.println(milk +
         * " ml of milk"); System.out.println(beans + " g of coffee beans");
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        scanner.close();
        
        int waterRatio;
        int milkRatio;
        int beansRatio;

        if (cups == 0) {
            cups = cups + 1;
            waterRatio = water / cups;
            milkRatio = milk / cups;
            beansRatio = beans / cups;
        } else {
            waterRatio = water / cups;
            milkRatio = milk / cups;
            beansRatio = beans / cups;
        }
        
        int needWater = 200;
        int needMilk = 50;
        int needBeans = 15;

        int waterForHowManyCups = water / needWater;
        int milkForHowManyCups = milk / needMilk;
        int beansForHowManyCups = beans / needBeans;

        int minCups = Math.min(Math.min(waterForHowManyCups, milkForHowManyCups), beansForHowManyCups);
        int additionalCups = 0;
        int possibleMaxAmount = 0;

        // The coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee
        // beans to make one cup of coffee.
        if (waterRatio >= needWater && milkRatio >= needMilk && beansRatio >= needBeans) {
            if (waterForHowManyCups >= 0 && milkForHowManyCups >= 0 && beansForHowManyCups >= 0) {
                // If the coffee machine can make more than that, the program should output
                // "Yes, I can make that amount of coffee (and even N more than that)",
                // where N is the number of additional cups of coffee that the coffee machine can make.
                if (minCups > cups) {
                    additionalCups = minCups - cups;
                    System.out.println("Yes, I can make that amount of coffee (and even " + additionalCups + " more than that)");
                } else if (minCups == cups) {
                    // If the coffee machine has enough supplies to make the specified amount of coffee,
                    // the program should print "Yes, I can make that amount of coffee".
                    System.out.println("Yes, I can make that amount of coffee");
                }
            }
        } else {
            // If the amount of resources is not enough to make the specified amount of coffee,
            // the program should output "No, I can make only N cup(s) of coffee".
            possibleMaxAmount = minCups;
            System.out.println("No, I can make only " + possibleMaxAmount + " cup(s) of coffee");
        }
    }
}