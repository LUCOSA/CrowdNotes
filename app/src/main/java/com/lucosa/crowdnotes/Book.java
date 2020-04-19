package com.lucosa.crowdnotes;

public class Book {

    private String Title;
    private String Author;
    private String Description;
    private int Thumbnail;

    public Book() {
    }

    public Book(String title, String author, String description, int thumbnail) {
        Title = title;
        Author = author;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
