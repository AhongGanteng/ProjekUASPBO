package System;

import Interface.*;
import MakhlukHidup.*;

/**
 * ini class abstrak referensi untuk ruangan boss dan battle
 * mengimplementasi interface Deskripsi
 */
public abstract class Room implements Deskripsi {
    //atribut class Room
    private String namaLantai;
    private boolean isClear;
    //constructor berparameter, untuk buat objek room baru
    public Room(String namaLantai) {
        this.namaLantai = namaLantai;
        this.isClear = false;
    }

    public String getNamaLantai() {
        return namaLantai;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setIsClear() {
        this.isClear = true;
    }

    //mirip seperti pintu masuk ke dungeonnya
    public abstract void enter(Hero player);
    //menampilkan status ruangan, cek apa sudah clear
    @Override
    public void showStatus() {
        String status;
        if (isClear()) {
            status = "Clear";
        } else {
            status = "Not clear";
        }
        System.out.println("Status  : " + status);
    }
    //tampilkan deskripsi ruangan & statusnya untuk cek apakah clear
    @Override
    public String getDeskripsi() {
        String status;
        if (isClear()) { //jika ruangan clear
            status = "Clear";
        } else { //jika tidak clear
            status = "Not clear";
        }

        return namaLantai + " - " + status;
    }
}