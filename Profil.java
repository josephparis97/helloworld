package com.example.helloworld;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profil {
    private Date dateMesure;
    private String login;
    private String mdp;

    public Profil(Date dateMesure,String login,String mdp){
        this.dateMesure=dateMesure;
        this.login=login;
        this.mdp=mdp;
    }

    //conversion du profil au format jsonarray
    public JSONArray convertToJSONArray(){
        List laList= new ArrayList();
        laList.add(dateMesure);
        laList.add(login);
        laList.add(mdp);
        return new JSONArray(laList);
    }

    public Date getDateMesure() {
        return dateMesure;
    }

    public void setDateMesure(Date dateMesure) {
        this.dateMesure = dateMesure;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
