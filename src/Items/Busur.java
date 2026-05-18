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
    public Busur(String nama, String rarity, int bonusKetahanan) {
        super(nama, rarity, bonusKetahanan);
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }
    
    public static Busur Default() {
        return new Busur("", "", 3);
    }
    
    public static Busur biasa() {
        return new Busur("", "", 5);
    }
    
    public static Busur langka() {
        return new Busur("", "", 8);
    }
    
    public static Busur epic() {
        return new Busur("", "", 10);
    }
    
    @Override
    public String getJenisSenjata() {
        return "Busur";
    }
}
