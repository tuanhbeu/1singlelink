package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tuanh_000 on 4/28/2015.
 */

@Entity
public class OSL_User extends Model {
    public String username;
    public String password;
    public String email;
    public Date dateCreated;

    @OneToMany
    public List<OSL_Link> linkList = new ArrayList<OSL_Link>();

}
