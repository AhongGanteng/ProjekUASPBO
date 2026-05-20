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
        player.resetCooldown();
        tampilIntroBattle(player, musuh);
        System.out.println("");
        return true;
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
        
        switch(pilih) {
            case 1 -> player.serang(musuh);
            case 2 -> aturSkillHero(player, musuh);
            case 3 -> aturPotionHero(player, musuh);
        }
        
        return true;
    }
    
    public void tampilActionMenu(Hero player) {
        
    }
    
    public void aturSkillHero(Hero player, Enemy musuh) {
        if (!player.isSkillReady()) {
            System.out.println("Skill belum ready, akan diganti dengan serangan biasa");
            player.serang(musuh);
        } else {
            player.useSkill(musuh);
        }
    }
    
    public boolean aturPotionHero(Hero player, Enemy musuh) {
        
        List<HealthPotion> ramuan = new ArrayList<>();
        for (Item i : player.getPenyimpanan().getItems()) {
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
    
    public boolean giliranMusuh(Hero player, Enemy musuh) {
        return false;
    }
    
    public void saatHeroMenang(Hero player, Enemy musuh) {
        
    }
    
    public void saatMusuhMenang(Hero player) {
        
    }
    
    public void tampilIntroBattle(Hero player, Enemy musuh) {
        
    } 
    
    public Item bentukDropItem() {
        return null;
    }
    
    public int countPotions() {
        return 0;
    }
    
    public int getPlayerChoise(int min, int max) {
        return 0;
    }
}
