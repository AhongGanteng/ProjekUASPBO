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
    
    @Override
    public void enter(Hero player){
        
    }
    @Override
    public String getDeskripsi() {
        return null;
    }
}
