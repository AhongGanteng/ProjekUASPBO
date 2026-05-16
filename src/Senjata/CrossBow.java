/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Senjata;
import Items.*;
/**
 *
 * @author LENOVO
 */
public class CrossBow extends Weapon{
    public CrossBow() {
        super("CrossBow", "Epic", 30);
    }
    @Override
    public String getJenisSenjata() {
        return "Bow";
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }
}
