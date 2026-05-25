package MakhlukHidup;

import Interface.*;
import System.*;

public class Archer extends Hero {

    private final double critChange = 0.25;
    private final int criticalDamage = 2;
    private boolean pasifAktif = false;

    public Archer(String nama) {
        super(nama, 100, 20, 6, "Archer", 3);
    }

    @Override
    public void serang(Attackable target) {
        int damage = getSerangan() + getPenyimpanan().getWeaponAtkBonus();

        // Pasif: 25% chance untuk critical damage
        if (Math.random() < critChange) {
            damage *= criticalDamage;
            System.out.println(getNama() + " [CRITICAL!] Damage x" + criticalDamage + "!");
        }

        System.out.println(getNama() + " menyerang dengan busur!");
        target.kenaDamage(damage);
    }

    @Override
    public void useSkill(Attackable target) {
        if (!isSkillReady()) {
            System.out.println("Skill sedang cooldown!");
            return;
        }

        // Skill: damage +80% dan defense musuh -3
        int damage = (int) ((getSerangan() + getPenyimpanan().getWeaponAtkBonus()) * 1.8);
        System.out.println(getNama() + " menggunakan Piercing Arrow! Damage +80%!");
        target.kenaDamage(damage);

        // Kurangi defense musuh jika target adalah Enemy
        if (target instanceof Enemy enemy) {
            int defenseBaru = Math.max(0, enemy.getKetahanan() - 3);
            enemy.setKetahanan(defenseBaru);
            System.out.println("Defense " + enemy.getNama() + " berkurang 3!");
        }

        resetCooldown();
    }

    @Override
    public String getNamaSkill() {
        return "Piercing Arrow";
    }

    @Override
    public String getDeskripsi() {
        return "Archer " + getNama() + " (HP: " + getHp() + "/" + getMaxHp()
                + ", ATK: " + getSerangan() + ", DEF: " + getKetahanan() + ")";
    }

    @Override
    public void triggerPasif() {
        // Pasif sudah diimplementasikan di method serang()
    }

    @Override
    public void getNamaPasif() {
        System.out.println("Critical Shot - 25% chance untuk double damage");
    }

    @Override
    public void resetPasif() {
        this.pasifAktif = false;
    }

    @Override
    public void showStatus() {
        System.out.println("\n=== " + getNama() + " (Archer) ===");
        System.out.println("HP   : " + getHp() + "/" + getMaxHp());
        System.out.println("ATK  : " + getSerangan());
        System.out.println("DEF  : " + getKetahanan());
        System.out.println("Level: " + getLevel().getLevel());
        System.out.println("Skill: " + getNamaSkill() + " (CD: " + getCooldownSekarang() + "/" + getCooldownSkill() + ")");
    }
}
