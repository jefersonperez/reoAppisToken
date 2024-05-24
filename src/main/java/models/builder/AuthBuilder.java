package models.builder;

import models.AuthModel;

public class AuthBuilder {

    private String username;
    private String paswword;

    public AuthBuilder withUserName(String userName){
        this.username = userName;
        return this;
    }
    public AuthBuilder withPassword(String paswword){
        this.username = paswword;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }
    public AuthModel build(){
        return  new AuthModel(this);
    }
}
