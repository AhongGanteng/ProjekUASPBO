package Items;

import MakhlukHidup.*; //mengimport isi dari package MakhlukHidup

/**
 * class untuk berbagai ramuan/potion dari jenis Item
 */
public class Potion extends Item {

    private int quantity; //jumlah potion
    private int jumlahPemulihan; //jumlah HP yang dipulihkan tiap potion dipakai
    /**
     * method constructor berparameter, untuk buat potion baru
     * @param jumlahPemulihan jumlah HP yang dipulihkan tiap potion digunakan
     * @param quantity  jumlah potion
     * @param nama nama potion
     * @param rarity tingkat kelangkaan
     */
    public Potion(int jumlahPemulihan, int quantity, String nama, String rarity) {
        super(nama, rarity); //mewarisi method superclass Item
        //mengupdate nilai atribut sama dengan parameter
        this.quantity = quantity;
        this.jumlahPemulihan = jumlahPemulihan;
    }
    /**
     * method getter jumlahPemulihan, mengembalikan nilai jumlahPemulihan
     * @return integer jumlahPemulihan
     */
    public int getJumlahPemulihan() {
        return jumlahPemulihan;
    }
    /**
     * method setter jumlahPemulihan
     * mengubah nilai jumlahPemulihan potion
     * @param jumlahPemulihan 
     */
    public void setJumlahPemulihan(int jumlahPemulihan) {
        this.jumlahPemulihan = jumlahPemulihan;
    }
    /**
     * method getter quantity, mengembalikan nilai quantity
     * @return integer quntity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * method setter quantitiy
     *  mengubah nilai quantity potion
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * fungsi cek potion kosong
     * @return 
     */
    //cek apakah potion tersedia
    public boolean isEmpty() { 
        return quantity == 0; //mengembalikan nilai quantity 0 jika potion kosong
    }

    /**
     * potion dipake oleh target
     * @param target, obyek hero
     */
    @Override
    public void pake(Hero target) {
        if (isEmpty()) { //cek jika jmlh potion kosong
            System.out.println(getNama() + " sudah habis"); //maka cetak tampilkan tulisan
            return;
        }
        terimaEfek(target); //memberi efek pemulihan kepada hero
        quantity--; //mengurangi stok potion setelah digunakan
        System.out.println(getNama() + " x " + quantity); //tampilkan sisa potion yang tersedia
    }
     /**
     * mengembalikan tipe item sebagai potion
     * @return String "Poition"
     */
    @Override
    public String getItemType() {
        return "POTION";
    }
    /**
     * meng-override method showStatus() class Item
     * tidak tampilkan status detail
     */
    @Override
    public void showStatus() {
        System.out.println("");
    }

    //efek spesifik tiap potion
    public void terimaEfek(Hero target) {
        target.heal(jumlahPemulihan);
        System.out.println(target.getNama() + " memulihkan " + jumlahPemulihan + " HP!");

    }
    /**
     * implementasi dari getDeskripsi(), mengembalikan deskripsi potion
     * meng-override getDeskripsi di class Item
     * @return 
     */
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + " (heal " + jumlahPemulihan + ")";

    }
    /**
     * membuat potion tingkat biasa
     * mmebuat argument data untuk objek potion biasa
     * @return 
     */
    public static Potion Biasa() {
        return new Potion(30, 1, "Small heal potion", "Biasa");
    }
    /**
     * membuat potion tingkat langka
     * mmebuat argument data untuk objek potion langka
     * @return 
     */
    public static Potion Langka() {
        return new Potion(60, 1, "Big heal potion", "Langka");
    }
    /**
     * membuat potion tingkat epic
     * mmebuat argument data untuk objek potion epic
     * @return 
     */
    public static Potion Epic() {
        return new Potion(100, 1, "Mega heal potion", "Epic");
    }

}
