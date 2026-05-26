package System;
import java.util.ArrayList;
import java.util.List;
import Items.*;
import MakhlukHidup.*;
/**
 * Penyimpanan untuk player
 */
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
        Potion equippedPotion = null;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public Weapon EquipWeapon() {
        return equippedWeapon;
    }

    public Armor EquipArmor() {
        return equippedArmor;
    }
    /**
     * cek apakah inventori full
     * @return true jika ukuran item sama dengan maksimum slot inventori 
     */
    public boolean isFull() {
        return this.potions.size() == maxSlots;
    }
    /**
     * menambahkankan item ke inventory
     * @param items
     * @return true atau false
     */ 
    public boolean addItem (Potion ramuan) {
        if (isFull()) {
            System.out.println("Inventory sudah penuh!");
            return false;
        }
        for (Potion ada : potions) {
            if (ada.getNama().equals(ada)) {
                ada.setQuantity(ada.getQuantity() + ramuan.getQuantity());
                System.out.println(ramuan.getNama() + " ditambahkan kedalam inventory");
                return true;
            }
        }
        potions.add(ramuan);
        System.out.println(ramuan.getNama() + "ditambahkan ke inventory ");
        return true;
    }
    
    /**
     * Menghapus item dari inventory
     * @param items
     * @return true atau false
     */
    public boolean removeItem(Item items) {
        boolean removed = this.potions.remove(items);
        return removed;
    }
    
    /**
     * Tampilin isi inventory
     */
    public void showInventory() {
        System.out.println("==INVENTORY (" + potions.size() + "/" + maxSlots + " slot)==");
        if (potions.isEmpty()) {
            System.out.println("Inventory kosong");
        } else {
            for (int i = 0; i < potions.size(); i++) {
                Potion p = potions.get(i);
                System.out.println((i + 1) + " " + p.getNama() + " x" + p.getQuantity());
            }
        }
        System.out.println("================");
        if (equippedWeapon != null) {
            System.out.println("Senjata: " + equippedWeapon.getNama() + " (ATK +" + equippedWeapon.getBonusSerangan());
        } else {
            System.out.println("Senjata: - ");
        }
        if (equippedArmor != null) {
            System.out.println("Armor: " + equippedArmor.getNama() + " (ATK +" + equippedArmor.getBonusKetahanan());
        } else {
            System.out.println("Armor: - ");
        }
    }
    
    /**
     * senjata yang dipake player
     * @param senjata, obyek senjata yang player dapatkan
     */
    public void equipWeapon(Weapon senjata) {
        if (equippedWeapon != null) {
            System.out.println("Senjata lama dibuang, diganti oleh " + senjata.getNama());
        }
        equippedWeapon = senjata;
        System.out.println("Equip senjata: " + senjata.getNama() + " ATK +" + senjata.getBonusSerangan());
    }
    
    /**
     * armor yang dipake player
     * @param armor, obyek armor yang player dapatkan
     */
    public void equipArmor(Armor armor) {
        if (equippedArmor != null) {
            System.out.println("Senjata lama dibuang, diganti oleh " + armor.getNama());
        }
        equippedArmor = armor;
        System.out.println("Equip senjata: " + armor.getNama() + " DEF +" + armor.getBonusKetahanan());
    }
    
    /**
     * potion dipakai player
     * @param ramuan, ramuan yang akan dipakai
     * @param target, target adalah player
     */
    public void usePotion(Potion ramuan, Hero target) {
        if (!potions.contains(ramuan)) {
            System.out.println(ramuan.getNama() + " tidak ada di inventory");
        }
        ramuan.pake(target);
        if (ramuan.isEmpty()) {
            potions.remove(ramuan);
            System.out.println("Potion habis");
        }
    }
    
    /**
     * ambil bonus serangan dari senjata yang dipakai
     * @return bonus serangan
     */
    public int getWeaponAtkBonus() {
        if (EquipWeapon() != null) {
            return equippedWeapon.getBonusSerangan();
        } else {
            return 0;
        }
    }
    
    /**
     * ambil bonus pertahanan dari armor yang dipakai
     * @return bonus pertahanan
     */
    public int getArmorDefBonus() {
        if (EquipArmor() != null) {
            return equippedArmor.getBonusKetahanan();
        } else {
            return 0;
        }
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
