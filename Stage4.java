import java.util.Scanner;

public class Stage4 {
    
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void take() {
        System.out.println("I gave you $" + money);
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
    
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int chooseOneOption = scanner.nextInt();

        switch (chooseOneOption) {
            case 1: // needs 250 ml of water and 16 g of coffee beans. It costs $4
                water = water - 250;
                beans = beans - 16;
                cups = cups - 1;
                money = money + 4;
                break;
            case 2: // needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7
                water = water - 350;
                milk = milk - 75;
                beans = beans - 20;
                cups = cups - 1;
                money = money + 7;
                break;
            case 3: // needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6
                water = water - 200;
                milk = milk - 100;
                beans = beans - 12;
                cups = cups - 1;
                money = money + 6;
                break;
            default:
                break;
        }
    }

    public static void functions(Scanner scanner) {
        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();

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
            default:
                break;
        }
    }

    public static void coffeeMachineStage() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
    public static void main(String[] args) {
        coffeeMachineStage();
        System.out.println();
        functions(scanner);
        System.out.println();
        coffeeMachineStage();
    }
}