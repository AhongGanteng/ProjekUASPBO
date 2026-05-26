package System;
import MakhlukHidup.*;
import Lantai.*;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class GameManager {
    private Scanner input;
    private BattleSystem sistemBattle;
    private Hero player;

    public GameManager() {
        this.input = new Scanner(System.in);
        this.sistemBattle = new BattleSystem(input);
    }
    
    public int getChoice(int min, int max) {
        int pilih = 0;
        do {
            while (!input.hasNextInt()) {
                System.out.print("Masukkan angka: ");
                input.next();
            }
            pilih = input.nextInt();
            input.nextLine(); // buang sisa newline
        } while (pilih < min || pilih > max);
        return pilih;
    }
    
    public void showTitle() {
        System.out.println("|--------------------------------------|");
        System.out.println("|                                      |");
        System.out.println("|           DUNGEON CLAWLER            |");
        System.out.println("|         TURN-BASED ADVENTURE         |");
        System.out.println("|                                      |");
        System.out.println("|--------------------------------------|");
        System.out.println("");
        tekanEnterUntukContinue();
    }
    
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
    
    public void showGameClear() {
        System.out.println("|--------------------------------------|");
        System.out.println("|                                      |");
        System.out.println("|             GAME CLEARED             |");
        System.out.println("|                                      |");
        System.out.println("| " + player.getNama() + " menaklukan dungeon!");
        System.out.println("|                                      |");
        System.out.println("|--------------------------------------|");
    }
    
    public Hero bangunPlayer() {
        System.out.println("|-----------------------------------|");
        System.out.println("|         PILIH CLASS HERO          |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  [1] Warrior                      |");
        System.out.println("|      HP: 150 | ATK: 28 | DEF: 20  |"); // sudah include weapon+armor
        System.out.println("|      Skill  : Shield Bash         |");
        System.out.println("|      Passive: Toughness           |");
        System.out.println("|      Senjata: Wooden Sword        |");
        System.out.println("|      Armor  : Leather Armor       |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  [2] Archer                       |");
        System.out.println("|      HP: 110 | ATK: 30 | DEF: 11  |"); // sudah include weapon+armor
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
        Hero pilihan =  null; 
        switch (pilih) {
            case 1 -> pilihan = new Warrior(nama);
            default ->pilihan = new Archer(nama);
        }
        System.out.println("");
        System.out.println("Hero dibuat: " + pilihan.getDeskripsi());
        return pilihan;
    }
    
    public void tekanEnterUntukContinue() {
        System.out.println("Tekan enter untuk lanjut......");
        this.input.nextLine();
        
    }
    
    public int getPilihanPlayer (int min, int max) {
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
