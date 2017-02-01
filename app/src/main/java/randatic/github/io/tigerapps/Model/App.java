package randatic.github.io.tigerapps.Model;

/**
 * Created by Randy Bruner on 1/31/2017.
 */

public class App {

    private String name;
    private String description;
    private int rating;

    public App(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
