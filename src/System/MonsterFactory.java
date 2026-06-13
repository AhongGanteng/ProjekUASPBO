package System;
import MakhlukHidup.*;
import Interface.*;
import Items.*;
/**
 * semacam sistem untuk spawn monster
 */
public class MonsterFactory {
    private static Enemy musuh;
    /**
     * ini sistemnya, jadi monster akan muncul dilantai berbeda
     * @param nomorLantai
     * @return bangun monsternya
     */
    
    public static Enemy bangunMusuh(int nomorLantai) {
        return switch (nomorLantai) {
            case 1 -> bangunSlime();
            case 2 -> bangunGoblin();
            case 3 -> bangunSkeleton();
            case 4 -> bangunDarkKnight();
            case 5 -> bangunBossDragon();
            default -> null;
        };
    }
    /**
     * ini untuk munculin monsternya
     * @return 
     */
    public static Enemy bangunSlime() {
        Item[] dropItem = {Potion.Biasa(),Potion.Langka(),Potion.Epic()};
        return musuh = new Enemy(
                10,     // EXP
                dropItem,
                0.5,
                1,
                "Slime",
                60,     // HP
                20,      // ATK
                5       // DEF
        );
    }
       public static Enemy bangunGoblin() {
        Item[] dropItem = {Sword.biasa(),Busur.biasa(), Sword.langka(),Busur.langka()};
        return musuh = new Enemy(20, dropItem, 0.5, 2, "Goblin", 100, 38, 10);
    }
       public static Enemy bangunSkeleton() {
        Item[] dropItem = {Jubah.biasa(),Jubah.langka(), Jubah.epic() };
        return musuh = new Enemy(35 ,dropItem, 0.5, 3, "Skeleton", 150, 45, 15);
    }
      public static Enemy bangunDarkKnight() {
        Item[] dropItem = {Sword.epic(),Busur.epic(),Potion.Epic() };
        return musuh = new Enemy(60, dropItem,0.5, 4, "DarkKnight", 200, 55, 35);
    }
       public static Enemy bangunBossDragon() {
        Item[] dropItem = {};
        return musuh = new Enemy(150, dropItem, 1.0, 5, "Dragon", 500, 100, 50);
    }
}