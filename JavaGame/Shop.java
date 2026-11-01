package JavaGame;
import java.util.Scanner;

public class Shop {
    private String shopKeeper;
    private double shopDiscounts;

    public Shop(String shopKeeperName, double discounts){
        shopKeeper = shopKeeperName;
        shopDiscounts = discounts;
    }

    public String getShopKeeper(){
        return shopKeeper;
    }
    public Double getShopDiscounts(){
        return shopDiscounts;
    }

    public void shopMenu(Characters player, Scanner input){
        boolean shopping = true;
        int potionCost = 15;
        int potionHealAmount = 60;
        int steelSwordCost = 18;
        int swordAttack = 5;

        while(shopping){
            System.out.println("=====Welcome to " + shopKeeper + "'s Shop!");
            delay(1500);
            System.out.println("Your current gold: " + player.getCharGold());
            System.out.println("1.) Potion: " + potionCost);
            System.out.println("2.) Steel Sword: " + steelSwordCost);
            System.out.println("3.) Leave shop");
            System.out.println("Press one, two or three.");
            int choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                    if(player.getCharGold() >= potionCost){ //Checks if player has enough gold.
                        player.setGold(player.getCharGold() - potionCost); //Deduct your current gold amount.
                        player.setHealth(player.getCharHealth() + potionHealAmount); //Add the potion heal amount to the players current health.
                        System.out.println("Here you go hero! Please come again!");
                    }else {
                        System.out.println("You don't have enough gold.");
                    }
                    break;
                case 2:
                    if(player.getCharGold() >= steelSwordCost){
                        player.setGold(player.getCharGold() - steelSwordCost);
                        player.setAttack(player.getCharAttack() + swordAttack);
                        System.out.println("Here you go hero! Please come again!");
                        delay(1500);
                        System.out.println("You just added " + swordAttack + " to your base damage.");
                    }
                case 3:
                    shopping = false;
                    System.out.println("Thank you for shopping with us!");
                    delay(1000);
                    System.out.println("Come again!");
                    break;

                default:
                    System.out.println("Invalid input. Sending you back to shop menu...");
                    break;
            }
        }
    }
public static void delay(int milliseconds) {
    try {
        Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Java requires this block, but it can safely be left empty for basic text games
        }
    }
}