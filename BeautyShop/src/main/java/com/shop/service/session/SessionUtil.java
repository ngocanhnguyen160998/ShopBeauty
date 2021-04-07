package com.shop.service.session;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static SessionUtil sessionUtil = null;
    public static SessionUtil getInstance(){
        if (sessionUtil == null){
            sessionUtil = new SessionUtil();
        }
        return sessionUtil;
    }
    public static Object getSession(HttpServletRequest request, String key){
        return request.getSession().getAttribute(key);
    }
    public static void setSession(HttpServletRequest request, String key, Object value){
        request.getSession().setAttribute(key,value);
    }
    public static void removeSession(HttpServletRequest request ,String key){
        request.getSession().removeAttribute(key);
    }
}
