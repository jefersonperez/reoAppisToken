package models.builder;

import models.AuthModel;
import models.JsonTokenModel;

public class JsonTokenBuilder {
  /*private String password;
  private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public JsonTokenBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public JsonTokenBuilder withUserName(String username) {
        this.username = username;
        return this;
    }

       public JsonTokenModel build(){
        return new JsonTokenModel(this);
    }*/

    private String password;
    private String username;

    public JsonTokenBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public JsonTokenBuilder withUserName(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return username;
    }

    public JsonTokenModel build() {
        return new JsonTokenModel(this);
    }
}
