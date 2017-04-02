package net.vibro.app.service;

/**
 * Created by ${Mirek} on 01.04.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void AutoLogin(String username, String password);


}
