package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class StudentManagerActivity extends AppCompatActivity {

    private static final String URL_APP  = "http://4fanclub.vn/demoapi/";

    TextView content;
    EditText fname, email, login, pass;
    String Name, Email, User, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_manager);

        content = (TextView) findViewById(R.id.content);
        fname = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        login = (EditText) findViewById(R.id.loginname);
        pass = (EditText) findViewById(R.id.password);

        Button register = (Button) findViewById(R.id.btnRegister);

        register.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Thread thr = new Thread(connect);
                thr.start();
            }
        });

        Thread load = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    loadStudent();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } // Tải danh sách sinh viên
            }
        });
        load.start();
    }


    Runnable connect = new Runnable() {

        @Override
        public void run() {
            try {
                addStudentByPost(); // Gọi tới API thêm sinh viên
            } catch (IOException e) {
                content.setText(" url exeption! " + e.toString());
                e.printStackTrace();
            }
        }
    };

    // Hàm thêm sinh viên
    private void addStudentByPost() throws IOException {
        URL url = new URL(URL_APP+"/add_student");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        Name = fname.getText().toString();
        Email = email.getText().toString();
        User = login.getText().toString();
        Pass = pass.getText().toString();

        HashMap<String, String> postDataParams = new HashMap<>();
        postDataParams.put("name", Name);
        postDataParams.put("email", Email);
        postDataParams.put("user", User);
        postDataParams.put("Pass", Pass);

        // Gửi dữ liệu POST
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,
                "UTF-8"));
        writer.write(getPostDataString(postDataParams));
        writer.flush();
        writer.close();
        os.close();

        conn.connect();

        getRespose(conn);
    }

    // Đẩy dữ liệu lên server dạng POST
    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    String text = "";

    private void getRespose(HttpURLConnection conn) throws IOException {
        BufferedReader reader = null;
        // Get the server response
        reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        // Read Server Response
        while ((line = reader.readLine()) != null) {
            // Append server response in string
            sb.append(line + "\n");
        }
        text = sb.toString();

        // Show response on activity
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                content.setText(text);
            }
        });
    }

    // Tải dữ liệu sinh viên từ service
    public void loadStudent() throws IOException {

        URL obj = new URL(URL_APP+"/get_all");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + URL_APP);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        final String text = response.toString();

        // Show response on activity
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                content.setText(pairData(text));
            }
        });
    }

    // Phân tích dữ liệu JSON trả về từ API
    private String pairData(String data) {
        StringBuilder lstData = new StringBuilder();
        try {
            JSONArray rootJSON = new JSONArray(data);
            for (int i = 0; i < rootJSON.length(); i++) {
                JSONObject sinhVien = rootJSON.getJSONObject(i);
                lstData.append(sinhVien.getString("name") + "\n");
                lstData.append(sinhVien.getString("email") + "\n");
                lstData.append("----------------------------------\n");
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return lstData.toString();
        }
    }
}
