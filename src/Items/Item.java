package Items;

import Interface.*; //mengimport isi dari package Interface
import MakhlukHidup.*; //mengimport isi dari package MakhlukHidup

/**
 * Parent class untuk weapon, armor dan potion
 * mengimplements dari interface Deskripsi dan BisaDipake
 * @author LENOVO
 */
public abstract class Item implements Deskripsi, BisaDipake{
    private String nama; //nama item
    private String rarity; //tingkat kelangkaan (biasa, langka, epic)
    /**
     * method constructor berparameter 
     * untuk buat item baru
     * @param nama
     * @param rarity 
     */
    public Item(String nama, String rarity) {
        //mengupdate nilai atribut sama dengan parameter
        this.nama = nama; 
        this.rarity = rarity;
    }
    /**
     * method getter nama, mengembalikan nilai nama
     * @return String nama
     */
    public String getNama() {
        return nama;
    }
    /**
     * method getter rarity, mengembalikan nilai rarity
     * @return String rarity
     */
    public String getRarity() {
        return rarity;
    }
    /**
     * method setter nama, set nama item baru
     * @param nama 
     */
    public void setNama(String nama) {
        this.nama = nama;
    }
    /**
     * method setter rarity, set rarity item baru
     * @param rarity 
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    /**
     * implementasi ke subclass-nya
     * mengembalikan deskripsi item
     * @return 
     */
    @Override
    public abstract String getDeskripsi();
    
    /**
     * menampilkan status dari item
     */
    @Override
    public void showStatus(){
        System.out.println("\nItem"); //cetak header "Item"
        System.out.println("Nama :" + nama); //cetak nama item
        System.out.println("Rarity :" + rarity); //cetak rarity item
        System.out.println("Tipe :" + getItemType()); //cetak tipe dari subclass-nya
    }
    /**
     * implementasi ke subclass-nya
     * mengembalikan tipe item (Weapon/Armor/Potion)
     * @return 
     */
    @Override
    public abstract String getItemType();
    /**
     * implementasi interface BisaDipake
     * menggunakan item untuk objek hero
     * @param target 
     */
    @Override
    public abstract void pake(Hero target);
}

