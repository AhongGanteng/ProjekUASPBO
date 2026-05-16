package MakhlukHidup;
import Interface.*;
/**
 * ini monster goblinnya
 */
public class Goblin extends Enemy {

    public Goblin(int hadiahExp, String dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(hadiahExp, dropItem, dropChange, lantai, nama, maxHp, serangan, ketahanan);
    }
    
    @Override
    public void serang(Attackable target) {
        
    }
    
    @Override
    public String tipeMusuh() {
        return "Goblin";
    }
    
    @Override
    public String getDeskripsi() {
        return "blabla";
    }
    @Override
    public boolean isAlive() {
        return getHp() > 0;
    }
    
    @Override
    public void showStatus() {
        
    }
}
