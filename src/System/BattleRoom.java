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
    public boolean run(Hero player, BattleSystem sistemBattle){
        return sistemBattle.mulaiBattle(player, enemy);
    }
    
    @Override
    public void enter(Hero player){
        
    }
    @Override
    public String getDeskripsi() {
        return "Ruangan battle melawan monster";
    }
}
