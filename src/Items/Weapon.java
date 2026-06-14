package Items;

import MakhlukHidup.*; //mengimort isi dari package MakhlukHidup
/**
 * class abstrak parent untuk berbagai senjata (Sword/Busur)
 */
public abstract class Weapon extends Item {

    private String classKhusus; //class hero yang pakai senjata (Warrior/Archer)
    private int bonusSerangan; //bonus ketahananannya
    /**
     * method constructor berparameter, untuk buat senjata baru
     * @param nama  nama senjata
     * @param rarity    kelangkaat senjata
     * @param classKhusus   class Hero yang memakai senjata ini
     * @param bonusSerangan point bonus serangan yang diberikan
     */
    public Weapon(String nama, String rarity, String classKhusus, int bonusSerangan) {
        super(nama, rarity);  //mewarisi method superclass Item
         //mengupdate nilai atribut sama dengan parameter
        this.bonusSerangan = bonusSerangan;
        this.classKhusus = classKhusus;
    }
    /**
     * method getter bonusSerangan, mengembalikan nilai bonusSerangan
     * @return integer bonusSerangan
     */
    public int getBonusSerangan() {
        return bonusSerangan;
    }
    /**
     * method setter bonusSerangan, set nilai bonus serangan baru
     * @param bonusSerangan 
     */
    public void setBonusSerangan(int bonusSerangan) {
        this.bonusSerangan = bonusSerangan;
    }
    /**
     * method getter classKhusus, mengembalikan nilai class hero yang pakai senjata ini
     * @return String classKhusus
     */
    public String getClassKhusus() {
        return classKhusus;
    }
    /**
     * method setter classKhusus, set nilai class hero yang bisa pakai senjata
     * @param classKhusus 
     */
    public void setClassKhusus(String classKhusus) {
        this.classKhusus = classKhusus;
    }
    /**
     * implementasi ke subclass-nya (Sword/Busur)
     * @return 
     */
    public abstract String getJenisSenjata();
    /**
     * mengembalikan tipe item sebagai senjata/weapon
     * @return String "Weapon"
     */
    @Override
    public String getItemType() {
        return "Weapon";
    }
    /**
     * mengecek apakah hero target bisa memakai senjata ini, class Hero sesuai dengan classKhusus
     * @param target hero  yang memakai senjata ini
     */
    @Override
    public void pake(Hero target) {
        //cek class hero cocok dengan class hero yang diizinkan untuk senjata ini
        if (!target.getHeroClass().equals(classKhusus)) { //jika class hero tidak sama dengan classKhusus
            System.out.println("✗ " + target.getHeroClass() + " tidak bisa memakai " + getNama() + "!"); //tampilkan tulisan
            return; //keluar persyaratan
        }
        //jika class hero cocook, wquip weapon ke slot penyimpanan hero
        target.getPenyimpanan().equipWeapon(this);
        System.out.println(target.getNama() + " memakai senjata " + getNama()); //tampilkan tulisan

    }
}