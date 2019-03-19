package com.example.helloworld;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AccesHTTP extends AsyncTask<String,Integer,Long> {

    private ArrayList<NameValuePair> parametres;
    private String ret=null;
    public AsyncResponse delegate=null;
    /**
     * Contructeur
     */
    public AccesHTTP(){
        parametres=new ArrayList<NameValuePair>();
    }
    /*
    Ajout d'un parametre Post
     */
    public void addParam(String nom,String valeur){
        parametres.add(new BasicNameValuePair(nom,valeur));
    }
    /**
     *
     * connection en tache de fond
     * @return
     */

    @Override
    protected Long doInBackground(String... strings) {
        HttpClient cnxHttp=new DefaultHttpClient();
        HttpPost paramCnx=new HttpPost(strings[0]);
        try {
            /*
            encodage des parametres
             */
            paramCnx.setEntity(new UrlEncodedFormEntity(parametres));

            //connexion et envoie des parametres
            HttpResponse reponse=cnxHttp.execute(paramCnx);

            //stansformation de la réponse
            ret= EntityUtils.toString(reponse.getEntity());


        } catch (UnsupportedEncodingException e) {
            Log.d("erreur encodage","1************"+e.toString());
        } catch (ClientProtocolException e) {
            Log.d("erreur protocole","2************"+e.toString());
        } catch (IOException e) {
            Log.d("erreur input output","3************"+e.toString());
        }
        return null;
    }
    @Override
    protected void onPostExecute(Long result){
        delegate.processFinish(ret.toString());
    }


}
