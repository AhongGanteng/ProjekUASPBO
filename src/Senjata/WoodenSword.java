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
public class WoodenSword extends Weapon{

    public WoodenSword() {
        super("WoodenSword", "Biasa", 10);
    }
    @Override
    public String getJenisSenjata() {
        return "Sword";
    }
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }
}
