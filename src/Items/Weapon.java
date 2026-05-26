package Items;
/**
 * class parent untuk berbagai senjata (senjatanya belum tahu wkwwkwkwkwwk)
 */
import MakhlukHidup.*;
public abstract class Weapon extends Item {
    private int bonusSerangan; //bonus ketahananannya

    public Weapon(String nama, String rarity, String classKhusus, int bonusSerangan) {
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
        return "Weapon";
    } 
    @Override
    public void pake (Hero target) {
        target.setSerangan(target.getSerangan() + bonusSerangan);
        System.out.println(target.getNama() + "memakai senjata" + getNama());
        
    }
}
