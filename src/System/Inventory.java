package System;
import java.util.ArrayList;
import java.util.List;
import Items.*;
import MakhlukHidup.*;
/**
 * Penyimpanan untuk player
 */
public class Inventory {
    private List<Item> items;
    private int maxSlots;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    
    public Inventory(int maxSlots) {
        this.items = new ArrayList<>();
        this.maxSlots = maxSlots;
        this.equippedWeapon = null;
        this.equippedArmor = null;
    }

    public List<Item> getItems() {
        return items;
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
        return this.items.size() == maxSlots;
    }
    /**
     * menambahkankan item ke inventory
     * @param items
     * @return true atau false
     */ 
    public boolean addItem(Item items) {
        if (isFull()) {
            return false;
        }
        this.items.add(items);
        return true;
    }
    
    /**
     * Menghapus item dari inventory
     * @param items
     * @return true atau false
     */
    public boolean removeItem(Item items) {
        boolean removed = this.items.remove(items);
        return removed;
    }
    
    /**
     * Tampilin isi inventory
     */
    public void showInventory() {
        
    }
    
    /**
     * senjata yang dipake player
     * @param senjata, obyek senjata yang player dapatkan
     */
    public void equipWeapon(Weapon senjata) {
        
    }
    
    /**
     * armor yang dipake player
     * @param armor, obyek armor yang player dapatkan
     */
    public void equipArmor(Armor armor) {
        
    }
    
    /**
     * potion dipakai player
     * @param ramuan, ramuan yang akan dipakai
     * @param target, target adalah player
     */
    public void usePotion(Potion ramuan, Hero target) {
        
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
    
}
