package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class Book implements Serializable{
    long _id;
    String title;
    String author;
    String publisher;
    String synopsis;
    int price;

    public Book(String title, String author, String publisher, String synopsis, int price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.synopsis = synopsis;
        this.price = price;
    }

    public Book(long _id, String title, String author, String publisher, String synopsis, int price) {
        this._id = _id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.synopsis = synopsis;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(_id);
        sb.append(".\t\t");
        sb.append(title);
        sb.append("\t\t\t(");
        sb.append(author);
        sb.append(")");
        return sb.toString();
    }
}
