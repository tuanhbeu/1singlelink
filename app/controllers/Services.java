package controllers;

import models.OSL_Link;
import models.OSL_Link_Click;
import models.OSL_Link_Mirror;
import models.OSL_User;
import org.apache.commons.lang.RandomStringUtils;
import play.mvc.Controller;
import util.LinkUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * Created by tuanh_000 on 4/28/2015.
 */
public class Services extends Controller {
    public static void createOslLink (String userID, String title) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        try {
            LinkUtil.createOslLink(userID, title);
        } catch (Exception e) {
            play.Logger.error(e, "Loi roi");
        } finally {
            Application.index("");

        }
    }

    public static void updateMirrorLink (String mirrorLink, String os, String device, String oslLinkID, boolean delete) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        try {
            LinkUtil.updateMirrorLink(mirrorLink, os, device, oslLinkID, delete);
        } catch (Exception e) {
            play.Logger.error(e, "Loi roi");
        } finally {
            Application.index("");
        }
    }


    public static void getMirrorLink (String os, String device, String oslLinkCode, String referrer, String browser) {
        OSL_Link oslLink = OSL_Link.find("oslLinkCode = ?",oslLinkCode).first();
        oslLink.clickCount++;
        OSL_Link_Mirror mirrorLink = OSL_Link_Mirror.find("oslLink_id = ? and (os = ? and device = ?)", oslLink.id, os, device).first();

        // tao click moi
        OSL_Link_Click newClick = new OSL_Link_Click();
        newClick.os = os;
        newClick.device = device;
        newClick.browser = browser;
        newClick.referrer = referrer;
        newClick.oslLink = oslLink;
        newClick.oslLinkMirror = mirrorLink;
        newClick.save();

        oslLink.linkClickList.add(newClick);
        mirrorLink.linkClickList.add(newClick);

        oslLink.save();
        mirrorLink.save();
        play.Logger.info("%s", mirrorLink.mirrorLink);
        redirect(mirrorLink.mirrorLink);
    }

}
