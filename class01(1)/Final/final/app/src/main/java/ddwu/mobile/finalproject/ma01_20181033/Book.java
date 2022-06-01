package ddwu.mobile.finalproject.ma01_20181033;

import java.io.Serializable;

public class Book implements Serializable {
    private long _id;
    private String title;
    private String author;
    private String publisher;
    private String synopsis;
    private int rating;

    public Book(long _id, String title, String author, String publisher, String synopsis, int rating) {
        this._id = _id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.synopsis = synopsis;
        this.rating = rating;
    }

    public Book(String title, String author, String publisher, String synopsis, int rating) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.synopsis = synopsis;
        this.rating = rating;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
