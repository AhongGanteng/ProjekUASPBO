package Items;

public class Busur extends Weapon {

    public Busur(String nama, String rarity, String classKhusus, int bonusSerangan) {
        super(nama, rarity, classKhusus, bonusSerangan);
    }

    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }

    public static Busur Default() {
        return new Busur("", "", "Archer", 3);
    }

    public static Busur biasa() {
        return new Busur("", "", "Archer", 5);
    }

    public static Busur langka() {
        return new Busur("", "", "Archer", 8);
    }

    public static Busur epic() {
        return new Busur("", "", "Archer", 10);
    }

    @Override
    public String getJenisSenjata() {
        return "Busur";
    }
}
