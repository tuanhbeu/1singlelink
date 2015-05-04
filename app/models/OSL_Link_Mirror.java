package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuanh_000 on 4/28/2015.
 */

@Entity
public class OSL_Link_Mirror extends Model {

    public String os;
    public String device;
    public String mirrorLink;

    @ManyToOne
    public OSL_Link oslLink;

    @OneToMany (mappedBy = "oslLinkMirror")
    public List<OSL_Link_Click> linkClickList = new ArrayList<OSL_Link_Click>();

}
