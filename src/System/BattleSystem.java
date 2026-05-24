package System;
import MakhlukHidup.*;
import Items.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class BattleSystem {
    private Scanner input;

    public BattleSystem(Scanner input) {
        this.input = input;
    }
    
    public boolean mulaiBattle(Hero player, Enemy musuh) {
        player.resetPasif();
        player.resetCooldown();
        tampilIntroBattle(player, musuh);
        boolean heroFirst = Math.random() < 0.5;
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
            heroFirst = !heroFirst;
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
    
    public boolean giliranPlayer(Hero player, Enemy musuh) {
        System.out.println("========================");
        System.out.println("     GILIRAN PLAYER");
        System.out.println("========================");
        
        player.showStatus();
        System.out.println("");
        musuh.showStatus();
        System.out.println("");
        
        tampilActionMenu(player);
        int pilih = getPlayerChoise(1, 4);
        System.out.println("");
        
       boolean aksiSelesai = false;
        switch(pilih) {
            case 1:
                player.serang(musuh);
                aksiSelesai = true;
                break;
            case 2: 
                aturSkillHero(player, musuh);
                aksiSelesai = true;
                break;
            case 3: 
                aturPotionHero(player);
                aksiSelesai = true;
                break;
        }
        player.hitungCooldown();
        return aksiSelesai;
    }
    
    public void tampilActionMenu(Hero player) {
        System.out.println("Pilih aksi: ");
        System.out.println("[1] Attack");
        System.out.println("[2] Skill - " + player.getNamaSkill() + " (" + player.getCooldownSekarang() + ")");
        System.out.println("[3] Potion");
        System.out.print("Pilih: ");
    }
    
    public boolean aturSkillHero(Hero player, Enemy musuh) {
        if (!player.isSkillReady()) {
            System.out.println("Skill belum ready!(" + player.getCooldownSekarang() + "turn lagi)");
            return false;
        } else {
            player.useSkill(musuh);
            return true;
        }
    }
    
    public boolean aturPotionHero(Hero player) {
        List<HealthPotion> ramuan = new ArrayList<>();
        for (Item i : player.getPenyimpanan().getPotions()) {
            if (i instanceof HealthPotion p) {
                ramuan.add(p);
            }
        }
        if (ramuan.isEmpty()) {
            System.out.println("Ramuan tidak tersedia");
            return false;
        }
        System.out.println("Pilih potion:");
        for (int i = 0; i < ramuan.size(); i++) {
            System.out.printf("  [%d] %s%n", ramuan.get(i).getDeskripsi());
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
    
    public void giliranMusuh(Hero player, Enemy musuh) {
        System.out.println("");
        System.out.println("========================");
        System.out.println("     GILIRAN ENEMY");
        System.out.println("========================");
        musuh.serang(player);
    }
    
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
    
    public void saatMusuhMenang(Hero player) {
        System.out.println("");
        System.out.println("========================");
        System.out.println("       GAME OVER");
        System.out.println("========================");
        System.out.println(player.getNama() + " telah gugur");
        player.showStatus();
    }
    
    public void tampilIntroBattle(Hero player, Enemy musuh) {
        System.out.println("");
        System.out.println("=====================================");
        System.out.printf( "║  %-32s ║%n", player.getNama() + " VS " + musuh.getNama());
        System.out.println("=====================================");
    } 
    
    public int countPotions(Hero player) {
        int total = 0;
        for (Item i : player.getPenyimpanan().getPotions()) {
            total+=((Potion) i).getQuantity();
        }
        return total;
    }
    
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
    
    public void aturItemDrop(Hero player, Item drop) {
        int pilih;
        System.out.println("");
        if (drop instanceof Jubah || drop instanceof Sword || drop instanceof Busur) {
            System.out.println("[1] Equip " + drop.getNama() + "[" + drop.getRarity() + "]");
            System.out.println("[2] Buang " + drop.getNama() + "[" + drop.getRarity() + "]");
            System.out.print("Pilih: ");
            pilih = getPlayerChoise(1, 2);
            System.out.println("");
            switch(pilih) {
                case 1: {
                    drop.pake(player); 
                    break;}
                case 2: {
                    System.out.println("Item dibuang");
                    break;
                    }
            }
        } else {
            System.out.println("[1] Equip Potion");
            System.out.println("[2] Masukan ke Inventory");
            System.out.println("[3] Buang Potion");
            System.out.print("Pilih: ");
            pilih = getPlayerChoise(1, 3);
            System.out.println("");
            switch(pilih) {
                case 1: {
                    drop.pake(player); 
                    break;}
                case 2: {
                    Potion p = (Potion) drop;
                    boolean tambahin = player.getPenyimpanan().addItem(p);
                    if (!tambahin) {
                        System.out.println("Inventory penuh!");
                    }
                }
                case 3: {
                    System.out.println("Item dibuang");
                    break;}
                }
        }
    }
}
