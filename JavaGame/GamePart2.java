package JavaGame;
import java.util.Scanner;
import CustomProject.shop;

public class GamePart2 {
    public static final String GAME_VERSION = "v2.5.0";
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        int userInventory = 0;
        DungeonLair darkDungeon = new DungeonLair("The Dark Dungeon", 10);
        Characters player = null;
        Shop townShop = new Shop("Barnaby", 0.0);

    while(isRunning){
        System.out.println("=====Dungeon Quest=====");
        delay(1500);
        System.out.println("1.) Play");
        System.out.println("2.) Shop");
        System.out.println("3.) Exit");
        System.out.println("Press one, two, or three");
        int choice = input.nextInt();
        input.nextLine();

        delay(1500);
        switch(choice){
            case 1:
                choice = 0;
                Characters goblin = new Characters("Goblin", 100, 10, 15);
                System.out.println("Please choose between these characters: ");
                System.out.println("1.) Norra");
                System.out.println("2.) Alice");
                System.out.println("3.) Dante");
                System.out.println("Press one, two, or three.");

                int heroChoice = input.nextInt();
                input.nextLine();

                switch(heroChoice){
                    case 1:
                        player = new Characters("Norra", 100, 15, 0);
                        System.out.println("You chose Norra. Sending you to dungeon...");
                        delay(1500);
                        break;
                    case 2:
                        player = new Characters("Alice", 100, 19, 0);
                        System.out.println("You chose Alice. Sending you to dungeon...");
                        delay(1500);
                        break;
                    case 3:
                        player = new Characters("Dante", 100, 21, 0);
                        System.out.println("You chose Dante. Sending you to dungeon...");
                        delay(1500);
                        break;
                    default:
                        player = new Characters("Cyborg", 90, 20, 0);
                        System.out.println("Invalid input. Defaulting you to Cyborg. Sending you to dungeon...");
                        delay(1500);
                        break;
                }
            
                //for loop to determing the amount of floors.
                for(int floor = 1; floor <= 10; floor++){
                    Characters enemy = darkDungeon.spawnEnemy(); //Gets the enemy from dungeon class.
                    int playerGold = 0;

                    //Main game loop. Runs when player health and enemy health is above 0.
                    while(player.getCharHealth() > 0 && enemy.getCharHealth() > 0){
                        player.attack(enemy);
                        if(enemy.getCharHealth() > 0){
                            enemy.attack(player);
                        }
                    }
                    //Checks to see wether you cleared the floor or you died on the current floor you're on.
                    if(player.getCharHealth() <= 0){
                        System.out.println("You perished on floor "+ floor);
                        break;
                    }else{
                        System.out.println("You cleared floor " + floor);
                        if(floor < 10){
                            System.out.println("Preparing to descend to new floor...");
                            int goldReward = enemy.getCharGold();
                            int currentGold = player.getCharGold();
                            player.setGold(currentGold + goldReward);
                            System.out.println("You got gold!");
                            System.out.println("Current gold: " + player.getCharGold());
                        }
                    }
                }
                if(player.getCharHealth() > 0){
                    System.out.println("You cleared the final floor! Sending you back to main menu...");
                }
                break;
            case 2:
                System.out.println("Welcome to the Shop");
                townShop.shopMenu(player, input);
                break;
            case 3:
                System.out.println("Goodbye!");
                isRunning = false;
                break;
            default:
                System.out.println("Invalid input.");
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