/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.User;
import attendanceautomation.dal.UserDAOMock;

/**
 *
 * @author domin
 */
public class BllManager implements BllFacade{
    UserDAOMock user = new UserDAOMock();


    @Override
    public User authenticate(String name, String hashedPass) {
        return user.authenticate(name, hashedPass);
    }
    
}
