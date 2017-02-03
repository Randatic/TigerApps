package randatic.github.io.tigerapps.Model;

/**
 * Created by Randy Bruner on 1/31/2017.
 */

public class App {

    private String name;
    private String briefDescription;
    private String description;
    private int rating;

    public App(String name, String briefDescription, int rating) {
        this.name = name;
        this.briefDescription = briefDescription;
        this.rating = rating;
        description ="";
    }

    //Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBriefDescription() {
        return briefDescription;
    }
    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
