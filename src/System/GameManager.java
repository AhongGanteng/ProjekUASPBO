/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public void showTitle() {
        
    }
    
    public void showGameOver() {
        
    }
    
    public void showGameClear() {
        
    }
    
    public Hero bangunPlayer() {
        return null;
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
        } while (pilihan > max || pilihan < min);
        return pilihan;
    }
    
    public void start() {
        
    }
}
