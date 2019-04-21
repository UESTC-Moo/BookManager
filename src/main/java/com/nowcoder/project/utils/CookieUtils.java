package com.nowcoder.project.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    private static int COOKIE_AGE = 20;

    public static void writeCookie(String key, String value, HttpServletResponse response){
        Cookie cookie = new Cookie(key,value);
        cookie.setPath("/");
        cookie.setMaxAge(COOKIE_AGE);
        response.addCookie(cookie);
    }

    public static String getCookie(String key,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(key)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void removeCookie(String key,HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equalsIgnoreCase(key)){
                    Cookie cookie1 = new Cookie(key,"");
                    cookie1.setPath("/");
                    cookie1.setMaxAge(0);
                    response.addCookie(cookie1);
                }
            }
        }
    }
}
