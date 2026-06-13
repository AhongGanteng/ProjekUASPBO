package Items;
/**
 * class parent untuk berbagai senjata (senjatanya belum tahu wkwwkwkwkwwk)
 */
import MakhlukHidup.*;
public abstract class Weapon extends Item {
    private String classKhusus;
    private int bonusSerangan; //bonus ketahananannya

    public Weapon(String nama, String rarity, String classKhusus, int bonusSerangan) {
        super(nama, rarity);
        this.bonusSerangan = bonusSerangan;
        this.classKhusus = classKhusus;
    }

    public int getBonusSerangan() {
        return bonusSerangan;
    }

    public void setBonusSerangan(int bonusSerangan) {
        this.bonusSerangan = bonusSerangan;
    }

    public String getClassKhusus() {
        return classKhusus;
    }

    public void setClassKhusus(String classKhusus) {
        this.classKhusus = classKhusus;
    }
    
    public abstract String getJenisSenjata();
    
    @Override
    public String getItemType () {
        return "Weapon";
    } 
    @Override
    public void pake (Hero target) {
        if (!target.getHeroClass().equals(classKhusus)) {
        System.out.println("✗ " + target.getHeroClass() + " tidak bisa memakai " + getNama() + "!");
        return;
    }
    target.getPenyimpanan().equipWeapon(this);
    System.out.println(target.getNama() + " memakai senjata " + getNama()); // ← tambah spasi
        
    }
}
