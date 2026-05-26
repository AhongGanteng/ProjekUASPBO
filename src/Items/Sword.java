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
    public Sword(String nama, String rarity, String classKhusus, int bonusKetahanan) {
        super(nama, rarity, classKhusus, bonusKetahanan);
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }
    
    public static Sword Default() {
        return new Sword("Pedang Kayu", "Default", "Warrior", 3);
    }
    
    public static Sword biasa() {
        return new Sword("Pedang Ksatria", "biasa", "Warrior", 5);
    }
    
    public static Sword langka() {
        return new Sword("Pedang Petir", "langka", "Warrior", 8);
    }
    
    public static Sword epic() {
        return new Sword("Excalibur", "epic", "Warrior", 10);
    }
    
    @Override
    public String getJenisSenjata() {
        return "Sword";
    }
}
