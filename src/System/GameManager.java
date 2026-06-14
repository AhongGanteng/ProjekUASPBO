package System;

import MakhlukHidup.*;
import Lantai.*;
import java.util.Scanner;

/**
 * class untuk mengelola jalannya permainan 
 * tampil title, game over, game clear
 * pembuat hero, loop lantai, awalan game
 * @author LENOVO
 */
public class GameManager {

    private Scanner input;
    private BattleSystem sistemBattle; //sistemBattle mengelola pertarungan
    private Hero player;
    //constructor default
    public GameManager() {
        this.input = new Scanner(System.in);
        this.sistemBattle = new BattleSystem(input);
    }
    /**
     * baca & validasi input angka dari player dengan rentan tertentu
     * mengecek input player yang sesuai
     * @param min
     * @param max
     * @return 
     */
    public int getChoice(int min, int max) {
        int pilih = 0;
        do {
            while (!input.hasNextInt()) {
                System.out.print("Masukkan angka: ");
                input.next();
            }
            pilih = input.nextInt();
            input.nextLine();
        } while (pilih < min || pilih > max);
        return pilih;
    }
    //tampilkan judul di layar permainan
    public void showTitle() {
        System.out.println("|--------------------------------------|");
        System.out.println("|                                      |");
        System.out.println("|           DUNGEON CRAWLER            |");
        System.out.println("|         TURN-BASED ADVENTURE         |");
        System.out.println("|                                      |");
        System.out.println("|--------------------------------------|");
        System.out.println("");
        tekanEnterUntukContinue();
    }
    //tampilkan Game Over jika kalah pertarungan
    public void showGameOver() {
        System.out.println("|--------------------------------------|");
        System.out.println("|                                      |");
        System.out.println("|              GAME OVER               |");
        System.out.println("|                                      |");
        System.out.println("|   Petualanganmu berakhir di sini.    |");
        System.out.println("|   Dungeon terlalu kuat untukmu...    |");
        System.out.println("|                                      |");
        System.out.println("|--------------------------------------|");
    }
    //tampilkan Game Clear jika hero berhasil selesaikan semua lantai
    public void showGameClear() {
        System.out.println("|--------------------------------------|");
        System.out.println("|                                      |");
        System.out.println("|             GAME CLEARED             |");
        System.out.println("|                                      |");
        System.out.println("| " + player.getNama() + " menaklukan dungeon!");
        System.out.println("|                                      |");
        System.out.println("|--------------------------------------|");
    }
    /**
     * tampilkan menu pilih class Hero, minta player masukkan nama
     * jika nama tdk diisi, pakai nama default "Herawan"
     * kembalikan objek Hero sesuai pilihan player
     * @return 
     */
    public Hero bangunPlayer() {
        System.out.println("|-----------------------------------|");
        System.out.println("|         PILIH CLASS HERO          |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  [1] Warrior                      |");
        System.out.println("|      HP: 150 | ATK: 18 | DEF: 12  |"); // sudah include weapon+armor
        System.out.println("|      Skill  : Shield Bash         |");
        System.out.println("|      Passive: Toughness           |");
        System.out.println("|      Senjata: Wooden Sword        |");
        System.out.println("|      Armor  : Leather Armor       |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  [2] Archer                       |");
        System.out.println("|      HP: 110 | ATK: 25 | DEF: 8  |"); // sudah include weapon+armor
        System.out.println("|      Skill  : Piercing Arrow      |");
        System.out.println("|      Passive: Critical Shot       |");
        System.out.println("|      Senjata: Wooden Bow          |");
        System.out.println("|      Armor  : Cloth Armor         |");
        System.out.println("|-----------------------------------|");
        System.out.print("Pilihan: ");
        int pilih = getChoice(1, 2);
        System.out.print("Masukan nama player: ");
        String nama = input.nextLine();
        if (nama.isEmpty()) {
            nama = "Hermawan";
        }
        Hero pilihan = null;
        switch (pilih) {
            case 1 ->
                pilihan = new Warrior(nama);
            default ->
                pilihan = new Archer(nama);
        }
        System.out.println("");
        System.out.println("Hero dibuat: " + pilihan.getDeskripsi());
        return pilihan;
    }
    //meminta player tekan enter untuk mulai game
    public void tekanEnterUntukContinue() {
        System.out.println("Tekan enter untuk lanjut......");
        this.input.nextLine();

    }
    //baca & validasi input angka dari player dengan rentan tertentu
    public int getPilihanPlayer(int min, int max) {
        int pilihan = 0;
        do {
            while (!input.hasNextInt()) {
                System.out.println("Pilihan harus angka: ");
                input.next();
            }
            pilihan = input.nextInt();
            input.nextLine();
        } while (pilihan > max || pilihan < min);
        return pilihan;
    }
    /**
     * menjalankan alur game dari awal sampai akhir
     * jika hero kalah di tengah jalan, loop berhenti dan tampil Game Over
     * jika hero menang/ berhasil melewati semua lantai, tampil Game Clear
     */
    public void start() {
        showTitle();
        this.player = bangunPlayer();
        System.out.println("");
        System.out.println("Selamat datang " + player.getNama() + "!");
        System.out.println("Silahkan masuk ke dungeon!");
        System.out.println("");
        tekanEnterUntukContinue();

        for (int lantai = 1; lantai <= Floor.getJumlahRuangan(); lantai++) {
            Floor lantaiDungeon = new Floor(lantai);
            boolean selesai = lantaiDungeon.run(player, sistemBattle, input);
            if (!selesai) {
                showGameOver();
                break;
            }
            if (lantaiDungeon.isFinalFloor()) {
                showGameClear();
                break;
            }
        }
    }
}