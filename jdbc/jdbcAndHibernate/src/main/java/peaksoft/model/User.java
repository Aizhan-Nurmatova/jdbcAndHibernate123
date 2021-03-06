package peaksoft.model;

import javax.persistence.*;
@Entity(name = "users")
@Table
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private byte age;

    public User() {
    }

    public User(long id,String name, String lastName, Byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String name, String lastName, byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return id+" "+ name +" "+ lastName +" "+age ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

}