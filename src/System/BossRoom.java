package System;

import MakhlukHidup.*;

/**
 * class ruangan boss yang isinya boss dungeon
 * BossRoom untuk lantai terakhir/final
 */
public class BossRoom extends Room {

    private Enemy boss; //atribut boss untuk Enemy
    //constructor berparameter
    public BossRoom(Enemy boss) {
        super("BOSS ROOM");
        this.boss = boss;
    }

    public Enemy getBoss() {
        return boss;
    }
    //ditampilkan saat player menekan enter
    @Override
    public void enter(Hero player) {
        System.out.println("--  Memasuki Boss Room  --");
        System.out.println(getDeskripsi());
        System.out.println("==========================");
    }

    //tampilkan deskripsi ruangan boss, info boss di dalamnya
    @Override
    public String getDeskripsi() {
        return "Boss Room - Musuh: " + boss.getNama() + " (HP " + boss.getHp() + ")";
    }
}
