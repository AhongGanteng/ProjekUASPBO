/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armors;
import Items.*;
/**
 *
 * @author LENOVO
 */
public class HeavyArmor extends Armor{

    public HeavyArmor(String nama, String rarity, int bonusKetahanan) {
        super(nama, rarity, bonusKetahanan);
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(DEF +" + getBonusKetahanan() + ")";
    }
}
