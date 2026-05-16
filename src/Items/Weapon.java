package Items;
/**
 * class parent untuk berbagai senjata (senjatanya belum tahu wkwwkwkwkwwk)
 */
import MakhlukHidup.*;
public abstract class Weapon extends Item {
    private int bonusSerangan; //bonus ketahananannya

    public Weapon(String nama, String rarity, int bonusSerangan) {
        super(nama, rarity);
        this.bonusSerangan = bonusSerangan;
    }

    public int getBonusSerangan() {
        return bonusSerangan;
    }

    public void setBonusSerangan(int bonusSerangan) {
        this.bonusSerangan = bonusSerangan;
    }
    
    public abstract String getJenisSenjata();
    @Override
    public String getItemType () {
        return null;
    } 
    @Override
    public void pake (Hero target) {
        
    }
}
