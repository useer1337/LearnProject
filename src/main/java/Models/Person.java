package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Person {

    private int id;
    private StringProperty name = new SimpleStringProperty();

    public Person(){};

    public Person(int id, String name) {
        this.name.set(name);
    }

    @Id
    @GeneratedValue(generator = "sqlite")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    @Transient
    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
