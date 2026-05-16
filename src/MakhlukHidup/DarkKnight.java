package MakhlukHidup;
import Interface.*;
/**
 * ini monster DarkKnightnya
 */
public class DarkKnight extends Enemy{

    public DarkKnight(int hadiahExp, String dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(hadiahExp, dropItem, dropChange, lantai, nama, maxHp, serangan, ketahanan);
    }
    
    @Override
    public void serang(Attackable target) {
        
    }
    
    @Override
    public String tipeMusuh() {
        return "DarkKnight";
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
