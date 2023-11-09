package entity;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    private String alias;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private boolean workStatus;
    @Getter
    @Setter
    private String id;

    public User(){

    }
    public User(String alias, String userName, int age, boolean workStatus, String id) {
        this.alias = alias;
        this.userName = userName;
        this.age = age;
        this.workStatus = workStatus;
        this.id = id;
    }
}
