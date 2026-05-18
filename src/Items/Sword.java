/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items;
/**
 *
 * @author LENOVO
 */
public class Sword extends Weapon{
    public Sword(String nama, String rarity, int bonusKetahanan) {
        super(nama, rarity, bonusKetahanan);
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }
    
    public static Sword Default() {
        return new Sword("", "", 3);
    }
    
    public static Sword biasa() {
        return new Sword("", "", 5);
    }
    
    public static Sword langka() {
        return new Sword("", "", 8);
    }
    
    public static Sword epic() {
        return new Sword("", "", 10);
    }
    
    @Override
    public String getJenisSenjata() {
        return "Busur";
    }
}
