package models;


import models.builder.JsonTokenBuilder;

public class JsonTokenModel {
    /*String username;
    String password;

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JsonTokenModel(JsonTokenBuilder jsontokenBuilder) {
        this.username = jsontokenBuilder.getUserName();
        this.password = jsontokenBuilder.getPassword();

    }*/
    private String username;
    private String password;

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JsonTokenModel(JsonTokenBuilder jsontokenBuilder) {
        this.username = jsontokenBuilder.getUserName();
        this.password = jsontokenBuilder.getPassword();
    }


}
