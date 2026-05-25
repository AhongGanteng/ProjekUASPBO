package System;
import MakhlukHidup.*;
/**
 *ini untuk class ruangan boss yang isinya boss dungeon
 * @author LENOVO
 */
public class BossRoom extends Room{
    private Enemy boss;

    public BossRoom(Enemy boss) {
        super("BOSS ROOM");
        this.boss = boss;
    }

    public Enemy getBoss() {
        return boss;
    }
    
    @Override
    public void enter(Hero player){
        
    }
    @Override
    public String getDeskripsi() {
        return null;
    }
}
