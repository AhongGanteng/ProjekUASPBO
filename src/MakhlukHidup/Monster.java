package MakhlukHidup;

import Interface.*;
import Items.*;

/**
 *
 * subclass dari Enemy
 */
public class Monster extends Enemy {
    /**
     * constructor berparameter
     * @param hadiahExp
     * @param dropItem
     * @param dropChange
     * @param lantai
     * @param nama
     * @param maxHp
     * @param serangan
     * @param ketahanan 
     */
    public Monster(int hadiahExp, Item[] dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(hadiahExp, dropItem, dropChange, lantai, nama, maxHp, serangan, ketahanan); //mewarisi parameter dr Enemy
    }
    /**
     * implementasi dr interface Attackable
     * @param target 
     */
    @Override
    public void serang(Attackable target) {
        int damage = Math.max(1, getSerangan());
        System.out.println(getNama() + " menyerang");
        target.kenaDamage(damage);

    }
    //mewarisi dr class Enemy
    @Override
    public String tipeMusuh() {
        return "Monster";
    }

    //tampilkan deskripsi monster
    @Override
    public String getDeskripsi() {
        return getNama() + "adalah monster dari lantai" + getLantai();
    }
    //implementasi dari interface Attackable
    @Override
    public boolean isAlive() {
        return getHp() > 0;
    }
    //tampilkan status monster
    @Override
    public void showStatus() {
        System.out.println("\nStatus Monster");
        System.out.println("Nama  :" + getNama());
        System.out.println("Hp   :" + getHp() + "/" + getMaxHp());
        System.out.println("Serangan :" + getSerangan());
        System.out.println("Ketahanan :" + getKetahanan());
        System.out.println("Exp :" + getHadiahExp());
    }
}

