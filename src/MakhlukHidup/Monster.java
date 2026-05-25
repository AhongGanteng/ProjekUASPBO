package MakhlukHidup;

import Interface.*;
import Items.*;

/**
 *
 * @author LENOVO
 */
public class Monster extends Enemy {

    public Monster(int hadiahExp, Item[] dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(hadiahExp, dropItem, dropChange, lantai, nama, maxHp, serangan, ketahanan);
    }

    @Override
    public void serang(Attackable target) {
        int damage = Math.max(1, getSerangan());

        System.out.println(getNama() + "menyerang");
        target.kenaDamage(damage);

    }

    @Override
    public String tipeMusuh() {
        return "Monster";
    }

    //tampilkan deskripsi player
    @Override
    public String getDeskripsi() {
        return getNama() + "adalah monster dari lantai" + getLantai();
    }

    @Override
    public boolean isAlive() {
        return getHp() > 0;
    }

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
