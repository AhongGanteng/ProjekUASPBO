package MakhlukHidup;
import Interface.*;
import Items.*;
/**
 * class parent untuk setiap obyek enemy yang ada
 */
public abstract class Enemy extends Entity implements Attackable, Deskripsi{
    private int hadiahExp; //jumlah hadiah exp saat dikalahkan
    private Item[] dropItem; //item yang di drop (jatuhkan)
    private double dropChange; //kesempatan drop item
    private int lantai; //lantai tempat enemy muncul

    public Enemy(int hadiahExp, Item[] dropItem, double dropChange, int lantai, String nama, int maxHp, int serangan, int ketahanan) {
        super(nama, maxHp, serangan, ketahanan);
        this.hadiahExp = hadiahExp;
        this.dropItem = dropItem;
        this.dropChange = dropChange;
        this.lantai = lantai;
    }

    public int getHadiahExp() {
        return hadiahExp;
    }

    public Item[] getDropItem() {
        return dropItem;
    }

    public double getDropChange() {
        return dropChange;
    }

    public int getLantai() {
        return lantai;
    }

    public void setHadiahExp(int hadiahExp) {
        this.hadiahExp = hadiahExp;
    }

    public void setDropItem(Item[] dropItem) {
        this.dropItem = dropItem;
    }

    public void setDropChange(double dropChange) {
        this.dropChange = dropChange;
    }

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
        int indeks = (int)(Math.random() * dropItem.length);
        return dropItem[indeks];
    }
    /**
     * @return tipe musuh ("GOBLIN", dll)
     */
    public abstract String tipeMusuh();
}
