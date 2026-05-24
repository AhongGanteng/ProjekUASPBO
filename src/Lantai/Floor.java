package Lantai;

import System.EnemyFactory;
import System.*;
import MakhlukHidup.*;
import java.util.Scanner;

/**
 * referansi lantai dungeon
 */
public class Floor {

    private int nomorLantai;
    private BossRoom RuanganBoss; //hanya untuk lantai 5
    private BattleRoom simpanRuanganBattle;
    private int perhitunganBattle;
    private static final int jumlahRuangan = 5; //ada 5 lantai
    private static final int banyakMusuh = 3;

    /**
     * pokoknya kontruktor
     *
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

    public class BossRoom {
    private Enemy boss;

    public BossRoom(Enemy boss) {
        this.boss = boss;
    }

    public boolean run(Hero player, BattleSystem sistemBattle) {
        // logic battle boss
        return true;
    }
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
     *
     * @return true ot false
     */
    public boolean isClear() {
        return true;
    }

    /**
     * apakah sudah ada dilantai final
     *
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
    public void resetPerhitunganBattle() {
        perhitunganBattle = 0;
    }

    /**
     * tunjukin udah battle ke berapa misal battle (2/3)
     */
    public void showRoundBattle() {
        System.out.println("Battle" + (perhitunganBattle + 1) + "/" + banyakMusuh);

    }

    /**
     * Tampilkan intro pada saat awal masuk lantai
     */
    public void tampilkanIntroFloor() {
        System.out.println("=====================");
        System.out.println("Masuk Floor" + nomorLantai);
        System.out.println("=====================");

        if (isFinalFloor()) {
            System.out.println("Warning!!!");
            System.out.println("Boss Dragon menunggu...");
        } else {
            System.out.println("Ada monster di lantai ini!");
        }

    }

    /**
     * saat lantai sudah diselesaikan, cooldown skill dan darah akan direset
     */
    public void saatLantaiClear() {
        System.out.println("\nFloor " + nomorLantai + "Clear");
    }

    public boolean run(Hero player, BattleSystem sistemBattle, Scanner input) {
        tampilkanIntroFloor();
        while (!apakahSudahSelesai()) {
            showRoundBattle();
            BattleRoom room = buatBattleSelanjutnya();
            boolean menang = room.run(player, sistemBattle);

            if (!menang) {
                return false;
            }
            kemenanganBattle();
        }
        saatLantaiClear();

        return true;
    }

    public boolean runbossRoom(Hero player, BattleSystem sistemBattle) {
        if (RuanganBoss == null) {
            return true;
        }
        System.out.println(" Boss Room");
        return RuanganBoss.run(player, sistemBattle);

    }

    public int getChoicePlayer(Scanner input, int min, int max) {
        int pilihan;

        while (true) {
            System.out.print("Pilih :");
            pilihan = input.nextInt();

            if (pilihan >= min && pilihan <= max) {
                return pilihan;
            }

            System.out.println("Input tidak valid");

        }
    }
}
