package controllers;

import play.*;
import play.mvc.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index(String userLinkID) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        OSL_User user = new OSL_User();
//        user.username = "tuanh";
//        user.password = MessageDigest.getInstance("MD5").digest("Tuanh1558".getBytes("UTF-8")).toString();
//        user.email = "tuanh@higgsvalley.com";
//        user.dateCreated = new Date();
//        user.save();

        OSL_User tuanh = OSL_User.find("username = ?", "tuanh").first();
        OSL_Link thisOslLink;
        if (userLinkID == null || userLinkID.equalsIgnoreCase("")) {
            thisOslLink = tuanh.linkList.size() > 0 ? tuanh.linkList.get(0) : null;
        } else {
            thisOslLink = OSL_Link.findById(Long.valueOf(userLinkID));

        }

        render(tuanh, thisOslLink);
    }

    public static void linkPage(String oslLinkCode) {
//        OSL_Link oslLink = OSL_Link.find("oslLinkCode = ?", oslLinkCode).first();
//        String link = Services.getMirrorLink("iOS", "", oslLinkCode);
        render(oslLinkCode);
    }

}