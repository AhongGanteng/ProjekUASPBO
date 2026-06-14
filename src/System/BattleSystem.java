package System;

import MakhlukHidup.*;
import Items.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *class untuk sistem pertarung (battle) 
 * atur giliran serang hero dan musuh, aksi dr hero
 * drop item, kondisi menang & kalah
 */
public class BattleSystem {

    private Scanner input;
    //constructor berparameter, untuk buat BattleSystem baru
    public BattleSystem(Scanner input) {
        this.input = input;
    }
    /**menjalankan satu sesi battle 
     * serangan bergantian, dengan hero giliran pertama
     * @param player
     * @param musuh
     * @return 
     */
    public boolean mulaiBattle(Hero player, Enemy musuh) {
        tampilIntroBattle(player, musuh);
        boolean heroFirst = true;
        while (player.isAlive() && musuh.isAlive()) {
            if (heroFirst) {
                if (!giliranPlayer(player, musuh)) {
                    return false;
                }
                if (!musuh.isAlive()) {
                    break;
                }
                giliranMusuh(player, musuh);
            } else {
                giliranMusuh(player, musuh);
                if (!player.isAlive()) {
                    break;
                }
                if (!giliranPlayer(player, musuh)) {
                    return false;
                }
            }
            System.out.println("");
        }
        if (player.isAlive()) {
            saatHeroMenang(player, musuh);
            return true;
        } else {
            saatMusuhMenang(player);
            return false;
        }
    }
    /**
     * jalankan giliran hero dalam battle
     * tampilkan status hero & musuh, minta hero pilih aksi
     * setelah aksi selesai, hitung cooldown
     * @param player
     * @param musuh
     * @return 
     */
    public boolean giliranPlayer(Hero player, Enemy musuh) {
        System.out.println("========================");
        System.out.println("     GILIRAN PLAYER");
        System.out.println("========================");

        player.showStatus();
        System.out.println("");
        musuh.showStatus();
        System.out.println("");

        boolean aksiSelesai = false;
        while (!aksiSelesai) {
            tampilActionMenu(player);
            int pilih = getPlayerChoise(1, 3);
            System.out.println("");
            switch (pilih) {
                case 1 -> {
                    player.serang(musuh);
                    aksiSelesai = true;
                }
                case 2 ->
                    aksiSelesai = aturSkillHero(player, musuh);
                case 3 ->
                    aksiSelesai = aturPotionHero(player);
            }
        }
        player.hitungCooldown();
        return aksiSelesai;
    }
    /**
     * tampil menu aksi yang dipilih hero
     * tampil status cooldown skill
     * @param player 
     */
    public void tampilActionMenu(Hero player) {
        System.out.println("Pilih aksi: ");
        System.out.println("[1] Attack");
        System.out.println("[2] Skill - " + player.getNamaSkill() + " (" + player.getCooldownSekarang() + ")");
        System.out.println("[3] Potion");
        System.out.print("Pilih: ");
    }
    /**
     * penggunaan skill hero, dengan cek cooldown habis (ready)
     * @param player
     * @param musuh
     * @return 
     */
    public boolean aturSkillHero(Hero player, Enemy musuh) {
        if (!player.isSkillReady()) {
            System.out.println("Skill belum ready!(" + player.getCooldownSekarang() + "turn lagi)");
            return false;
        } else {
            player.useSkill(musuh);
            return true;
        }
    }
    /**
     * mengatur penggunaan potion pd hero saat battle
     * tampil daftar potion, minta hero memilih
     * batal memilih jika [0]
     * @param player
     * @return 
     */
    public boolean aturPotionHero(Hero player) {
        List<Potion> ramuan = player.getPenyimpanan().getPotions();
        if (ramuan.isEmpty()) {
            System.out.println("Ramuan tidak tersedia");
            return false;
        }
        System.out.println("Pilih potion:");
        for (int i = 0; i < ramuan.size(); i++) {
            System.out.printf("  [%d] %s%n", (i + 1), ramuan.get(i).getDeskripsi());
        }
        System.out.println("  [0]. Batal");
        int pilih = getPlayerChoise(0, ramuan.size());
        if (pilih == 0) {
            System.out.println("Dibatalkan");
            return false;
        }
        player.getPenyimpanan().usePotion(ramuan.get(pilih - 1), player);
        return true;
    }
    /**
     * musuh menyerang hero
     * @param player
     * @param musuh 
     */
    public void giliranMusuh(Hero player, Enemy musuh) {
        System.out.println("");
        System.out.println("========================");
        System.out.println("     GILIRAN ENEMY");
        System.out.println("========================");
        musuh.serang(player);
    }
    /**
     * kondisi hero mengalahkan musuh
     * hero dapat EXP dari musuh & kemungkinan musuh meg-drop item
     * @param player
     * @param musuh 
     */
    public void saatHeroMenang(Hero player, Enemy musuh) {
        System.out.println("");
        System.out.println("========================");
        System.out.println("        MENANG");
        System.out.println("========================");
        player.dapatExp(musuh.getHadiahExp(), player);
        Item drop = musuh.rollDrop();
        if (drop != null) {
            System.out.println(musuh.getNama() + " menjatuhkan " + drop.getDeskripsi() + "!");
            aturItemDrop(player, drop);
        }
        System.out.println("");
    }
    /**
     * kondisi hero kalah dari musuh (Game Over)
     * tampil pesan game over & status akhir hero
     * @param player 
     */
    public void saatMusuhMenang(Hero player) {
        System.out.println("");
        System.out.println("========================");
        System.out.println("       GAME OVER");
        System.out.println("========================");
        System.out.println(player.getNama() + " telah gugur");
        player.showStatus();
    }
    /**
     * tampil intro sebelum battle dimulai
     * nama hero vs musuh
     * @param player
     * @param musuh 
     */
    public void tampilIntroBattle(Hero player, Enemy musuh) {
        System.out.println("");
        System.out.println("=====================================");
        System.out.printf("|  %-32s ║%n", player.getNama() + " VS " + musuh.getNama() + "    |");
        System.out.println("=====================================");
    }
    /**
     * hitung total quantity semua potion pada hero
     * menampilkan ringkasan stok potion hero
     * @param player
     * @return 
     */
    public int countPotions(Hero player) {
        int total = 0;
        for (Item i : player.getPenyimpanan().getPotions()) {
            total += ((Potion) i).getQuantity();
        }
        return total;
    }
    /**
     * baca & validasi input angka dari player dengan rentan tertentu
     * @param min
     * @param max
     * @return 
     */
    public int getPlayerChoise(int min, int max) {
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
    /**
     * menangani keputusan hero saat musuh meng-drop item
     * senjata & armor : pilih equip atau buang
     * potion " langsung pakai atau simpan inventory, atau nbuang
     * @param player
     * @param drop 
     */
    public void aturItemDrop(Hero player, Item drop) {
        int pilih;
        System.out.println("");
        if (drop instanceof Armor || drop instanceof Sword || drop instanceof Busur) {
            System.out.println("[1] Equip " + drop.getNama() + "[" + drop.getRarity() + "]");
            System.out.println("[2] Buang " + drop.getNama() + "[" + drop.getRarity() + "]");
            System.out.print("Pilih: ");
            pilih = getPlayerChoise(1, 2);
            System.out.println("");
            switch (pilih) {
                case 1 -> {
                    drop.pake(player);
                }
                case 2 -> {
                    System.out.println("Item dibuang");
                }
            }
        } else {
            System.out.println("[1] Equip Potion");
            System.out.println("[2] Masukan ke Inventory");
            System.out.println("[3] Buang Potion");
            System.out.print("Pilih: ");
            pilih = getPlayerChoise(1, 3);
            System.out.println("");
            switch (pilih) {
                case 1 -> {
                    drop.pake(player);
                }
                case 2 -> {
                    Potion p = (Potion) drop;
                    boolean tambahin = player.getPenyimpanan().addItem(p);
                    if (!tambahin) {
                        System.out.println("Inventory penuh!");
                    }
                }
                case 3 -> {
                    System.out.println("Item dibuang");
                }
            }
        }
    }
}