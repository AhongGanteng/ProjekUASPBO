package Lantai;

import System.*; //mengimport isi dari package System
import MakhlukHidup.*; //mengimport isi dari package MakhlukHidup
import java.util.Scanner; //memanggil class fungsi scanner

/**
 * referansi lantai dungeon
 */
public class Floor {

    private int nomorLantai; //nomor urutan lantai (1-5)
    private BossRoom RuanganBoss; //hanya untuk lantai 5
    private BattleRoom simpanRuanganBattle; //simpan refrensi battle room yang aktif
    private int perhitunganBattle; //hitung battle yang sudah diselesaikan
    private static final int jumlahRuangan = 5; //ada 5 lantai
    private static final int banyakMusuh = 3; //ada 3 musuh tiap lantai
    private Enemy musuh; //objek musuh 

    /**
     * method constructor berparameter
     * @param nomorLantai
     */
    public Floor(int nomorLantai) {
        this.nomorLantai = nomorLantai; //menyimpan nomor lantai
        musuh = MonsterFactory.bangunMusuh(nomorLantai); //mmebuat musuh sesuai level lantai
        this.perhitunganBattle = 0;
        if (isFinalFloor()) { //cek jika lantai adalah lantai final  
            this.RuanganBoss = new BossRoom(MonsterFactory.bangunBossDragon()); //buat BossRoom dengan musuh Boss Dragon
        } else { //jika bukan lantai final
            this.RuanganBoss = null; //maka tidak ada musuh boss
        }
    }
    /**
     * method getter nomorLantai
     * mengembalikan nilai nomorLantai
     * @return integer nomorLantai
     */
    public int getNomorLantai() {
        return nomorLantai; 
    }
    /**
     * method getter ruanganBoss
     * mengembalikan nilai BossRoom lantai 
     * akan null jika bukan lantai final
     * @return objek BossRoom
     */
    public BossRoom getRuanganBoss() {
        return RuanganBoss; //mengembalikan nilai ruangan boss
    }
    /**
     * method getter simpanRuanganBattle
     * mengembalikan nilai BattleRoom yang aktif atau terakhir dimainkan
     * @return objek BattleRoom yang disimpan
     */
    public BattleRoom getSimpanRuanganBattle() {
        return simpanRuanganBattle; //mengembalikan nilai battle room yang aktif
    }
    /**
     * membuat BattleRoom baru dengan musuh baru
     * untuk mulai battle berikutnya 
     * simpan hasil ke simpanRuanganBattle
     * @return 
     */
    public BattleRoom buatBattleSelanjutnya() {
        musuh = MonsterFactory.bangunMusuh(nomorLantai); //buat ulang musuh baru sesuai lantai
        return simpanRuanganBattle = new BattleRoom(musuh); //buat BattleRoom baru dan simpan di simpanRuaangBattle
    }

    /**
     * cek lantai apakah sudah clear
     * @return true or false
     */
    public boolean isClear() {
        return true; //mengembalikan nilai tru jika lantai sudah clear
    }

    /**
     * apakah sudah ada dilantai final
     * @return true atau false
     */
    public boolean isFinalFloor() {
        return nomorLantai == jumlahRuangan; //membandingkan nilai nomor lantai dengan total lantai, jika 5 maka lantai final
    }

    /**
     * buat BattleRoom baru dengan musuh baru
     * @return
     */
    public BattleRoom bentukBattleRoom() {
        Enemy musuhBerikutnya = MonsterFactory.bangunMusuh(nomorLantai); //buat musuh baru sesuai lantai
        return new BattleRoom(musuhBerikutnya); //musuh baru dalam BattleRoom baru
    }

    /**
     * hitung berapa kali menang dalam melawan musuh dilantai yang sama
     */
    public void kemenanganBattle() {
        perhitunganBattle++; 
    }

    /**
     * cek apakah sudah selesai battlenya
     * @return
     */
    public boolean sudahSelesai() {
        return perhitunganBattle == banyakMusuh; //bandingkan perhitungan banyak battle sama dgn banyak musuh
    }

    /**
     * setelah battle sudah selesai, maka perhitungan akan di-reset
     */
    public void resetPerhitunganBattle() {
        perhitunganBattle = 0;
    }

