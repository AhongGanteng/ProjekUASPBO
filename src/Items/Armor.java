package Items;
/**
 * class parent untuk berbagai armor (armornya 3 aja wkwwkwkwkwwk)
 */
import MakhlukHidup.*;
public abstract class Armor extends Item {
    private int bonusKetahanan; //bonus ketahananannya

    public Armor(String nama, String rarity, int bonusKetahanan) {
        super(nama, rarity);
        this.bonusKetahanan = bonusKetahanan;
    }

    public int getBonusKetahanan() {
        return bonusKetahanan;
    }

    public void setBonusKetahanan(int bonusKetahanan) {
        this.bonusKetahanan = bonusKetahanan;
    }
    @Override
    public String getItemType () {
        return "Armor";
        
    } 
    @Override
    public void pake (Hero target) {
        
        target.setKetahanan(target.getKetahanan()+ bonusKetahanan);
        System.out.println(target.getNama()+ "memakai armor" + getNama());
        
    }
}
