package MakhlukHidup;

import Interface.*;
import System.*;

/**
 * salah satu anak dari class hero, senjatanya sword, punya pasif jika darah
 * dibawah 50% maka ketahanan damagenya meningkat +5, dan punya skill yaitu
 * damage +50% + heal 10 darah dengan cooldown 3 turn
 */
public class Warrior extends Hero {

    private boolean passiveActive = false;

    /**
     * nama player darah warrior = 150 damage serangan = 18 ketahanan = 12 jeda
     * penggunaan skill = 3
     *
     * @param nama
     */
    public Warrior(String nama) {
        super(nama, 150, 18, 12, "Warrior", 3);
    }

    /**
     * damage serangan yang diberikan oleh player
     *
     * @param target, targetnya adalah obyek Enemy
     */
    @Override
    public void serang(Attackable target) {
        int damage = getSerangan() + getPenyimpanan().getWeaponAtkBonus();
        System.out.println(getNama() + " menyerang dengan pedang!");
        target.kenaDamage(damage);
    }

    /**
     * Skill yang dimiliki oleh class Warrior peningkatan damage +50% dan heal
     * 10% darah player
     *
     * @param target, target serangan
     */
    @Override
    public void useSkill(Attackable target) {
        if (!isSkillReady()) {
            System.out.println("Skill sedang cooldown! (" + getCooldownSekarang() + " turn lagi)");
            return;
        }

        int damage = (int) ((getSerangan() + getPenyimpanan().getWeaponAtkBonus()) * 1.5);
        int healAmount = getMaxHp() / 10;

        System.out.println(getNama() + " menggunakan Shield Bash! Damage +50%!");
        target.kenaDamage(damage);

        heal(healAmount);
        System.out.println(getNama() + " memulihkan " + healAmount + " HP!");

        resetCooldown();
    }

    /**
     * Nama skill untuk class Warrior
     *
     * @return nama skill nya
     */
    @Override
    public String getNamaSkill() {
        return "Shield Bash";
    }

    /**
     * tampilkan deskripsi player
     */
    @Override
    public String getDeskripsi() {
        return "Warrior " + getNama() + " (HP: " + getHp() + "/" + getMaxHp()
                + ", ATK: " + getSerangan() + ", DEF: " + getKetahanan() + ")";
    }

    /**
     * hal yang bisa mengaktifkan skill pasif class Warrior
     */
    @Override
    public void triggerPasif() {
        if (getHp() < getMaxHp() * 0.5 && !passiveActive) {
            passiveActive = true;
            setKetahanan(getKetahanan() + 5);
            System.out.println(getNama() + " [PASIF] Defense meningkat +5 karena HP di bawah 50%!");
        } else if (getHp() >= getMaxHp() * 0.5 && passiveActive) {
            passiveActive = false;
            setKetahanan(getKetahanan() - 5);
            System.out.println(getNama() + " [PASIF] Defense kembali normal.");
        }
    }

    /**
     * nama pasifnya
     */
    @Override
    public void getNamaPasif() {
        System.out.println("Toughness - Defense +5 saat HP di bawah 50%");
    }

    @Override
    public void resetPasif() {
        if (passiveActive) {
            setKetahanan(getKetahanan() - 5);
            passiveActive = false;
        }
    }

    @Override
    public void showStatus() {
        System.out.println("\n=== " + getNama() + " (Warrior) ===");
        System.out.println("HP   : " + getHp() + "/" + getMaxHp());
        System.out.println("ATK  : " + getSerangan());
        System.out.println("DEF  : " + getKetahanan());
        System.out.println("Level: " + getLevel().getLevel());
        System.out.println("Skill: " + getNamaSkill() + " (CD: " + getCooldownSekarang() + "/" + getCooldownSkill() + ")");
    }
}
