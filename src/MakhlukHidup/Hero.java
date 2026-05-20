package MakhlukHidup;
import Interface.*;
import System.*;
/**
 * class parent untuk class Warrior, Archer, dan Mage
 */
public abstract class Hero extends Entity implements Attackable, Deskripsi{
    private String heroClass; //tipe class yang player pilih
    private int cooldownSkill; //lama jeda waktu penggunaan skill
    private int cooldownSekarang; //jeda waktu penggunaan skill sekarang
    private levelSystem level; //sistem leveling 
    private Inventory penyimpanan; //penyimpanan yang dimiliki player

    public Hero(String nama, int maxHp, int serangan, int ketahanan, String heroClass, int cooldownSkill) {
        super(nama, maxHp, serangan, ketahanan);
        this.heroClass = heroClass;
        this.cooldownSkill = cooldownSkill;
        this.cooldownSekarang = 0;
        this.level = new levelSystem();
        this.penyimpanan = new Inventory(5); //maksimal 10 item
    }

    public String getHeroClass() {
        return heroClass;
    }

    public levelSystem getLevel() {
        return level;
    }

    public Inventory getPenyimpanan() {
        return penyimpanan;
    }
    /**
     * damage serangan yang diberikan oleh player
     * @param target, targetnya adalah obyek Enemy
     */
    @Override
    public void serang (Attackable target) {
        int damage = getSerangan() + penyimpanan.getWeaponAtkBonus();
        target.kenaDamage(damage);
    }
    /**
     * damage serangan yang diterima oleh player
     * @param damage, damage yang obyek enemy berikan
     */
    @Override
    public void kenaDamage(int damage) {
        int tahan = Math.max(1, damage - (getKetahanan() - penyimpanan.getArmorDefBonus()));
        setHp(getHp() - tahan);
    }
    /**
     * cek apakah masih hidup
     * @return hp > 0
     */
    @Override
    public boolean isAlive() {
        return getHp() > 0;
    }
   /**
    * nama, hp, level, exp, attack, deffence
    * status ditampilkan saat permainan berlangsung
    * mencetak tampilan tabel
    */
    @Override
    public void showStatus() {
        System.out.println(""); //panggil nama dari GameManajer
        System.out.println(""); //darah/hp dari Entity
        System.out.println(""); //level dari Entity
        System.out.println(""); //attack dari Entitiy
        System.out.println(""); //deffence dari Entity
    }
    /**
     * tampilkan deskripsi player setelah permainan
     * tampilkan hasil dari sout
     * @return 
     */
    @Override
    public String getDeskripsi() {
        return null;
    }
    //skill yang berbeda untuk setiap class hero
    public abstract void useSkill(Attackable target);
    //nama skill yang berbeda untuk setiap class hero
    public abstract String getNamaSkill();
    //hal yang bisa mengaktifkan skill pasif
    public abstract void triggerPasif();
    //nama pasif unik dari setiap class hero
    public abstract void getNamaPasif();
    
    /**
     * skill akan cooldown setelah dipakai
     */
    public void resetCooldown () {
        this.cooldownSekarang = this.cooldownSkill;
    }
    
    /**
     * untuk hitung jeda waktu penggunaan skill
     */
    
    public void hitungCooldown() {
        if (cooldownSekarang > 0) {
            cooldownSekarang--;
        }
    }
    
    /**
     * cek skill ready untuk dipakai atau tidak
     * @return jeda waktu penggunaan skill == 0
     */
    public boolean isSkillReady() {
        return cooldownSekarang == 0;
    }
    
    /**
     * sistem leveling lah pokoknya wkwkwk
     * @param xp
     * @param player 
     */
    public void dapatExp(int xp, Hero target) {
        level.tambahExp(xp, target);
    }
}
