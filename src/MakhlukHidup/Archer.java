package MakhlukHidup;
import Interface.*;
import System.*;
/**
 * salah satu anak dari class hero, 
 * senjatanya busur, 
 * punya pasif peningkatan damage 2 kali lipat dengan kesempatan 25%, 
 * dan punya skill yaitu damage +80% dan pengurangan defense musuh -3 dengan cooldown 3 turn
 */
public class Archer extends Hero{
    private final double critChange = 0.25; //kesempatan untuk mendapatkan penambahan damage
    private final int critticalDamage = 2; //damage akan di kali 2
    /**
     * nama player
     * darah warrior = 100
     * damage serangan = 20
     * ketahanan = 6
     * jeda penggunaan skill = 3
     * @param nama 
     */
    public Archer(String nama) {
        super(nama, 100, 20, 6, "Archer", 3);
    }
    /**
     * damage serangan yang diberikan oleh player
     * @param target, targetnya adalah obyek Enemy
     */
    @Override
    public void serang (Attackable target) {
        
    }
    /**
     * Skill yang dimiliki oleh class Warrior
     * peningkatan damage +80% dan ketahanan musuh -3
     * @param target, target serangan
     */
    @Override
    public void useSkill(Attackable target) {
        
    }
    /**
     * Nama skill untuk class Archer
     * @return nama skill nya
     */
    @Override 
    public String getNamaSkill() {
        return null;
    }
    //tampilkan deskripsi player
    @Override
    public String getDeskripsi() {
        return null;
    }
    /**
     * hal yang bisa mengaktifkan skill pasif class Archer
     */
    @Override
    public void triggerPasif(){
        
    }
    /**
     * nama pasifnya
     */
    @Override 
    public void getNamaPasif() {
        
    }
}
