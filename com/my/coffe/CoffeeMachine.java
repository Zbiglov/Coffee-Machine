package machine.com.my.coffe;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker maker = new CoffeeMaker(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            System.out.println();
            switch (action) {
                case "buy":
                    maker.buy();
                    break;
                case "fill":
                    maker.fill();
                    break;
                case "take":
                    maker.take();
                    break;
                case "remaining":
                    maker.remaining();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unsuitable action, please, try again\n");
            }
        }
    }

    private enum TypeOfCoffee {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        int water;
        int coffeeBeans;
        int cost;
        int milk;

        TypeOfCoffee(int water, int milk, int coffeeBeans, int cost) {
            this.water = water;
            this.coffeeBeans = coffeeBeans;
            this.cost = cost;
            this.milk = milk;
        }

        public int getWater() {
            return water;
        }

        public int getMilk() {
            return milk;
        }

        public int getCoffeeBeans() {
            return coffeeBeans;
        }

        public int getCost() {
            return cost;
        }
    }

    private static class CoffeeMaker {
        int water;
        int milk;
        int coffeeBeans;
        int cups;
        int money;

        public CoffeeMaker(int water, int milk, int coffeeBeans, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.coffeeBeans = coffeeBeans;
            this.cups = cups;
            this.money = money;
        }
        public void notEnoughWater() {
            System.out.println("Sorry, not enough water!\n");
        }
        public void notEnoughCoffeeBeans() {
            System.out.println("Sorry, not enough coffee beans!\n");
        }
        public void notEnoughCups() {
            System.out.println("Sorry, not enough cups!\n");
        }
        public void notEnoughMilk() {
            System.out.println("Sorry, not enough milk!\n");
        }
        public void haveEnoughResources() {
            System.out.println("I have enough resources, making you a coffee!\n");
        }

        public void buy() {

            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            Scanner sc = new Scanner(System.in);
            switch (sc.next()) {
                case "1":
                    if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                        water -= TypeOfCoffee.ESPRESSO.getWater();
                        coffeeBeans -= TypeOfCoffee.ESPRESSO.getCoffeeBeans();
                        cups --;
                        money += TypeOfCoffee.ESPRESSO.getCost();
                        haveEnoughResources();
                        break;
                    } else if (water < 250) {
                        notEnoughWater();
                        break;
                    } else if (coffeeBeans < 16) {
                        notEnoughCoffeeBeans();
                        break;
                    } else if (cups == 0) {
                        notEnoughCups();
                        break;
                    }
                case "2":
                    if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                        water -= TypeOfCoffee.LATTE.getWater();
                        milk -= TypeOfCoffee.LATTE.getMilk();
                        coffeeBeans -= TypeOfCoffee.LATTE.getCoffeeBeans();
                        cups --;
                        money += TypeOfCoffee.LATTE.getCost();
                        haveEnoughResources();
                        break;
                    } else if (water < 350) {
                        notEnoughWater();
                        break;
                    } else if (milk < 75) {
                        notEnoughMilk();
                        break;
                    } else if (coffeeBeans < 20) {
                        notEnoughCoffeeBeans();
                        break;
                    } else if (cups == 0) {
                        notEnoughCups();
                        break;
                    }
                case "3":
                    if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
                        water -= TypeOfCoffee.CAPPUCCINO.getWater();
                        milk -= TypeOfCoffee.CAPPUCCINO.getMilk();
                        coffeeBeans -= TypeOfCoffee.CAPPUCCINO.getCoffeeBeans();
                        cups --;
                        money += TypeOfCoffee.CAPPUCCINO.getCost();
                        haveEnoughResources();
                        break;
                    } else if (water < 200) {
                        notEnoughWater();
                        break;
                    } else if (milk < 100) {
                        notEnoughMilk();
                        break;
                    } else if (coffeeBeans < 12) {
                        notEnoughCoffeeBeans();
                        break;
                    } else if (cups == 0) {
                        notEnoughCups();
                        break;
                    }
                case "back":
                    break;
                default:
                    System.out.println("Unsuitable action, please, try again\n");
            }
        }

        public void fill() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write how many ml of water do you want to add: ");
            water += scanner.nextInt();
            System.out.println("Write how many ml of milk do you want to add: ");
            milk += scanner.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add: ");
            coffeeBeans += scanner.nextInt();
            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            cups += scanner.nextInt();
            System.out.println();
        }

        public void take() {
            System.out.println("I gave you " + money + "\n");
            money = 0;
        }

        public void remaining() {
            System.out.println("The coffee machine has:\n" + water +
                    " of water\n" + milk +
                    " of milk\n" + coffeeBeans +
                    " of coffee beans\n" + cups +
                    " of disposable cups\n$" + money +
                    " of money\n");
        }
    }
}