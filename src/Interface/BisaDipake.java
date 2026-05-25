package Interface;

import MakhlukHidup.Hero;

/**
 * Diimplementasikan ke obyek item yang bisa digunakan
 */
public interface BisaDipake {

    /**
     * menggunakan item untuk obyek hero
     *
     * @param target, hero yang menggunakannya
     */
    public void pake(Hero target);

    /**
     * @return tipe item ("WEAPON", "ARMOR", "POTION")
     */
    public String getItemType();
}
