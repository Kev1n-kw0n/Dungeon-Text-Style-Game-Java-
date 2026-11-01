package JavaGame;

public class DungeonLair {
   private String name;
   private int floors;

   public DungeonLair(String dungeonName, int dungeonFloors){
        dungeonName = name;
        dungeonFloors = floors;
   }
   public Characters spawnEnemy(){
        System.out.println("A wild golbin appears!");
        return new Characters("Goblin", 100, 10, 15);
   }
}