package com.lucosa.crowdnotes;

public class BookGetter {

    String Title;
    String Author;
    String Description;
    int Thumbnail;

    public BookGetter(String Title, String Author, String Description, int Thumbnail) {
        this.Title = Title;
        this.Author = Author;
        this.Description = Description;
        this.Thumbnail = Thumbnail;
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
}
