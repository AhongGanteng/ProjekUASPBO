/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items;

/**
 *
 * @author LENOVO
 */
public class Sword extends Weapon {

    public Sword(String nama, String rarity, String classKhusus, int bonusKetahanan) {
        super(nama, rarity, classKhusus, bonusKetahanan);
    }

    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + "(ATK +" + getBonusSerangan() + ")";
    }

    public static Sword Default() {
        return new Sword("Wooden sword", "Default", "Warrior", 3);
    }

    public static Sword biasa() {
        return new Sword("Light Saber", "Biasa", "Warrior", 5);
    }

    public static Sword langka() {
        return new Sword("Blade of chaos", "Langka", "Warrior", 8);
    }

    public static Sword epic() {
        return new Sword("Dragon slayer", "Epic", "Warrior", 10);
    }

    @Override
    public String getJenisSenjata() {
        return "Sword";
    }
}
