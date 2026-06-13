package Items;

import MakhlukHidup.*;

/**
 * class parent untuk berbagai ramuan (ramuannya 3 aja wkwwkwkwkwwk)
 */
public class Potion extends Item {

    private int quantity; //jumlah potion
    private int jumlahPemulihan;

    public Potion(int jumlahPemulihan, int quantity, String nama, String rarity) {
        super(nama, rarity);
        this.quantity = quantity;
        this.jumlahPemulihan = jumlahPemulihan;
    }

    public int getJumlahPemulihan() {
        return jumlahPemulihan;
    }

    public void setJumlahPemulihan(int jumlahPemulihan) {
        this.jumlahPemulihan = jumlahPemulihan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //cek apakah potion tersedia
    public boolean isEmpty() {
        return quantity == 0;
    }

    /**
     * potion dipake oleh target
     * @param target, obyek hero
     */
    @Override
    public void pake(Hero target) {
        if (isEmpty()) {
            System.out.println(getNama() + " sudah habis");
            return;
        }
        terimaEfek(target);
        quantity--;
        System.out.println(getNama() + " x " + quantity);
    }

    @Override
    public String getItemType() {
        return "POTION";
    }

    @Override
    public void showStatus() {
        System.out.println("");
    }

    //efek spesifik tiap potion
    public void terimaEfek(Hero target) {
        target.heal(jumlahPemulihan);
        System.out.println(target.getNama() + " memulihkan " + jumlahPemulihan + " HP!");

    }

    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + " (heal " + jumlahPemulihan + ")";

    }

    public static Potion Biasa() {
        return new Potion(30, 1, "Small heal potion", "Biasa");
    }

    public static Potion Langka() {
        return new Potion(60, 1, "Big heal potion", "Langka");
    }

    public static Potion Epic() {
        return new Potion(100, 1, "Mega heal potion", "Epic");
    }

}