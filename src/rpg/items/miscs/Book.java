package rpg.items.miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

// Clase para objetos de tipo Libro
public class Book extends Item {

    private String author;
    private int pages;

    public Book(String name, String description, int price, String author, int pages, ItemType itemType) {
        super(name, description, price, itemType);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return super.toString() + " - Author: " + author + ", Pages: " + pages;
    }
}
