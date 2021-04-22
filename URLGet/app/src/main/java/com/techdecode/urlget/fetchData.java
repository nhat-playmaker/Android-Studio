package com.techdecode.urlget;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParse = "", singleParse = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://aqitrackerabc.000webhostapp.com/json.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
//            for (int i = 0; i<JA.length(); i++) {
//                JSONObject JO = (JSONObject) JA.get(i);
//                singleParse = "STT:" + JO.get("stt") + "\n" +
//                        "ID:" + JO.get("id") + "\n" +
//                        "CO2:" + JO.get("co2") + "\n" +
//                        "HCHO:" + JO.get("hcho") + "\n";
//
//                dataParse = dataParse + singleParse;
//            }
            JSONObject JO = (JSONObject) JA.get(JA.length()-1);
            singleParse = "STT:" + JO.get("stt") + "\n" +
                        "ID:" + JO.get("id") + "\n" +
                        "CO2:" + JO.get("co2") + "\n" +
                        "HCHO:" + JO.get("hcho") + "\n";

            dataParse = dataParse + singleParse;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.txtOut.setText(this.dataParse);
    }
}
