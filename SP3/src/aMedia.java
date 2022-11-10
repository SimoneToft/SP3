public abstract class aMedia implements Media{
    protected String mediaTitle;
    protected  String[] mediaCategory;
    protected String mediaRating;
    protected  String mediaReleaseYear;

    public aMedia (String mediaTitle, String mediaReleaseYear, String[] mediaCategory, String mediaRating){
        this.mediaTitle = mediaTitle;
        this.mediaReleaseYear = mediaReleaseYear;
        this.mediaCategory = mediaCategory;
        this.mediaRating = mediaRating;

    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public String[] getMediaCategory() {
        return mediaCategory;
    }

    public String getMediaRating() {
        return mediaRating;
    }

    public String getMediaReleaseYear() {
        return mediaReleaseYear;
    }
}
