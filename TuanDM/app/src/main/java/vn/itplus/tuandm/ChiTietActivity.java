package vn.itplus.tuandm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChiTietActivity extends AppCompatActivity {

    TextView tvNhietDo, tvThanhPho, tvMoTa,tvNhietDoThapNhat, tvNhietDoCaoNhat;
    ImageView imageView;
    ThanhPho thanhPho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);


        thanhPho = (ThanhPho) getIntent().getExtras().getSerializable("thanhPho");


       tvThanhPho = findViewById(R.id.tvThanhPho);
       tvNhietDo = findViewById(R.id.tvNhietDo);
       imageView = findViewById(R.id.imageView);

       new NetworkConnect().execute();

    }

    class NetworkConnect extends AsyncTask<Void, Void, JSONObject> {

        private final String JSON_URL = "https://samples.openweathermap.org/data/2.5/weather?id="+ thanhPho.getId() + "&appid=b6907d289e10d714a6e88b30761fae22";
        String charset = "UTF-8";
        HttpURLConnection conn;
        StringBuilder result;
        URL urlObj;

        @Override
        protected JSONObject doInBackground(Void... args) {

            JSONObject retObj = null;

            try {
                urlObj = new URL(JSON_URL);

                conn = (HttpURLConnection) urlObj.openConnection();
                conn.setDoOutput(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept-Charset", charset);
                conn.setConnectTimeout(15000);
                conn.connect();

                //Receive the response from the server
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                Log.d("NetworkConnect", "result: " + result.toString());

                retObj = new JSONObject(result.toString());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return retObj;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            //Use JSON result to display in TextView
            if (json != null) {
                try {
                    JSONObject main =  json.getJSONObject("main");
                    JSONArray weather =  json.getJSONArray("weather");
                    String nhietDo = main.getString("temp");
                    tvThanhPho.setText(thanhPho.getName() + ", " + thanhPho.getCountry());
                    tvNhietDo.setText(nhietDo);
                    if(weather.getJSONObject(0).getString("main").equals("Clouds")) {
                        imageView.setImageResource(R.drawable.may);
                    }else{
                        imageView.setImageResource(R.drawable.sun);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
