package Items;

/**
 * class parent untuk berbagai armor (armornya 3 aja wkwwkwkwkwwk)
 */
import MakhlukHidup.*;

public abstract class Armor extends Item {

    private int bonusKetahanan; //bonus ketahananannya

    public Armor(String nama, String rarity, int bonusKetahanan) {
        super(nama, rarity);
        this.bonusKetahanan = Math.max(0, bonusKetahanan); // agar bonus tdk negatif
    }

    public int getBonusKetahanan() {
        return bonusKetahanan;
    }

    public void setBonusKetahanan(int bonusKetahanan) {
        this.bonusKetahanan = Math.max(0, bonusKetahanan);
    }

    @Override
    public String getItemType() {
        return "ARMOR";

    }

    @Override
    public void pake(Hero target) {
        target.getPenyimpanan().equipArmor(this);
        System.out.println(target.getNama() + " memakai armor " + getNama());
    }

    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + " (DEF +" + getBonusKetahanan() + ")";
    }

    public static Armor Default() {
        return new Armor("Jubah Kain Tua", "Default", 3) {
        };
    }

    public static Armor biasa() {
        return new Armor("Jubah Pemburu", "Biasa", 5) {
        };
    }

    public static Armor langka() {
        return new Armor("Jubah Bayangan", "Langka", 8) {
        };
    }

    public static Armor epic() {
        return new Armor("Jubah Naga Api", "Epic", 10) {
        };
    }
}
