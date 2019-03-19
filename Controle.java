package com.example.helloworld;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;

import java.util.Date;

public class Controle {

    private static Controle instance=null;
    private static Profil profil;
    private static String nomFic="saveprofil";
    //private static AccesLocal accesLocal;
    private static AccesDistant accesDistant;
    private static Context contexte;

    private Controle(){super();}

    /**
     * Creation de l'instance
     */
    public static final Controle getInstance(Context contexte){
        if (contexte!=null){
            Controle.contexte=contexte;
        }
        if (Controle.instance==null){
            Controle.instance=new Controle();
            // AccesLocal = new  AccesLocal(contexte);
            accesDistant=new AccesDistant();
            accesDistant.envoi("dernier",new JSONArray());
            //  profil=accesLocal.recupDernier();

        }
        return Controle.instance;
    }

    public void creerProfil(String login,String mdp){
        profil =new Profil(new Date(),login,mdp);
        //accesLocal.ajout(profil);
        accesDistant.envoi("enreg",profil.convertToJSONArray());
    }
    public void setProfil(Profil profil){
        Controle.profil=profil;
        ((MainActivity)contexte).recupProfil();
    }
    public String getLogin()
    {
        return profil.getLogin();
    }
    public String getMdp()
    {
        return profil.getMdp();
    }
}
