package vn.itplus.thoitiet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "APPID=a5d21dd60c98dc641e70ee899ff93023";
    private final String REST_API = "http://api.openweathermap.org/data/2.5/weather?q=Hanoi,vn&units=metric&" + API_KEY;

    TextView mlblCountry;
    TextView mlblNhietDo;
    TextView mlblNhietDoCaoThap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlblCountry = (TextView) findViewById(R.id.lblCountry);
        mlblNhietDo = (TextView) findViewById(R.id.lblNhietDo);
        mlblNhietDoCaoThap = (TextView) findViewById(R.id.lblNhietDoCaoThap);

        CallAPI api = new CallAPI();
        api.execute(REST_API);
    }


    // Luồng gửi, nhận dữ liệu tới web service
    private class CallAPI extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            String urlString = params[0]; // URL to call
            String resultToDisplay = "";
            InputStream in = null;

            // HTTP Get
            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url
                        .openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream());

                resultToDisplay = readStream(in);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }

            return resultToDisplay;

        }

        protected void onPostExecute(String result) {
            phanTichDuLieu(result);
        }

    }

    // Đọc luồng dữ liệu respone trả về từ server
    private String readStream(InputStream in) {
        StringBuilder data = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return data.toString();
        }
    }

    // Phân tích dữ liệu JSON trả về từ API
    private void phanTichDuLieu(String data) {
        try {
            JSONObject parentJSON = new JSONObject(data);
            // Quốc gia
            JSONObject sys = parentJSON.getJSONObject("sys");
            mlblCountry.setText(sys.getString("country"));

            // Nhiệt độ hiện tại
            JSONObject main = parentJSON.getJSONObject("main");
            mlblNhietDo.setText(main.getInt("temp") + "\u2103");
            mlblNhietDoCaoThap.setText("C: " + main.getInt("temp_max")
                    + "\u2103" + " / T:" + main.getInt("temp_min") + "\u2103");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
