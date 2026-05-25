package Interface;

/**
 * Diimplementasikan ke obyek entitas yang bisa menyerang dan menerima damage
 */
public interface Attackable {

    /**
     * Melakukan serangan ke target
     *
     * @param target, entitas yang diserang
     */
    public void serang(Attackable target);

    /**
     * Menerima damage dari serangan
     *
     * @param damage, jumlah damage yang diterima
     */
    public void kenaDamage(int damage);

    /**
     * Cek apakah entitas masih hidup
     *
     * @return true jika hp > 0
     */
    public boolean isAlive();
}
