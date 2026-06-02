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
        System.out.println("--  Memasuki Boss Room  --");
        System.out.println("Musuh   : " + boss.getNama());
        System.out.println("HP musuh: " + boss.getHp() + " / " + boss.getMaxHp());
        System.out.println("==========================");
    }
    @Override
    public String getDeskripsi() {
        return "Boss Room - Musuh: " + boss.getNama() + " (HP " + boss.getHp() + ")";
    }
}
