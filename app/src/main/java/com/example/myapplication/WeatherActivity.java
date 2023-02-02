package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    private static final String API_KEY = "your_api_key";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=your_city&appid=" + API_KEY;

    private TextView locationTextView;
    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        locationTextView = findViewById(R.id.location_text_view);
        weatherTextView = findViewById(R.id.weather_text_view);

        getWeather();
    }

    private void getWeather() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String city = response.getString("name");
                            JSONObject main = response.getJSONObject("main");
                            String temperature = main.getString("temp");
                            String weather = response.getJSONArray("weather").getJSONObject(0).getString("main");

                            locationTextView.setText(city);
                            weatherTextView.setText(temperature + "°F, " + weather);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(jsonObjectRequest);
    }
}