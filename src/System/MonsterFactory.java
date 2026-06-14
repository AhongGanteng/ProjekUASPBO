package System;

import MakhlukHidup.*;
import Interface.*;
import Items.*;

/**
 * semacam sistem untuk spawn monster
 * membuat enemy sesuai lantai dungeon
 */
public class MonsterFactory {

    private static Enemy musuh; //atribut musuh bertipe Enemy

    /**
     * ini sistemnya, jadi monster akan muncul dilantai berbeda
     * @param nomorLantai   nomor laintai tempat musuh muncul (1-5)
     * @return bangun monsternya
     */

    public static Enemy bangunMusuh(int nomorLantai) {
        return switch (nomorLantai) {
            case 1 -> //lantai 1 -> Slime
                bangunSlime();
            case 2 -> //lantai 2 -> Goblin
                bangunGoblin();
            case 3 -> //lantai 3 -> Skeleton
                bangunSkeleton();
            case 4 -> //lantai 4 -> DarkKnight
                bangunDarkKnight();
            case 5 -> //lantai 5 -> Dragon (boss)
                bangunBossDragon();
            default -> //lantai tidak ada -> null
                null;
        };
    }

    /**
     * ini untuk munculin monsternya
     * buat musuh Slime lt1
     * @return
     */
    public static Enemy bangunSlime() {
        Item[] dropItem = {Potion.Biasa(), Potion.Langka(), Potion.Epic()};
        return musuh = new Enemy(
                10, // EXP
                dropItem, //item yg di drop
                0.5, //50% kemungkinan drop item
                1, //muncul di lt 1
                "Slime", //nama musuh
                60, // HP 
                15, // ATK
                5 // DEF
        );
    }
    //buat musuh Goblin lt2
    public static Enemy bangunGoblin() {
        Item[] dropItem = {Sword.biasa(), Busur.biasa(), Sword.langka(), Busur.langka()};
        return musuh = new Enemy(20, dropItem, 0.5, 2, "Goblin", 100, 20, 10);
    }
    //buat musuh Skeleton lt3
    public static Enemy bangunSkeleton() {
        Item[] dropItem = {Armor.biasa(), Armor.langka(), Armor.epic()};
        return musuh = new Enemy(35, dropItem, 0.5, 3, "Skeleton", 150, 30, 15);
    }
    //buat musuh DarkKnight lt4
    public static Enemy bangunDarkKnight() {
        Item[] dropItem = {Sword.epic(), Busur.epic(), Potion.Epic()};
        return musuh = new Enemy(60, dropItem, 0.5, 4, "DarkKnight", 200, 45, 35);
    }
    //buat musuh BossDragon lt5/final
    public static Enemy bangunBossDragon() {
        Item[] dropItem = {};
        return musuh = new Enemy(150, dropItem, 1.0, 5, "Dragon", 500, 65, 40);
    }
}