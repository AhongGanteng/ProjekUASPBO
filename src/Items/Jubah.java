/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items;
import Items.*;
/**
 *
 * @author LENOVO
 */
public class Jubah extends Armor{

    public Jubah(String nama, String rarity, int bonusKetahanan) {
        super(nama, rarity, bonusKetahanan);
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(DEF +" + getBonusKetahanan() + ")";
    }
    
    public static Jubah Default() {
        return new Jubah("", "", 3);
    }
    
    public static Jubah biasa() {
        return new Jubah("", "", 5);
    }
    
    public static Jubah langka() {
        return new Jubah("", "", 8);
    }
    
    public static Jubah epic() {
        return new Jubah("", "", 10);
    }
}
