package MakhlukHidup;

import Interface.*;
import Items.*;

/**
 * class parent untuk setiap obyek enemy yang ada
 */
public class Enemy extends Entity implements Attackable, Deskripsi {

    private int hadiahExp; //jumlah hadiah exp saat dikalahkan
    private Item[] dropItem; //item yang di drop (jatuhkan)
    private double dropChange; //kesempatan drop item
    private int lantai; //lantai tempat enemy muncul
    /**
     * method constructor berparameter, untuk buat objek enemy baru
     * @param hadiahExp
     * @param dropItem
     * @param dropChange
     * @param lantai
     * @param nama
     * @param maxHp
     * @param serangan
     * @param ketahanan 
     */
    public Enemy(int hadiahExp, Item[] dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(nama, maxHp, serangan, ketahanan); //mewarisi parameter dari class Entity
        this.hadiahExp = hadiahExp;
        this.dropItem = dropItem;
        this.dropChange = dropChange;
        this.lantai = lantai;
    }
    /**
     * method getter hadiahExp
     * @return 
     */
    public int getHadiahExp() {
        return hadiahExp;
    }
    /**
     * method getter dropItem
     * @return 
     */
    public Item[] getDropItem() {
        return dropItem;
    }
    /**
     * method getter dropChange
     * @return 
     */
    public double getDropChange() {
        return dropChange;
    }
    /**
     * method getter lantai
     * @return 
     */
    public int getLantai() {
        return lantai;
    }
    /**
     * method setter 
     * @param hadiahExp 
     */
    public void setHadiahExp(int hadiahExp) {
        this.hadiahExp = hadiahExp;
    }
    /**
     * method setter
     * @param dropItem 
     */
    public void setDropItem(Item[] dropItem) {
        this.dropItem = dropItem;
    }
    /**
     * method setter
     * @param dropChange 
     */
    public void setDropChange(double dropChange) {
        this.dropChange = dropChange;
    }
    /**
     * method setter
     * @param lantai 
     */
    public void setLantai(int lantai) {
        this.lantai = lantai;
    }

    /**
     * damage serangan yang diberikan oleh obyek enemy
     * @param target, target nya itu player
     */
    @Override
    public void serang(Attackable target) {
        int damage = Math.max(1, getSerangan());
        System.out.println(getNama() + " menyerang");
        target.kenaDamage(damage);

    }

    /**
     * damage serangan yang diterima oleh obyek enemy
     * @param damage, damage yang diberikan oleh player
     */
    @Override
    public void kenaDamage(int damage) {
        int tahan = Math.max(1, damage - getKetahanan());
        setHp(getHp() - tahan);
    }

    /**
     * cek apakah obyek enemy masih hidup
     * @return hp > 0
     */
    @Override
    public boolean isAlive() {
        return getHp() > 0;
    }

    /**
     * cek apakah obyek enemy yang dikalahkan akan drop item
     * @return true jika item di drop
     */
    public Item rollDrop() {
        if (dropItem.length == 0 || dropItem == null) {
            return null;
        }
        if (Math.random() > dropChange) {
            return null;
        }
        int indeks = (int) (Math.random() * dropItem.length);
        return dropItem[indeks];
    }

    /**
     * @return tipe musuh ("GOBLIN", dll)
     */
    public String tipeMusuh() {
        return "Monster";
    }

    //tampilkan deskripsi musuh/enemy
    @Override
    public String getDeskripsi() {
        return getNama() + " adalah monster dari lantai " + getLantai();
    }
    /**
     * menampilkan status dari Enemy/musuh
     */
    @Override
    public void showStatus() {
        System.out.println("\nStatus Monster");
        System.out.println("Nama  :" + getNama());
        System.out.println("Hp   :" + getHp() + "/" + getMaxHp());
        System.out.println("Serangan :" + getSerangan());
        System.out.println("Ketahanan :" + getKetahanan());
        System.out.println("Exp :" + getHadiahExp());
    }
}
