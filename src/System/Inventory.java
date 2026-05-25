package System;

import java.util.ArrayList;
import java.util.List;
import Items.*;
import MakhlukHidup.*;

public class Inventory {

    private List<Potion> potions;
    private int maxSlots;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private Potion equippedPotion;

    public Inventory(int maxSlots) {
        this.potions = new ArrayList<>();
        this.maxSlots = maxSlots;
        this.equippedWeapon = null;
        this.equippedArmor = null;
        this.equippedPotion = null;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public boolean isFull() {
        return this.potions.size() == maxSlots;
    }

    // PERBAIKI: bandingkan nama dengan nama ramuan
    public boolean addItem(Potion ramuan) {
        if (isFull()) {
            System.out.println("Inventory sudah penuh!");
            return false;
        }
        for (Potion ada : potions) {
            if (ada.getNama().equals(ramuan.getNama())) {
                ada.setQuantity(ada.getQuantity() + ramuan.getQuantity());
                System.out.println(ramuan.getNama() + " ditambahkan kedalam inventory");
                return true;
            }
        }
        potions.add(ramuan);
        System.out.println(ramuan.getNama() + " ditambahkan ke inventory");
        return true;
    }

    public boolean removeItem(Item items) {
        return this.potions.remove(items);
    }

    public void showInventory() {
        System.out.println("==INVENTORY (" + potions.size() + "/" + maxSlots + " slot)==");
        if (potions.isEmpty()) {
            System.out.println("Inventory kosong");
        } else {
            for (int i = 0; i < potions.size(); i++) {
                Potion p = potions.get(i);
                System.out.println((i + 1) + ". " + p.getNama() + " x" + p.getQuantity());
            }
        }
        System.out.println("================");
        if (equippedWeapon != null) {
            System.out.println("Senjata: " + equippedWeapon.getNama() + " (ATK +" + equippedWeapon.getBonusSerangan() + ")");
        } else {
            System.out.println("Senjata: - ");
        }
        if (equippedArmor != null) {
            System.out.println("Armor: " + equippedArmor.getNama() + " (DEF +" + equippedArmor.getBonusKetahanan() + ")");
        } else {
            System.out.println("Armor: - ");
        }
    }

    public void equipWeapon(Weapon senjata) {
        if (equippedWeapon != null) {
            System.out.println("Senjata lama dibuang, diganti oleh " + senjata.getNama());
        }
        equippedWeapon = senjata;
        System.out.println("Equip senjata: " + senjata.getNama() + " ATK +" + senjata.getBonusSerangan());
    }

    public void equipArmor(Armor armor) {
        if (equippedArmor != null) {
            System.out.println("Armor lama dibuang, diganti oleh " + armor.getNama());
        }
        equippedArmor = armor;
        System.out.println("Equip armor: " + armor.getNama() + " DEF +" + armor.getBonusKetahanan());
    }

    public void usePotion(Potion ramuan, Hero target) {
        if (!potions.contains(ramuan)) {
            System.out.println(ramuan.getNama() + " tidak ada di inventory");
            return;
        }
        ramuan.pake(target);
        if (ramuan.isEmpty()) {
            potions.remove(ramuan);
            System.out.println("Potion habis");
        }
    }

    public int getWeaponAtkBonus() {
        if (getEquippedWeapon() != null) {
            return equippedWeapon.getBonusSerangan();
        }
        return 0;
    }

    public int getArmorDefBonus() {
        if (getEquippedArmor() != null) {
            return equippedArmor.getBonusKetahanan();
        }
        return 0;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public Potion getEquippedPotion() {
        return equippedPotion;
    }

    public void setEquippedPotion(Potion equippedPotion) {
        this.equippedPotion = equippedPotion;
    }
}
