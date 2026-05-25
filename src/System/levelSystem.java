package System;

import MakhlukHidup.*;

/**
 * class untuk mengelola level
 */
public class levelSystem {

    private int level;
    private int expSekarang;
    private int expPerLevel;
    private final int expAwal = 100;
    private final int pertumbuhanExp = 100;

    public levelSystem() {
        this.level = 1;
        this.expSekarang = 0;
        this.expPerLevel = this.expAwal;
    }

    public int getLevel() {
        return level;
    }

    public int getExpSekarang() {
        return expSekarang;
    }

    public int getExpPerLevel() {
        return expPerLevel;
    }

    /**
     * menambah exp ke target dan proses level up
     *
     * @param exp, jumlah exp yang didapat
     * @param target, referensi player
     */
    public void tambahExp(int exp, Hero target) {
        this.expSekarang += exp;
        while (expSekarang >= expPerLevel) {
            expSekarang -= expPerLevel;
            levelUp(target);
        }
    }

    /**
     * proses level up player
     *
     * @param target, referensi player
     */
    public void levelUp(Hero target) {
        level++;
        expPerLevel = (int) (expAwal * Math.pow(pertumbuhanExp, level - 1));
        int peningkatanAtk = getPeningkatanAtkTambahanSetiapClass(target.getHeroClass());
        int peningkatanHp = getPeningkatanHpTambahanSetiapClass(target.getHeroClass());
        int peningkatanDef = getPeningkatanDefTambahanSetiapClass(target.getHeroClass());

        target.setSerangan(target.getSerangan() + peningkatanAtk);
        target.setHp(target.getHp() + peningkatanHp);
        target.setKetahanan(target.getKetahanan() + peningkatanDef);
        target.heal(peningkatanHp);
    }

    /**
     * damage serangan akan meningkat setiap naik level
     *
     * @param Class, referensi class setiap hero
     * @return switch
     */
    public int getPeningkatanAtkTambahanSetiapClass(String Class) {
        return switch (Class) {
            case "Warrior" ->
                4;
            case "Archer" ->
                3;
            default ->
                3;
        };
    }

    /**
     * ketahananan damage akan meningkat setiap naik level
     *
     * @param Class, referensi class setiap hero
     * @return switch
     */
    public int getPeningkatanDefTambahanSetiapClass(String Class) {
        return switch (Class) {
            case "Warrior" ->
                4;
            case "Archer" ->
                2;
            default ->
                2;
        };
    }

    /**
     * jumlah hp akan meningkat setiap naik level
     *
     * @param Class, referensi class setiap hero
     * @return switch
     */
    public int getPeningkatanHpTambahanSetiapClass(String Class) {
        return switch (Class) {
            case "Warrior" ->
                20;
            case "Archer" ->
                12;
            default ->
                12;
        };
    }
}