    /**
     * Tampilkan intro pada saat awal masuk lantai
     */
    public void tampilkanIntroFloor() {
        System.out.println("=======================");
        System.out.println("  Lantai " + nomorLantai + "/" + jumlahRuangan);
        System.out.println("=======================");
        MonsterFactory.bangunMusuh(nomorLantai);
        System.out.println(musuh.getDeskripsi());
        System.out.println("Battle: " + banyakMusuh + " musuh per ronde");
        if (isFinalFloor()) {
            System.out.println("Kamu akan menghadapi Boss");
        }
        System.out.println("");
    }

    /**
     * saat lantai sudah diselesaikan, cooldown skill dan darah akan direset
     * @param player
     */
    public void saatLantaiClear(Hero player) {
        System.out.println("=======================");
        System.out.println("     Lantai Clear!     ");
        System.out.println("=======================");
        player.heal(player.getMaxHp());
        player.resetCooldown();
        player.kosongkanCooldown();
        System.out.println(" HP player di pulihkan");
        System.out.println(" Cooldown skill direset");
        System.out.println("");

    }
    /**
     * menjalankan seluruh alur permainan di satu lantai
     * hero mengalahkan 3 musuh
     * @param player
     * @param sistemBattle
     * @param input
     * @return 
     */
    public boolean run(Hero player, BattleSystem sistemBattle, Scanner input) {
        tampilkanIntroFloor(); //menampilkan intro lantai
        while (true) { //perulangan utama lantai, berjalan selama hero naik atau kalah
            for (int i = 1; i <= banyakMusuh; i++) { //perulangan sebanyak musuh
                System.out.println("Battle " + i + "/" + banyakMusuh);
                simpanRuanganBattle = bentukBattleRoom(); //buat battle room baru untuk musuh
                simpanRuanganBattle.enter(player); //hero masuk ke battle room

                if (!sistemBattle.mulaiBattle(player, simpanRuanganBattle.getEnemy())) { //jika hero kalah
                    return false; //mengembalikan false/kalah, lantai gagal diselesaikan
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

            if (pilih == 1) { //jika pilih 1 atau naik lantai
                if (isFinalFloor()) { //cek apakah lantai final
                    boolean bossKalah = runBossRoom(player, sistemBattle);
                    if (!bossKalah) { //jika hero kalah dgn boss
                        return false; //maka lantai gagal selesai
                    }
                }
                saatLantaiClear(player); //pulihkan HP & reset cooldown
                return true; //lantai selesai
            } else { //pilih tetap di lantai yang sama, akan mengulangi battle
                System.out.println("Kamu memilih untuk tetap di lantai " + nomorLantai);
                System.out.println("");
            }
        }
    }
    /**
     * menjalankan battle melawan boss di lantai final
     * @param player
     * @param sistemBattle
     * @return 
     */
    public boolean runBossRoom(Hero player, BattleSystem sistemBattle) {
        RuanganBoss.enter(player);
        boolean playerMenang = sistemBattle.mulaiBattle(player, RuanganBoss.getBoss());
        if (playerMenang) {
            RuanganBoss.setIsClear();
        }
        return playerMenang;
    }
    /**
     * baca dan validasi input angka dalam rentan tertentu
     * mengecek input angka
     * @param input     scanner untuk input pemain
     * @param min   nilai minimum rentan angka
     * @param max    nilai maksimum rentan angka
     * @return  angka pilih dari pemain
     */
    public int getChoicePlayer(Scanner input, int min, int max) {
        int pilih = 0; //inisialisasi awal variabel pilihan (belum input)
        do { //perulangan
            System.out.println("Pilih (" + min + "-" + max + "): "); //mencetak rentan pilihan
            while (!input.hasNextInt()) { //selama input bukan angka
                System.out.println("Pilih angka"); //minta input ulang dengan angka
                input.next(); //bersihkan input salah dari buffer
            } 
            //input angka
            pilih = input.nextInt(); //baca & simpan input dari pemain
            input.nextLine(); //bersihkan buffer di scanner
        } while (pilih > max || pilih < min); //selama angka pilih diantara rentan min dan max
        return pilih; //mengembalikan nilai pilih
    }
    /**
     * method getter jumlahRuangan, total jmlh lantai dungeon
     * @return total jmlh lantai 5
     */
    public static int getJumlahRuangan() {
        return jumlahRuangan; //mengembalikan nilai konstanta total jmlh lantai
    }
}