package Items;
/**
 * Parent class untuk weapon, armor dan potion
 */
import Interface.*;
import MakhlukHidup.*;
/**
 * mengimplements dari class Deskripsi dan BisaDipake
 * @author LENOVO
 */
public abstract class Item implements Deskripsi, BisaDipake{
    private String nama; //nama item
    private String rarity; //tingkat kelangkaan (biasa, langka, epic)

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
    public String getDeskripsi() {
       return "(" + rarity + ") " + nama;
    }
 
    @Override
    public void showStatus(){
        System.out.println("\nItem");
        System.out.println("Nama :" + nama);
        System.out.println("Rarity :" + rarity);
        System.out.println("Tipe :" + getItemType());
    }
     public abstract String getItemType();
}
