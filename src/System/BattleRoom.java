package System;
import MakhlukHidup.*;
/**
 * ini untuk ruangan battle khusus untuk monster biasa aja
 * @author LENOVO
 */
public class BattleRoom extends Room{
    private Enemy enemy;

    public BattleRoom(Enemy enemy) {
        super("BATTLE ROOM");
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }
    
    public boolean run(Hero player, BattleSystem sistemBattle) {
        return sistemBattle.mulaiBattle(player, enemy);
    }

    @Override
    public void enter(Hero player){
        System.out.println("-- Memasuki Battle Room --");
        System.out.println("Musuh   : " + enemy.getNama());
        System.out.println("HP musuh: " + enemy.getHp() + " / " + enemy.getMaxHp());
        System.out.println("==========================");
    }
    
    @Override
    public String getDeskripsi() {
        return "Battle Room - Musuh: " + enemy.getNama() + " (HP " + enemy.getHp() + ")";
    }
}
