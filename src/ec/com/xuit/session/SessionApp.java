/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.xuit.session;

/**
 *
 * @author user
 */
public class SessionApp {
    private static boolean estaImprimiendo;
    private static String accesToken;
    private static String tokenType;
    private static String authorization;
    
    public SessionApp() {
    }
    
    public static boolean isEstaImprimiendo() {
        return estaImprimiendo;
    }

    public static void setEstaImprimiendo(boolean estaImprimiendo) {
        SessionApp.estaImprimiendo = estaImprimiendo;
    }

    public static String getToken() {
        return accesToken;
    }

    public static void setToken(String token) {
        SessionApp.accesToken = token;
    }

    public static String getAccesToken() {
        return accesToken;
    }

    public static void setAccesToken(String accesToken) {
        SessionApp.accesToken = accesToken;
    }

    public static String getTokenType() {
        return tokenType;
    }

    public static void setTokenType(String tokenType) {
        SessionApp.tokenType = tokenType;
    }

    public static String getAuthorization() {
        return authorization;
    }

    public static void setAuthorization(String authorization) {
        SessionApp.authorization = authorization;
    }
    
    
     
}
