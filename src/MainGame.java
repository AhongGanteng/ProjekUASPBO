
import System.*;
/**
 * class utama untuk menjalankan program permainan
 * @author LENOVO
 */
public class MainGame {

    public static void main(String[] args) {
        GameManager game = new GameManager(); //membuat objek game pada class GameManager 
        game.start(); //mulai permainan dgn panggil method start() di GameManager
    }
}
