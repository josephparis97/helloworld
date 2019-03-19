package com.example.helloworld;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class AccesDistant implements AsyncResponse {

    private static final String SERVERADDR="https://wad97.000webhostapp.com/cv/servercoach.php";
    private Controle controle;
    public AccesDistant(){

       controle=Controle.getInstance(null);
    }

    //retour du serveur distant
    @Override
    public void processFinish(String output) {
        Log.d("serveur","7**************"+output);
        //decoupage du message reçu
        String[] message=output.split("%");
        //dans message[0] il y aura soit enreg soit dernier soit erreur
        //dans message[1] reste du message

        if (message.length>1)
        {
            if (message[0].equals("enreg"))
            {
                Log.d("enreg","5**************"+message[1]);


            }else{
                if (message[0].equals("dernier"))
                {
                    Log.d("dernier","6**************"+message[1]);
                    try {
                        JSONObject info=new JSONObject(message[1]);
                        String login=info.getString("login");
                        String mdp=info.getString("mdp");
                        String datemesure=info.getString("datemesure");
                        Profil profil=new Profil(new Date(),login,mdp);
                        controle.setProfil(profil);
                    } catch (JSONException e) {
                        Log.d("erreur"," conversion json impossible**************"+e.toString());
                    }


                }else
                if (message[0].equals("erreur")){
                    Log.d("erreur","4**************"+message[1]);

                }
            }
        }
    }

    public void envoi(String operation, JSONArray lesDonneesJSON){
        AccesHTTP accesDonnees=new AccesHTTP();

        accesDonnees.delegate=this;
        //ajout de parametre
        accesDonnees.addParam("operation",operation);
        accesDonnees.addParam("lesdonnees",lesDonneesJSON.toString());

        accesDonnees.execute(SERVERADDR);
    }
}
