/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items;

/**
 *
 * @author LENOVO
 */
public class Busur extends Weapon{
    public Busur(String nama, String rarity, String classKhusus, int bonusSerangan) {
        super(nama, rarity, classKhusus, bonusSerangan);
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + " (ATK +" + getBonusSerangan() + ")";
    }
    
    public static Busur Default() {
        return new Busur("Busur Kayu", "Default", "Archer", 3);
    }
    
    public static Busur biasa() {
        return new Busur("Busur Pemburu", "Biasa", "Archer", 10);
    }
    
    public static Busur langka() {
        return new Busur("Busur Elven", "Langka", "Archer", 18);
    }
    
    public static Busur epic() {
        return new Busur("Busur Naga", "Epic", "Archer", 30);
    }
    
    @Override
    public String getJenisSenjata() {
        return "Busur";
    }
}
