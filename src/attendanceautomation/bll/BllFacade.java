/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.User;

/**
 *
 * @author domin
 */
public interface BllFacade {
    public User authenticate(String name, String hashedPass);
}
