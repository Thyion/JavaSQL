package pl.krzychu;

public class Ksiazka {
    private String title;
    private String author;
    private int anno;

    public Ksiazka() {
    }

    public Ksiazka(String title, String author, int anno) {
        this.title = title;
        this.author = author;
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Ksiazka:\n\tTytuł:"+title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
