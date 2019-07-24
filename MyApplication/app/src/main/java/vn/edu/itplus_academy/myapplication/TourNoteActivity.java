package vn.edu.itplus_academy.myapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import vn.edu.itplus_academy.myapplication.fragements.DialogEditFragment;
import vn.edu.itplus_academy.myapplication.fragements.Fragment1;

public class TourNoteActivity extends AppCompatActivity {


    private View btnThemMoiGhiChu;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_note);

        setTitle("Quản lý ghi chú");

        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigationdrawer_open, R.string.navigationdrawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        btnThemMoiGhiChu = findViewById(R.id.btnThemGhiChu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_note_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(this, "Bạn vừa click nút tìm kiếm", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Intent intent = new Intent(this, ContactActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ContactActivity.KEY_SHOW_WHAT, ContactActivity.VALUE_SHOW_ABOUT);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            case R.id.help:
                intent = new Intent(this, ContactActivity.class);
                bundle = new Bundle();
                bundle.putString(ContactActivity.KEY_SHOW_WHAT, ContactActivity.VALUE_SHOW_HELP);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;


        }




        return super.onOptionsItemSelected(item);
    }


    private OnClickListener myOnclick = new OnClickListener() {
        @Override
        public void onClick(View view) {

            // Create a new fragment and specify the fragment to show based on nav item clicked
            Fragment fragment = null;
            Class fragmentClass;


            switch (view.getId()){
                case R.id.btnThemGhiChu:
                    fragmentClass = DialogEditFragment.class;
                    setTitle("Thêm mới ghi chú");
                    break;
                default:
                    fragmentClass = DialogEditFragment.class;
            }

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

            // Close the navigation drawer
            drawerLayout.closeDrawers();
        }
    };

}
