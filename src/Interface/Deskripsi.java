package Interface;

/**
 * Diimplementasikan kesemua obyek yang bisa menampilkan status/deskripsi
 * dirinya
 */
public interface Deskripsi {

    /**
     * Menampilkan status entitas
     */
    public void showStatus();

    /**
     * @return deskripsi singkat obyek
     */
    public String getDeskripsi();
}
