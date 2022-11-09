import java.util.ArrayList;
import java.util.Arrays;

public class Series {
    private String mediaTitle;
    private String[] mediaCategory;
    private String mediaRating;
    private String mediaReleaseYear;

    private String[] seriesSeasons;

    public Series(String mediaTitle, String mediaReleaseYear, String[] mediaCategory, String mediaRating, String[] seriesSeasons) {
        this.mediaCategory = mediaCategory;
        this.mediaTitle = mediaTitle;
        this.mediaRating = mediaRating;
        this.mediaReleaseYear = mediaReleaseYear;
        this.seriesSeasons = seriesSeasons;
    }
    public String getMediaTitle() {
        return mediaTitle;
    }

    public String titleSearch(ArrayList<String> data, String search) {
        String name = null;
        for (String s : data) {

        }
        return name;
    }
    @Override
    public String toString() {
        return "|SERIES| " + mediaTitle +
                " |CATEGORIES| " + Arrays.toString(mediaCategory).replace("[","").replace("]","")+
                " |RATING| " + mediaRating +
                " |YEAR| = " + mediaReleaseYear+
                " |SEASONS-EPISODES| "+ Arrays.toString(seriesSeasons).replace("[","").replace("]","");
    }
}
