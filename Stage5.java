import java.util.Scanner;

public class Stage5 {

    static Scanner scanner = new Scanner(System.in);

    // initial resources
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void coffeeMachineResources() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        System.out.println();
        money = money - money;
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        int fillWater = scanner.nextInt();
        water = water + fillWater;
        System.out.println("Write how many ml of milk do you want to add: ");
        int fillMilk = scanner.nextInt();
        milk = milk + fillMilk;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int fillBeans = scanner.nextInt();
        beans = beans + fillBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int fillCups = scanner.nextInt();
        cups = cups + fillCups;
    }

    public static void cappuccino() {
        int waterCounter = water / 200;
        int milkCounter = milk / 100;
        int beansCounter = beans / 12;
        int minimum = Math.min(Math.min(waterCounter, milkCounter), beansCounter);

        if (0 < minimum && minimum <= cups) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            // how many do ingredients remain?
            water = water - 200;
            milk = milk - 100;
            beans = beans - 12;
            cups = cups - 1;
            money = money + 6;
        } else {
            System.out.println("Sorry, not enough water!");
            System.out.println();
        }
    }

    public static void latte() {
        int waterCounter = water / 350;
        int milkCounter = milk / 75;
        int beansCounter = beans / 20;
        int minimum = Math.min(Math.min(waterCounter, milkCounter), beansCounter);

        if (0 < minimum && minimum <= cups) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            // how many do ingredients remain?
            water = water - 350;
            milk = milk - 75;
            beans = beans - 20;
            cups = cups - 1;
            money = money + 7;
        } else {
            System.out.println("Sorry, not enough water!");
            System.out.println();
        }
    }

    public static void espresso() {
        int waterCounter = water / 250;
        int beansCounter = beans / 16;
        int minimum = Math.min(waterCounter, beansCounter);

        if (0 < minimum && minimum <= cups) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            // how many do ingredients remain?
            water = water - 250;
            beans = beans - 16;
            cups = cups - 1;
            money = money + 4;
        } else {
            System.out.println("Sorry, not enough water!");
            System.out.println();
        }
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String chooseOneOption = scanner.nextLine();

        switch (chooseOneOption) {
            case "1": // needs 250 ml of water and 16 g of coffee beans. It costs $4
                espresso();
                break;
            case "2": // needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7
                latte();
                break;
            case "3": // needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6
                cappuccino();
                break;
            case "back":
                functions();
                break;
            default:
                break;
        }
    }

    public static void functions() {
        String action = "";
        while (scanner.hasNextLine()) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            System.out.println();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    coffeeMachineResources();
                    break;
                case "exit":
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        functions();
    }
}