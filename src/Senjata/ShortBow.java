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
public class ShortBow extends Weapon{
    public ShortBow() {
        super("ShortBow", "Biasa", 10);
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
