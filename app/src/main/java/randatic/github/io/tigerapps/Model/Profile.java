package randatic.github.io.tigerapps.Model;

import java.sql.Date;

/**
 * Created by Randy Bruner on 1/19/2017.
 */

public class Profile {

    private String name;
    private Date birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
