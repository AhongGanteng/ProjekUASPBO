package Items;

/**
 *subclass Sword dari superclass abstrak Weapon
 */
public class Sword extends Weapon {
    /**
     * mrthod constructor berparameter untuk buat objek sword baru
     * @param nama
     * @param rarity
     * @param classKhusus
     * @param bonusKetahanan 
     */
    public Sword(String nama, String rarity, String classKhusus, int bonusKetahanan) {
        super(nama, rarity, classKhusus, bonusKetahanan); //mewarisi parameter dari class Weapon
    }
    /**
     * implementasi dari getDeskripsi(), mengembalikan deskripsi pedang
     * meng-override getDeskripsi di class Item
     * @return 
     */
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }
    /**
     * membuat sword tingkat default
     * membuat argument data untuk objek sword default
     * @return 
     */
    public static Sword Default() {
        return new Sword("Wooden sword", "Default", "Warrior", 3);
    }
    /**
     * membuat sword tingkat biasa
     * membuat argument data untuk objek sword biasa
     * @return 
     */
    public static Sword biasa() {
        return new Sword("Light Saber", "Biasa", "Warrior", 10);
    }
    /**
     * membuat sword tingkat langka
     * membuat argument data untuk objek sword langka
     * @return 
     */
    public static Sword langka() {
        return new Sword("Blade of chaos", "Langka", "Warrior", 18);
    }
    /**
     * memnbuat sword tingkat epic
     * membuat argument data untuk objek sword epic
     * @return 
     */
    public static Sword epic() {
        return new Sword("Dragon slayer", "Epic", "Warrior", 30);
    }
    /**
     * implementasi dari getJenisSenjata(), meng-override dari class Weapon
     * mengembalikan jenis senjata "Sword"
     * @return 
     */
    @Override
    public String getJenisSenjata() {
        return "Sword";
    }
}