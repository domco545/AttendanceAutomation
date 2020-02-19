/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.User;
import attendanceautomation.dal.DataDAOMock;
import attendanceautomation.dal.UserDAOMock;
import java.util.Date;

/**
 *
 * @author domin
 */
public class BllManager implements BllFacade{
    UserDAOMock user = new UserDAOMock();
    DataDAOMock data = new DataDAOMock();


    @Override
    public User authenticate(String name, String hashedPass) {
        return user.authenticate(name, hashedPass);
    }

    @Override
    public Date getDate() {
        return data.getDate();
    }
    
}
