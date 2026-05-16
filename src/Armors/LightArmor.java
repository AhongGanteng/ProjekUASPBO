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
public class LightArmor extends Armor{

    public LightArmor() {
        super("Light armor", "Langka", 15);
    }
    
    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "]" + getNama() + "(DEF +" + getBonusKetahanan() + ")";
    }
}
