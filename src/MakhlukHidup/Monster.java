package MakhlukHidup;

import Interface.*;
import Items.Item;

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
        return "Moster";
    }

    @Override
    public String getDeskripsi() {
        return String.format("[Monster] %s (Floor %d) | HP: %d/%d | ATK: %d | DEF: %d | EXP: %d | Drop Rate: %.0f%%",
                getNama(),
                getLantai(),
                getHp(),
                getMaxHp(),
                getSerangan(),
                getKetahanan(),
                getHadiahExp(),
                getDropChange() * 100);
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
