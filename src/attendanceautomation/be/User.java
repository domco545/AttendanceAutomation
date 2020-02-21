/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author domin
 */
public class User {

    private List<Class> todayClasses = new ArrayList<>();
    private final StringProperty fName = new SimpleStringProperty();
    private final StringProperty lName = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty permissionGroup = new SimpleIntegerProperty();

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public StringProperty emailProperty() {
        return email;
    }
    
    
    public int getPermissionGroup() {
        return permissionGroup.get();
    }

    public void setPermissionGroup(int value) {
        permissionGroup.set(value);
    }

    public IntegerProperty permissionGroupProperty() {
        return permissionGroup;
    }

    public String getlName() {
        return lName.get();
    }

    public void setlName(String value) {
        lName.set(value);
    }

    public StringProperty lNameProperty() {
        return lName;
    }

    public String getfName() {
        return fName.get();
    }

    public void setfName(String value) {
        fName.set(value);
    }

    public StringProperty fNameProperty() {
        return fName;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public List<Class> getTodayClasses() {
        return todayClasses;
    }

    public void setTodayClasses(List<Class> todayClasses) {
        this.todayClasses = todayClasses;
    }
    
    public String getFullName(){
        return fName.get() + " " + lName.get();
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", permissionGroup=" + permissionGroup + "name=" + fName +'}';
    }
}
