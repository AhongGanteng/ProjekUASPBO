package MakhlukHidup;
import Interface.*;
/**
 *
 * @author LENOVO
 */
public class Monster extends Enemy{
    public Monster(int hadiahExp, String dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(hadiahExp, dropItem, dropChange, lantai, nama, maxHp, serangan, ketahanan);
    }
    
    @Override
    public void serang(Attackable target) {
        
    }
    
    @Override
    public String tipeMusuh() {
        return "Dragon";
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
