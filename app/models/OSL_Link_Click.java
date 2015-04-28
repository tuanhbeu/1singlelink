package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by tuanh_000 on 4/28/2015.
 */

@Entity
public class OSL_Link_Click extends Model {
    public String referrer;
    public String os;
    public String device;
    public String browser;

    @ManyToOne
    public OSL_Link oslLink;
    @ManyToOne
    public OSL_Link_Mirror oslLinkMirror;
}
