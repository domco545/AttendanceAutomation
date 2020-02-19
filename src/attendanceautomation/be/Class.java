/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author domin
 */
public class Class {

    private final StringProperty name = new SimpleStringProperty();
    private final BooleanProperty Present = new SimpleBooleanProperty();
    private final BooleanProperty canChange = new SimpleBooleanProperty();

    public Class() {
        Present.setValue(Boolean.FALSE);
        canChange.setValue(Boolean.FALSE);
    }

    public boolean isCanChange() {
        return canChange.get();
    }

    public void setCanChange(boolean value) {
        canChange.set(value);
    }

    public BooleanProperty canChangeProperty() {
        return canChange;
    }
    

    public boolean isPresent() {
        return Present.get();
    }

    public void setPresent(boolean value) {
        Present.set(value);
    }

    public BooleanProperty PresentProperty() {
        return Present;
    }
    

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
    
}
