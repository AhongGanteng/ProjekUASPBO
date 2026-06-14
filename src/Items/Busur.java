package Items;

/**
 *subclass Busur dari superclass abstrak Weapon
 */
public class Busur extends Weapon {
    /**
     * mrthod constructor berparameter untuk buat objek busur baru
     * @param nama
     * @param rarity
     * @param classKhusus
     * @param bonusSerangan 
     */
    public Busur(String nama, String rarity, String classKhusus, int bonusSerangan) {
        super(nama, rarity, classKhusus, bonusSerangan); //mewarisi parameter dari class Weapon
    }
    /**
     * implementasi dari getDeskripsi(), mengembalikan deskripsi busur
     * meng-override getDeskripsi di class Item
     * @return 
     */
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + " (ATK +" + getBonusSerangan() + ")";
    }
    /**
     * membuat busur tingkat default
     * membuat argument data untuk objek busur default
     * @return 
     */
    public static Busur Default() {
        return new Busur("Busur Kayu", "Default", "Archer", 3);
    }
    /**
     * membuat busur tingkat biasa
     * membuat argument data untuk objek busur biasa
     * @return 
     */
    public static Busur biasa() {
        return new Busur("Busur Pemburu", "Biasa", "Archer", 10);
    }
    /**
     * membuat busur tingkat langka
     * membuat argument data untuk objek busur langka
     * @return 
     */
    public static Busur langka() {
        return new Busur("Busur Elven", "Langka", "Archer", 18);
    }
     /**
     * memnbuat busur tingkat epicc
     * membuat argument data untuk objek busur epic
     * @return 
     */
    public static Busur epic() {
        return new Busur("Busur Naga", "Epic", "Archer", 30);
    }
    /**
     * implementasi dari getJenisSenjata(), meng-override dari class Weapon
     * mengembalikan jenis senjata "Busur"
     * @return 
     */
    @Override
    public String getJenisSenjata() {
        return "Busur";
    }

}