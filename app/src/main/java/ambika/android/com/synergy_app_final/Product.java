package ambika.android.com.synergy_app_final;

public class Product {
    private int id;
    private String title;
    private String shortdesc;

    //private int image;

    public Product(int id, String title, String shortdesc) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }
}
