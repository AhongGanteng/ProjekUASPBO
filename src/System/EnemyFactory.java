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
        return new Slime(10, "Small heal potion", 0.5, 1, "Slime", 30, 5, 1);
    }
    public static Enemy bangunGoblin() {
        return new Goblin(10, "Small heal potion", 0.5, 1, "Slime", 30, 5, 1);
    }
    public static Enemy bangunSkeleton() {
        return new Skeleton(10, "Small heal potion", 0.5, 1, "Slime", 30, 5, 1);
    }
    public static Enemy bangunDarkKnight() {
        return new DarkKnight(10, "Small heal potion", 0.5, 1, "Slime", 30, 5, 1);
    }
    public static Enemy bangunBossDragon() {
        return new Dragon(10, "Small heal potion", 0.5, 1, "Slime", 30, 5, 1);
    }
}
