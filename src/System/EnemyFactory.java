package System;
import MakhlukHidup.*;
import Interface.*;
/**
 * semacam sistem untuk spawn monster
 */
public class EnemyFactory {
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
        return new Monster(10, "Small heal potion", 0.5, 1, "Slime", 30, 5, 1);
    }
    public static Enemy bangunGoblin() {
        return new Monster(10, "Small heal potion", 0.5, 2, "Goblin", 30, 5, 1);
    }
    public static Enemy bangunSkeleton() {
        return new Monster(10, "Small heal potion", 0.5, 3, "Skeleton", 30, 5, 1);
    }
    public static Enemy bangunDarkKnight() {
        return new Monster(10, "Small heal potion", 0.5, 4, "DarkKnight", 30, 5, 1);
    }
    public static Enemy bangunBossDragon() {
        return new Monster(10, "Small heal potion", 0.5, 5, "Dragon", 30, 5, 1);
    }
}
