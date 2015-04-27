package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tuanh_000 on 4/28/2015.
 */

@Entity
public class OSL_Link extends Model {
    public String title;
    public String oslLinkCode;
    public Date dateCreated;

    @ManyToOne
    public OSL_User createdBy;

    @OneToMany
    public List<OSL_Link_Mirror> linkMirrorList = new ArrayList<OSL_Link_Mirror>();
}
