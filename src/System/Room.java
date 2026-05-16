package System;
import Interface.*;
import MakhlukHidup.*;
/**
 * ini class referensi untuk ruangan boss dan battle
 */
public abstract class Room implements Deskripsi{
    private String namaLantai;
    private boolean isClear;

    public Room(String namaLantai) {
        this.namaLantai = namaLantai;
        this.isClear = false;
    }

    public String getNamaLantai() {
        return namaLantai;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setIsClear() {
        this.isClear = true;
    }
    //mirip seperti pintu masuk ke dungeonnya
    public abstract void enter(Hero player);
    
    @Override
    public void showStatus() {
        
    }
    @Override
    public String getDeskripsi() {
        return null;
    }
}
