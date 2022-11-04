import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
    private String mediaTitle;
    private String[] mediaCategory;
    private String mediaRating;
    private String mediaReleaseYear;

    public Movie(String mediaTitle, String mediaReleaseYear, String[] mediaCategory, String mediaRating) {
        this.mediaCategory = mediaCategory;
        this.mediaTitle = mediaTitle;
        this.mediaRating = mediaRating;
        this.mediaReleaseYear = mediaReleaseYear;
    }

    public String titleSearch(ArrayList<String> data, String search) {
        String name = null;
        for (String s : data) {

        }
        return name;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    @Override
    public String toString() {
        return "|MOVIE| " + mediaTitle +
                " |CATEGORIES| " + Arrays.toString(mediaCategory).replace("[","").replace("]","")+
                " |RATING| " + mediaRating +
                " |YEAR| = " + mediaReleaseYear;
    }


}
