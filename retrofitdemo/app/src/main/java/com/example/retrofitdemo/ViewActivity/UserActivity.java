package com.example.retrofitdemo.ViewActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.retrofitdemo.Model.UserModel;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.Service.RetrofitClient;
import com.example.retrofitdemo.Service.ApplicationService;
import com.example.retrofitdemo.ViewModel.UserListViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {


    private UserListViewModel userListViewModel;
    ArrayAdapter<UserModel> mAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        listView =findViewById(R.id.listView);

        userListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);

        ApplicationService service = RetrofitClient.getRetrofit().create(ApplicationService.class);
        Call<List<UserModel>> call = service.listUser();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if(response.isSuccessful()){
                    List<UserModel> userModels = response.body();
                    mAdapter = new ArrayAdapter<>(UserActivity.this, android.R.layout.simple_list_item_1, userModels);
                    listView.setAdapter(mAdapter);

//                    for (UserModel userModel : userModels){
//                        Log.e("PostAc", userModel.getName());
//                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.e("USER", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnThem:
                Intent intent = new Intent(this, UserFormActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
