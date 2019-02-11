package com.czy.op.model;

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private int userClass;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String userName, String userPassword) {
        super();
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, int userClass) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userClass = userClass;
    }

    public User(int userId, String userName, String userPassword) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
         return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserClass() { return userClass; }

    public void setUserClass(int userClass) { this.userClass = userClass; }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userClass=" + userClass +
                '}';
    }
}
