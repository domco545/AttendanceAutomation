/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domin
 */
public class UserDAOMock {

    List<DB> users = new ArrayList();

    public User authenticate(String name, String hashedPass) {
        User u = new User();
        u.setId(-1);
        for (DB user : users) {
            if (user.getLogin().equals(name) && user.getPass().equals(hashedPass)) {
                u.setId(user.getId());
                u.setPermissionGroup(user.getPermissionGroup());
                u.setfName(user.getfName());
                u.setlName(user.getlName());
                u.setEmail(user.getEmail());
                return u;
            }
        }
        return u;
    }

    public UserDAOMock() {
        DB p = new DB();
        p.setId(1);
        p.setLogin("login");
        p.setPass("d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1");
        p.setPermissionGroup(1);
        p.setfName("Piotr");
        p.setlName("Stogrovsky");
        p.setEmail("ps@easv.dk");
        users.add(p);
        
        DB p2 = new DB();
        p2.setId(2);
        p2.setLogin("teacher");
        p2.setPass("d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1");
        p2.setPermissionGroup(2);
        p2.setfName("Jappa");
        p2.setlName("Lids");
        p2.setEmail("jl@easv.dk");
        users.add(p2);
    }
}

class DB {

    int id;
    String login;
    String pass;
    int permissionGroup;
    String fName;
    String lName;
    String email;

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

    public int getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(int permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
