package Items;

import Interface.*;
import MakhlukHidup.*;

public abstract class Item implements Deskripsi, BisaDipake {

    private String nama;
    private String rarity;

    public Item(String nama, String rarity) {
        this.nama = nama;
        this.rarity = rarity;
    }

    public String getNama() {
        return nama;
    }

    public String getRarity() {
        return rarity;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    @Override
    public void showStatus() {
        System.out.println("\nItem");
        System.out.println("Nama   : " + nama);
        System.out.println("Rarity : " + rarity);
        System.out.println("Tipe   : " + getItemType());
    }

    public abstract String getItemType();
}
