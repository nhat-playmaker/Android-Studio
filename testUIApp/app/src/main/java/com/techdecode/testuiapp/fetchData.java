package com.techdecode.testuiapp;

import android.os.AsyncTask;

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
    String dataParse = "";
    public String Temperature, Humidity, CO2, HCHO, TVOC, PM25, PM100 = "";

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
            JSONObject JO = (JSONObject) JA.get(JA.length() - 1);
            PM25 = (String) JO.get("pm25");
            PM100 = (String) JO.get("pm100");
            CO2 = (String) JO.get("co2");
            HCHO = (String) JO.get("hcho");
            TVOC = (String) JO.get("tvoc");
            Temperature = (String) JO.get("temperature");
            Humidity = (String) JO.get("humidity");

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

        MainActivity.textViewPM25Value.setText(String.format("%s μg/m^3", PM25));
        MainActivity.textViewPM100Value.setText(String.format("%s μg/m^3", PM100));
        MainActivity.textViewCO2Value.setText(String.format("%s ppm", CO2));
        MainActivity.textViewHCHOValue.setText(String.format("%s μg/m^3", HCHO));
        MainActivity.textViewTVOCValue.setText(String.format("%s μg/m^3", TVOC));
        MainActivity.textViewTemperatureValue.setText(String.format("%s ºC", Temperature));
        MainActivity.textViewHumidityValue.setText(String.format("%s %%", Humidity));
    }
}
