package models;

import models.builder.AuthBuilder;

public class AuthModel {

    String username;
    String paswword;

    public AuthModel(AuthBuilder authBuilder){
        this.username = authBuilder.getUsername();
        this.paswword = authBuilder.getPaswword();
    }


}
