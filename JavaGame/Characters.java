package JavaGame;

public class Characters {
    private String charName;
    private int charHealth;
    private int charAttack;
    private int charGold;

    //constructor:
    public Characters(String name, int health, int attack, int gold){
           charName = name;
           charHealth = health;
           charAttack = attack;
           charGold = gold;
    }
    
    //Below are getters.
    public String getCharName(){
        return charName;
    }
    public int getCharHealth(){
        return charHealth;
    }
    public int getCharGold(){
        return charGold;
    }
    public int getCharAttack(){
        return charAttack;
    }

    //Below is to safely adjust and control the player hp, gold, and attack values.
    public void setHealth(int newCharHP){
        if(newCharHP < 0){
            charHealth = 0;
        }else {
            charHealth = newCharHP;
        }
    }
    public void setGold(int newCharGold){
        charGold = newCharGold;
    }
    public void setAttack(int newAttackVal){
        charAttack = newAttackVal;
    }

    public void attack(Characters target){ //Below is the attack sequence of the dungeon game.
        System.out.println(charName + " attacks " + target.getCharName() + "!");
        int newHealth = target.getCharHealth() - charAttack;
        target.setHealth(newHealth);
        System.out.println(target.getCharName() + " has " + target.getCharHealth() + " health left.");
    }
}