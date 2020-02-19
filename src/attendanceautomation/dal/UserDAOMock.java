/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domin
 */
public class UserDAOMock {

    List<DB> users = new ArrayList();

    public int authenticate(String name, String hashedPass) {
        for (DB user : users) {
            if (user.getLogin().equals(name) && user.getPass().equals(hashedPass)) {
                return user.getId();
            }
        }
        return -1;
    }

    public UserDAOMock() {
        DB p = new DB();
        p.setId(1);
        p.setLogin("login");
        p.setPass("d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1");
        users.add(p);
    }
}

class DB {

    int id;
    String login;
    String pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
