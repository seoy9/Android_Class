package ddwucom.mobile.myapplication;

import java.io.Serializable;

public class Book implements Serializable {
    long _id;
    String title;
    String author;
    String publisher;
    String synopsis;

    public Book(String food, String author, String publisher, String synopsis) {
        this.title = food;
        this.author = author;
        this.publisher = publisher;
        this.synopsis = synopsis;
    }

    public Book(long _id, String food, String author, String publisher, String synopsis) {
        this._id = _id;
        this.title = food;
        this.author = author;
        this.publisher = publisher;
        this.synopsis = synopsis;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(_id);
        sb.append(".\t\t");
        sb.append(title);
        sb.append("\t\t\t");
        sb.append(author);
        sb.append("\t\t\t");
        sb.append(publisher);
        sb.append("\t\t\t");
        sb.append(synopsis);
        return sb.toString();
    }

}
