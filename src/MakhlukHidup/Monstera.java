package MakhlukHidup;

import Interface.*;
import Items.*;

/**
 * subclass dari class Enemy
 */
public class Monstera extends Enemy {
    /**
     * method constructor berparameter, untuk buat objek Mostera baru
     * @param hadiahExp
     * @param dropItem
     * @param dropChange
     * @param lantai
     * @param nama
     * @param maxHp
     * @param serangan
     * @param ketahanan 
     */
    public Monstera(int hadiahExp, Item[] dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(hadiahExp, dropItem, dropChange, lantai, nama, maxHp, serangan, ketahanan); //mewarisi parameter Enemy
    }
    //implementasi dr interface Attackable
    @Override
    public void serang(Attackable target) {
        int damage = Math.max(1, getSerangan());
        System.out.println(getNama() + " menyerang");
        target.kenaDamage(damage);

    }
    //meng-override dr class Enemy
    @Override
    public String tipeMusuh() {
        return "Monster";
    }

    //tampilkan deskripsi player
    @Override
    public String getDeskripsi() {
        return getNama() + "adalah monster dari lantai" + getLantai();
    }
    //implementasi dr interface Attackable
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
