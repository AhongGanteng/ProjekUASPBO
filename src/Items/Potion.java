package Items;

/**
 * class parent untuk berbagai ramuan (ramuannya 3 aja wkwwkwkwkwwk)
 */
import MakhlukHidup.*;

public abstract class Potion extends Item {

    private int quantity; //jumlah potion

    public Potion(int quantity, String nama, String rarity) {
        super(nama, rarity);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //cek apakah potion tersedia
    public boolean isEmpty() {
        return quantity == 0;
    }

    /**
     * potion dipake oleh target
     *
     * @param target, obyek hero
     */
    @Override
    public void pake(Hero target) {
        if (isEmpty()) {
            System.out.println(getNama() + " sudah habis!");
            return;
        }

        terimaEfek(target);
        quantity--;
        System.out.println(getNama() + " tersisa: " + quantity);
    }

    @Override
    public String getItemType() {
        return "Potion";
    }

    @Override
    public void showStatus() {
        System.out.println("");
    }

    //efek spesifik tiap potion
    public abstract void terimaEfek(Hero target);
}
