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
    public boolean sudahSelesai() {
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
        System.out.println("=======================");
        System.out.println("  Lantai " + nomorLantai + "/" + jumlahRuangan );
        System.out.println("=======================");
        Enemy musuh = EnemyFactory.bangunMusuh(nomorLantai);
        System.out.println("Musuh : " + musuh.getNama());
        System.out.println("Battle: " + banyakMusuh + " musuh per ronde");
        if (isFinalFloor()) {
            System.out.println("Kamu akan menghadapi Boss");
        }
        System.out.println("");
    }
    /**
     * saat lantai sudah diselesaikan, cooldown skill dan darah akan direset
     */
    public void saatLantaiClear(Hero player) {
        System.out.println("=======================");
        System.out.println("     Lantai Clear!     ");
        System.out.println("=======================");
        player.heal(player.getMaxHp());
        player.resetCooldown();
        System.out.println(" HP player di pulihkan");
        System.out.println(" Cooldown skill direset");
        System.out.println("");
        
    }
    
    public boolean run(Hero player, BattleSystem sistemBattle, Scanner input) {
        tampilkanIntroFloor();
        while(true) {
            for (int i = 1; i <= banyakMusuh; i++) {
                System.out.println("Battle " + i + "/" + banyakMusuh);
                simpanRuanganBattle = bentukBattleRoom();
                simpanRuanganBattle.enter(player);
                
                if (!sistemBattle.mulaiBattle(player, simpanRuanganBattle.getEnemy())) {
                    return false;
                }
            }
            System.out.println("|--------------------------------------|");
            System.out.println("| 3 musuh sudah dikalahkan             |");
            System.out.println("|--------------------------------------|");
            System.out.println("| [1] Naik ke lantai selanjutnya       |");
            System.out.println("| [2] Tetap di lantai ini              |");
            System.out.println("|--------------------------------------|");
            System.out.print("Pilih: ");
            int pilih = getChoicePlayer(input, 1, 2);
            
            switch(pilih){
                case 1: {
                    if (isFinalFloor()) {
                        boolean bossKalah = runBossRoom(player, sistemBattle);
                        if (!bossKalah) {
                            return false;
                        }
                        saatLantaiClear(player);
                        return true;
                    }
                }
                default: {
                    System.out.println("Kamu memilih untuk tetap di lantai " + nomorLantai);
                    System.out.println("");
                }
            }
        }
    }
    
    public boolean runBossRoom(Hero player, BattleSystem sistemBattle) {
        RuanganBoss.enter(player);
        boolean playerMenang = sistemBattle.mulaiBattle(player, RuanganBoss.getBoss());
        if (playerMenang) {
            RuanganBoss.setIsClear();
        }
        return true;
    }
    
    public int getChoicePlayer(Scanner input, int min, int max) {
        int pilih = 0;
        do {
            System.out.println("Pilih (" + min + "-" + max + "): ");
            while (!input.hasNextInt()) {
                System.out.println("Pilih angka");
                input.next();
            }
            pilih = input.nextInt();
            input.nextLine();
        } while (pilih > max || pilih < min);
        return pilih;
    }

    public static int getJumlahRuangan() {
        return jumlahRuangan;
    }
}
