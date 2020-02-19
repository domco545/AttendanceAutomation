/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import java.util.Date;

/**
 *
 * @author domin
 */
public class DataDAOMock {

    public Date getDate() {
        java.sql.Date date = java.sql.Date.valueOf("2020-02-14");
        Date d = new Date(date.getTime());
        return d;
    }
    
}
