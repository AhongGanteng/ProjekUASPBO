/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MakhlukHidup;
import Interface.*;
import System.*;
/**
 * salah satu anak dari class hero, 
 * senjatanya sword, 
 * punya pasif jika darah dibawah 50% maka ketahanan damagenya meningkat +5, 
 * dan punya skill yaitu damage +50% + heal 10 darah dengan cooldown 3 turn
 */
public class Warrior extends Hero{
    private boolean darahTersisaSetengah; //cek darahnya
    /**
     * nama player
     * darah warrior = 150
     * damage serangan = 18
     * ketahanan = 12
     * jeda penggunaan skill = 3
     * @param nama 
     */
    public Warrior(String nama) {
        super(nama, 150, 18, 12, "Warrior", 3);
        this.darahTersisaSetengah = false;
    }
    /**
     * damage serangan yang diberikan oleh player
     * @param target, targetnya adalah obyek Enemy
     */
    @Override
    public void serang (Attackable target) {
        
    }
    /**
     * Skill yang dimiliki oleh class Warrior
     * peningkatan damage +50% dan heal 10% darah player
     * @param target, target serangan
     */
    @Override
    public void useSkill(Attackable target) {
        
    }
    /**
     * Nama skill untuk class Warrior
     * @return nama skill nya
     */
    @Override 
    public String getNamaSkill() {
        return null;
    }
    /**
     * hal yang bisa mengaktifkan skill pasif class Warrior
     */
    @Override
    public void triggerPasif(){
        
    }
    /**
     * nama pasifnya
     */
    @Override 
    public void getNamaPasif() {
        
    }
}
