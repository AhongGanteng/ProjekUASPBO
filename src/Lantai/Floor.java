 package Lantai;
import System.EnemyFactory;
import System.*;
import MakhlukHidup.*;
import java.util.Scanner;
/**
 * referansi lantai dungeon
 */
public class Floor{
    private int nomorLantai;
    private BossRoom RuanganBoss; //hanya untuk lantai 5
    private BattleRoom simpanRuanganBattle;
    private int perhitunganBattle;
    private static final int jumlahRuangan = 5; //ada 5 lantai
    private static final int banyakMusuh = 3;
    /**
     * pokoknya kontruktor
     * @param nomorLantai 
     */
    public Floor(int nomorLantai) {
        this.nomorLantai = nomorLantai;
        Enemy musuh = EnemyFactory.bangunMusuh(nomorLantai);
        this.perhitunganBattle = 0;
        if (isFinalFloor()) {
            this.RuanganBoss = new BossRoom(EnemyFactory.bangunBossDragon());
        } else {
            this.RuanganBoss = null;
        }
    }
    
    public int getNomorLantai() {
        return nomorLantai;
    }

    public BossRoom getRuanganBoss() {
        return RuanganBoss;
    }

    public BattleRoom getSimpanRuanganBattle() {
        return simpanRuanganBattle;
    }
    
    public BattleRoom buatBattleSelanjutnya() {
        Enemy musuh = EnemyFactory.bangunMusuh(nomorLantai);
        return simpanRuanganBattle = new BattleRoom(musuh);
    }
    /**
     * cek lantai apakah sudah clear
     * @return true ot false
     */
    public boolean isClear() {
        return true;
    }
    /**
     * apakah sudah ada dilantai final
     * @return true atau false
     */
    public boolean isFinalFloor() {
        return nomorLantai == jumlahRuangan;
    }
    /**
     * 
     * @return 
     */
    public BattleRoom bentukBattleRoom() {
        Enemy musuh = EnemyFactory.bangunMusuh(nomorLantai);
        return new BattleRoom(musuh);
    }
    /**
     * hitung berapa kali menang dalam melawan musuh dilantai yang sama
     */
    public void kemenanganBattle() {
        perhitunganBattle++;
    }
    /**
     * cek apakah sudah selesai battlenya
     */
    public boolean apakahSudahSelesai() {
        return perhitunganBattle == banyakMusuh;
    }
    /**
     * setelah battle sudah selesai, maka perhitungan akan di-reset
     */
    public void resetPerhitunganBattle(){
        perhitunganBattle = 0;
    }
    /**
     * tunjukin udah battle ke berapa misal battle (2/3)
     */
    public void showRoundBattle() {
        
    }
    /**
     * Tampilkan intro pada saat awal masuk lantai
     */
    public void tampilkanIntroFloor() {
        
    }
    /**
     * saat lantai sudah diselesaikan, cooldown skill dan darah akan direset
     */
    public void saatLantaiClear() {
        
    }
    
    public boolean run(Hero player, BattleSystem sistemBattle, Scanner input) {
        return false;
    }
    
    public boolean runbossRoom(Hero player, BattleSystem sistemBattle) {
        return false;
    }
    
    public int getChoicePlayer(Scanner input, int min, int max) {
        return 0;
    }
}
