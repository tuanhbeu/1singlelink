package util;

import models.OSL_Link;
import models.OSL_Link_Mirror;
import models.OSL_User;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by tuanh_000 on 4/28/2015.
 */
public class LinkUtil {
    public static boolean createOslLink (String userID, String title) {
        try {
            OSL_Link oslLink = new OSL_Link();
            OSL_User user = OSL_User.findById(Long.valueOf(userID));
            oslLink.oslLinkCode = RandomStringUtils.randomAlphanumeric(6);
            oslLink.createdBy = user;
            oslLink.title = title;
            oslLink.save();
            user.linkList.add(oslLink);
            user.save();
            return true;
        } catch (Exception e) {
            play.Logger.error(e, "Loi roi");
            return false;
        }
    }

    public static boolean updateMirrorLink (String mirrorLink, String os, String device, String oslLinkID, boolean delete) {
        try {
            OSL_Link_Mirror oslLinkMirror = OSL_Link_Mirror.find("mirrorLink = ?", mirrorLink).first();
            OSL_Link oslLink = OSL_Link.findById(Long.valueOf(oslLinkID));
            if (delete) {
                oslLinkMirror.delete();
            }
            boolean mirrorLinkExist = true;
            if (oslLinkMirror == null) {
                oslLinkMirror = new OSL_Link_Mirror();
                oslLinkMirror.oslLink = oslLink;
                mirrorLinkExist = false;
            }
            oslLinkMirror.os = os;
            oslLinkMirror.device = device;
            oslLinkMirror.mirrorLink = mirrorLink;
            oslLinkMirror.save();

            if (mirrorLinkExist) {
                oslLink.linkMirrorList.add(oslLinkMirror);
                oslLink.save();
            }

            return true;
        } catch (Exception e) {
            play.Logger.error(e, "Loi roi");
            return false;
        }
    }

    public static String getMirrorLink (String os, String device, String oslLinkCode) {
        OSL_Link oslLink = OSL_Link.find("oslLinkCode = ?",oslLinkCode).first();
        OSL_Link_Mirror mirrorLink = OSL_Link_Mirror.find("oslLink_id = ? and os = ? and device = ?", oslLink.id, os, device).first();
        return mirrorLink.mirrorLink;
    }
}
