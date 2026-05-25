package Items;

import MakhlukHidup.*;
import Items.*;

/**
 * potion untuk memulihkan darah player small heal potion = pulihin 30 darah big
 * heal potion = pulihin 60 darah mega heal potion = pulihin 100 darah
 */
public class HealthPotion extends Potion {

    private int jumlahPemulihan;

    public HealthPotion(int jumlahPemulihan, int quantity, String nama, String rarity) {
        super(quantity, nama, rarity);
        this.jumlahPemulihan = jumlahPemulihan;
    }

    public int getJumlahPemulihan() {
        return jumlahPemulihan;
    }

    @Override
    public void terimaEfek(Hero target) {
        target.heal(jumlahPemulihan);
        System.out.println(target.getNama() + " memulihkan " + jumlahPemulihan + " HP!");
    }

    @Override
    public String getDeskripsi() {
        return "[" + getRarity() + "] " + getNama() + " (Heal +" + jumlahPemulihan + " HP)";
    }

    public static HealthPotion Biasa() {
        return new HealthPotion(30, 1, "Small heal potion", "Biasa");
    }

    public static HealthPotion Langka() {
        return new HealthPotion(60, 1, "big heal potion", "Langka");
    }

    public static HealthPotion Epic() {
        return new HealthPotion(100, 1, "Mega heal potion", "Epic");
    }
}
