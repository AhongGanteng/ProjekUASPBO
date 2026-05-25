package System;

import MakhlukHidup.*;
import Interface.*;
import Items.*;

/**
 * semacam sistem untuk spawn monster
 */
public class EnemyFactory {

    /**
     * ini sistemnya, jadi monster akan muncul dilantai berbeda
     *
     * @param nomorLantai
     * @return bangun monsternya
     */
    public static Enemy bangunMusuh(int nomorLantai) {
        return switch (nomorLantai) {
            case 1 ->
                bangunSlime();
            case 2 ->
                bangunGoblin();
            case 3 ->
                bangunSkeleton();
            case 4 ->
                bangunDarkKnight();
            case 5 ->
                bangunBossDragon();
            default ->
                null;
        };
    }

    /**
     * ini untuk munculin monsternya
     *
     * @return
     */
    public static Enemy bangunSlime() {
        Item[] dropItem = {HealthPotion.Biasa(), HealthPotion.Langka(), HealthPotion.Epic()};
        return new Monster(10, dropItem, 0.5, 1, "Slime", 30, 5, 1);
    }

    public static Enemy bangunGoblin() {
        Item[] dropItem = {Sword.biasa(), Busur.biasa(), Sword.langka(), Busur.langka()};
        return new Monster(10, dropItem, 0.5, 2, "Goblin", 30, 5, 1);
    }

    public static Enemy bangunSkeleton() {
        Item[] dropItem = {Jubah.biasa(), Jubah.langka(), Jubah.epic()};
        return new Monster(10, dropItem, 0.5, 3, "Skeleton", 30, 5, 1);
    }

    public static Enemy bangunDarkKnight() {
        Item[] dropItem = {Sword.epic(), Busur.epic(), HealthPotion.Epic()};
        return new Monster(10, dropItem, 0.5, 4, "DarkKnight", 30, 5, 1);
    }

    public static Enemy bangunBossDragon() {
        Item[] dropItem = {};
        return new Monster(10, dropItem, 0.5, 5, "Dragon", 30, 5, 1);
    }
}
