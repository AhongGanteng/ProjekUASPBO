package MakhlukHidup;

/**
 * class parent untuk setiap makhluk hidup yang ada
 */
public abstract class Entity {

    private String nama; //nama makhluk hidup 
    private int hp; //darah saat ini
    private int maxHp; //darah maksimum
    private int serangan; //damage serangan
    private int ketahanan; //ketahanan terhadap serangan

    public Entity(String nama, int maxHp, int serangan, int ketahanan) {
        this.nama = nama;
        this.maxHp = maxHp;
        this.hp = maxHp; //permainan dimulai dari hp penuh
        this.serangan = serangan;
        this.ketahanan = ketahanan;
    }

    public String getNama() {
        return nama;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getSerangan() {
        return serangan;
    }

    public int getKetahanan() {
        return ketahanan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    //hp saat ini tidak boleh negatif
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setSerangan(int serangan) {
        this.serangan = serangan;
    }

    public void setKetahanan(int ketahanan) {
        this.ketahanan = ketahanan;
    }

    /**
     * heal tidak boleh melebihi jumlah darah maksimum
     *
     * @param jumlah
     */
    public void heal(int jumlah) {
        this.hp = Math.min(this.hp + jumlah, maxHp);
    }

    /**
     * cek kondisi apakah masih hidup
     *
     * @return
     */
    public boolean isAlive() {
        return this.hp > 0;
    }

    //tampilkan status
    public abstract void showStatus();
}
