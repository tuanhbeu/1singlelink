package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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

}
