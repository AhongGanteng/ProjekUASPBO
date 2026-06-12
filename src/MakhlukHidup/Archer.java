package MakhlukHidup;

import Interface.*;
import System.*;

/**
 * salah satu anak dari class hero, senjatanya busur, punya pasif peningkatan
 * damage 2 kali lipat dengan kesempatan 25%, dan punya skill yaitu damage +80%
 * dan pengurangan defense musuh -3 dengan cooldown 3 turn
 */
public class Archer extends Hero {

    private final double critChange = 0.25; //kesempatan untuk mendapatkan penambahan damage
    private final int critticalDamage = 2; //damage akan di kali 2

    /**
     * nama player darah warrior = 100 damage serangan = 20 ketahanan = 6 jeda
     * penggunaan skill = 3
     * @param nama
     */
    public Archer(String nama) {
        super(nama, 100, 20, 6, "Archer", 3);
    }

    /**
     * damage serangan yang diberikan oleh player
     * @param target, targetnya adalah obyek Enemy
     */
    @Override
    public void serang(Attackable target) {
        int baseDamage = getSerangan() + getPenyimpanan().getWeaponAtkBonus();
        boolean isCrit = Math.random() < critChange;
        if (isCrit) {
            int crit = baseDamage * critticalDamage;
            System.out.println(getNama() + " menembak! ✦ CRITICAL HIT! (" + crit + " damage)");
            target.kenaDamage(crit);
        } else {
            System.out.println(getNama() + " menembak! (" + baseDamage + " damage)");
            target.kenaDamage(baseDamage);
        }
    }

    /**
     * Skill yang dimiliki oleh class Warrior peningkatan damage +80% dan
     * ketahanan musuh -3
     * @param target, target serangan
     */
    @Override
    public void useSkill(Attackable target) {
        if (!isSkillReady()) {
            System.out.println("Piercing Arror belum siap (CD: " + getCooldownSekarang() + " turn lagi)");
        } else {
            int damage = (int) ((getSerangan() + getPenyimpanan().getWeaponAtkBonus()) * 1.8);
            System.out.println(getNama() + " menggunakan skill Piercing Arror! (" + damage + ") damage");
            target.kenaDamage(damage);
            resetCooldown();
        }
    }

    /**
     * Nama skill untuk class Archer
     * @return nama skill nya
     */
    @Override
    public String getNamaSkill() {
        return "Piercing Arror (CD: " + getCooldownSekarang() + " turn lagi)";
    }

    //tampilkan deskripsi player
    @Override
    public String getDeskripsi() {
        return null;
    }

    /**
     * hal yang bisa mengaktifkan skill pasif class Archer
     */
    @Override
    public void triggerPasif() {

    }

    /**
     * nama pasifnya
     */
    @Override
    public String getNamaPasif() {
        return "Critical Shot (+25% damage)";
    }

    @Override
    public void resetPasif() {

    }
}
