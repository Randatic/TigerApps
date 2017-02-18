package randatic.github.io.tigerapps.Model;


import com.backendless.BackendlessUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Randy Bruner on 1/31/2017.
 */

public class App {

    public String objectId;

    private String name;
    private String briefDescription;
    private String description;
    private int rating;
    private List<String> developers;

    public App(){
        name = "Example App";
        briefDescription = "An example app.";
        description = "An example app.";
        rating = 4;
        developers = new ArrayList<String>();
    }

    public App(String name, String briefDescription, int rating) {
        this.name = name;
        this.briefDescription = briefDescription;
        this.rating = rating;
        description ="";
        developers = new ArrayList<String>();
    }

    public App(String name, String briefDescription, int rating, String description, List<String> developers) {
        this.name = name;
        this.briefDescription = briefDescription;
        this.rating = rating;
        this.description = description;
        this.developers = (ArrayList<String>) developers;
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
    public String getObjectId() {
        return objectId;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = (ArrayList<String>) developers;
    }
    public void addDeveloper(BackendlessUser developer) {
        developers.add(developer.getObjectId());
    }
    public void removeDeveloper(BackendlessUser developer) {
        developers.remove(developer.getObjectId());
    }
    public void removeAllDevelopers() {
        developers.removeAll(developers);
    }

}
