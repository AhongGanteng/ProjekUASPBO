/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MakhlukHidup;

import Interface.*;
import Items.*;
import System.*;

/**
 * salah satu anak dari class hero, senjatanya sword, punya pasif jika darah
 * dibawah 50% maka ketahanan damagenya meningkat +5, dan punya skill yaitu
 * damage +50% + heal 10 darah dengan cooldown 3 turn
 */
public class Warrior extends Hero {

    private boolean darahTersisaSetengah; //cek darahnya

    /**
     * nama player darah warrior = 150 damage serangan = 18 ketahanan = 12 jeda
     * penggunaan skill = 3
     * @param nama
     */
    public Warrior(String nama) {
        super(nama, 150, 18, 12, "Warrior", 3);
        this.darahTersisaSetengah = false;
        getPenyimpanan().equipWeapon(Sword.Default());
        getPenyimpanan().equipArmor(Armor.Default());
    }

    /**
     * damage serangan yang diberikan oleh player
     * @param target, targetnya adalah obyek Enemy
     */
    @Override
    public void serang(Attackable target) {
        int damage = getSerangan() + getPenyimpanan().getWeaponAtkBonus();
        System.out.println(getNama() + " mengayunkan pedang! (" + damage + " damage)");
        target.kenaDamage(damage);
    }

    /**
     * Skill yang dimiliki oleh class Warrior peningkatan damage +50% dan heal
     * 10% darah player
     * @param target, target serangan
     */
    @Override
    public void useSkill(Attackable target) {
        if (!isSkillReady()) {
            System.out.println("Leap Attack belum siap! (" + getCooldownSekarang() + " turn lagi)");
        } else {
            int damage = (int) ((getSerangan() + getPenyimpanan().getWeaponAtkBonus()) * 1.5);
            System.out.println(getNama() + " menggunakan skill Leap Attack! (" + damage + ") damage");
            target.kenaDamage(damage);
            resetCooldown();
        }

    }

    /**
     * Nama skill untuk class Warrior
     * @return nama skill nya
     */
    @Override
    public String getNamaSkill() {
        return "Leap Attack (CD: " + getCooldownSekarang() + " turn lagi)";
    }

    /**
     * hal yang bisa mengaktifkan skill pasif class Warrior
     */
    @Override
    public void triggerPasif() {
        if (!darahTersisaSetengah && getHp() < getMaxHp() / 2) {
            setKetahanan(getKetahanan() + 5);
            darahTersisaSetengah = true;
            System.out.println("[Passive: Toughness] DEF +5 (DEF sekarang: " + getKetahanan() + ")");
        }
    }

    /**
     * nama pasifnya
     * @return
     */
    @Override
    public String getNamaPasif() {
        if (darahTersisaSetengah) {
            return "Toughness sudah aktif!";
        } else {
            return "Toughness belum aktif";
        }
    }

    @Override
    public String getDeskripsi() {
        return super.getDeskripsi() + "\nPasif: Serangan meningkat saat HP di bawah 50%";
    }
}
