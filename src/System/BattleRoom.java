package System;

import MakhlukHidup.*;

/**
 * ruangan battle khusus untuk monster biasa aja
 * mewarisi class Room
 */
public class BattleRoom extends Room {

    private Enemy enemy; //atribut bertipe Enemy
    //constructor berparameter
    public BattleRoom(Enemy enemy) {
        super("BATTLE ROOM"); //mewarisi parameter class Room 
        this.enemy = enemy;
    }
    //method getter
    public Enemy getEnemy() {
        return enemy;
    }
    //ditampilkan saat player menekan enter
    @Override
    public void enter(Hero player) {
        System.out.println("-- Memasuki Battle Room --");
        System.out.println(getDeskripsi());
        System.out.println("==========================");
    }
    //tampilkan deskripsi ruangan battle, info musuh di dalam 
    @Override
    public String getDeskripsi() {
        return "Battle Room - Musuh: " + enemy.getNama() + " (HP " + enemy.getHp() + ")";
    }
}
