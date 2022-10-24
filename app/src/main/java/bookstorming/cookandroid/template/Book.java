package bookstorming.cookandroid.template;

public class Book {
    private String title;
    private String description;
    private int pubDate;
    private String profile;//이건 사진일듯??

    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPubDate() {
        return pubDate;
    }

    public void setPubDate(int pubDate) {
        this.pubDate = pubDate;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
