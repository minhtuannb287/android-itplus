package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import vn.edu.itplus_academy.myapplication.adapters.RVCustomAdapter;

public class RxJavaDemoActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;
    @BindView(R.id.myRecycleView)
    RecyclerView myRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo);

        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        rvCustomAdapter = new RVCustomAdapter();

        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(rvCustomAdapter);

        Observable.just("Minh", "Hiếu", "Báo", "Thi").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                rvCustomAdapter.addStringToList(s);
            }
        });

        Observable.just("How are you?").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                txtHi.setText(s);
            }
        });
    }
}
