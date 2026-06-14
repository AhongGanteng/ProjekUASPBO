package Items;

import MakhlukHidup.*; //mengimport isi dari package MakhlukHidup
/**
 * class abstrak untuk memperesentasikan Armor dari jenis Item 
 */
public abstract class Armor extends Item {
    
    private int bonusKetahanan; //bonus ketahananannya
    
    /**
     * constructor untuk membuat objek Armor baru, berparameter
     * @param nama  nama armor
     * @param rarity    tingkat kelangkaan armor
     * @param bonusKetahanan    jumlah point ketahanan tambahan  dari armor yg didapat
     */
    public Armor(String nama, String rarity, int bonusKetahanan) {
        super(nama, rarity); //mewarisi method superclass Item
        this.bonusKetahanan = Math.max(0, bonusKetahanan); // agar bonus tdk negatif
    }
     /**
     * method getter bonusKetahanan
     * mengembalikan nilai bonus ketahanan armor
     * @return nilai integer bonusKetahanan
     */
    public int getBonusKetahanan() {
        return bonusKetahanan;
    }
    /**
     * method setter 
     * mengubah nilai bonus ketahanan armor
     * @param bonusKetahanan 
     */
    public void setBonusKetahanan(int bonusKetahanan) {
        this.bonusKetahanan = Math.max(0, bonusKetahanan); //agar bonus tdk negatif, bandingkan 2 angka, hasil angka yg lbh besar 
    }
    /**
     * mengembalikan tipe item String "Armor"
     * meng-override method getItemType() dari superclass Item
     * @return "ARMOR"
     */
    @Override
    public String getItemType() {
        return "ARMOR";

    }
     /**
     * fungsi pakai armor ke Hero
     * item armor akan di-equip ke slot armor dalam penyimpanan Hero
     * pesan konfirmasi ditampilkan Hero memakai armor
     * meng-override method pake() dari superclass Item
     * @param target 
     */
    @Override
    public void pake(Hero target) {
        target.getPenyimpanan().equipArmor(this);
        System.out.println(target.getNama() + " memakai armor " + getNama());
    }
    /**
     * implementasi dari getDeskripsi(), mengembalikan deskripsi armor
     * meng-override getDeskripsi di class Item
     * @return 
     */
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + " (DEF +" + getBonusKetahanan() + ")";
    }
    /**
     * membuat armor tingkat default
     * membuat argument data untuk objek armor default
     * @return 
     */
    public static Armor Default() {
        return new Armor("Jubah Kain Tua", "Default", 3) {
        };
    }
    /**
     * membuat armor tingkat biasa
     * membuat argument data untuk objek armor biasa
     * @return 
     */
    public static Armor biasa() {
        return new Armor("Jubah Pemburu", "Biasa", 5) {
        };
    }
    /**
     * membuat armor tingkat langka
     * membuat argument data untuk objek armor langka
     * @return 
     */
    public static Armor langka() {
        return new Armor("Jubah Bayangan", "Langka", 8) {
        };
    }
    /**
     * membuat armor tingkat epic
     * mmebuat argument data untuk objek armor epic
     * @return 
     */
    public static Armor epic() {
        return new Armor("Jubah Naga Api", "Epic", 10) {
        };
    }
}
