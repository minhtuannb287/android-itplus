package vn.edu.itplus_academy.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import vn.edu.itplus_academy.myapplication.games.TicTacToeActivity;

public class NavigationDrawActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_draw);

        // Hien thi nut back
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigationdrawer_open, R.string.navigationdrawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_viewcontrols) {
            Intent intent = new Intent(this, ViewControlDemoActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_viewcontrols2) {
            Intent intent = new Intent(this, ViewControlDemo2Activity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_webview) {
            Intent intent = new Intent(this, WebViewActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_videoview) {
            Intent intent = new Intent(this, VideoViewActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_viewcontrols3) {
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
            return true;
        }  else if (id == R.id.nav_contrainlayout) {
            Intent intent = new Intent(this, ContrainLayoutLoginActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_coordinatorlayout) {
            Intent intent = new Intent(this, CoordinatorLayoutActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_coordinatorlayout2) {
            Intent intent = new Intent(this, CoordinatorLayout2Activity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_activity) {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_circlelayout) {
            Intent intent = new Intent(this, CircleLayoutActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_cardview) {
            Intent intent = new Intent(this, CardViewActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_evenhandler) {
            Intent intent = new Intent(this, EventHandlerActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_intent) {
            Intent intent = new Intent(this, IntentActivity.class);
            //Sử dụng Extra
//            intent.putExtra("Key_1", "Truyền một String");  // Truyền một String
//            intent.putExtra("Key_2", 5);                    // Truyền một Int
//            intent.putExtra("Key_3", true);                 // Truyền một Boolean

            //Sử dụng Bundle
            Bundle bundle = new Bundle();
            bundle.putString("Key_1", "Truyền một String"); // Truyền một String
            bundle.putInt("Key_2", 5);                      // Truyền một Int
            bundle.putBoolean("Key_3", true);               // Truyền một Boolean
            intent.putExtras(bundle);

            startActivity(intent);
            return true;
        }else if (id == R.id.nav_fragement) {
            Intent intent = new Intent(this, FragmentDemoActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_horizontal_listview) {
            Intent intent = new Intent(this, HorizontalListviewDemoActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_list_fragement) {
            Intent intent = new Intent(this, FragementListActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_imageviewer) {
            Intent intent = new Intent(this, ImageViewActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_quanlynhanvien) {
            Intent intent = new Intent(this, EmployeeListActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.nav_send) {

        }else if (id == R.id.nav_tictactoe) {
            Intent intent = new Intent(this, TicTacToeActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_quanlysach) {
            Intent intent = new Intent(this, EbookFormActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_dangnhap) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_rxjavademo) {
            Intent intent = new Intent(this, RxJavaDemoActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.nav_tournote) {
            Intent intent = new Intent(this, TourNoteActivity.class);
            startActivity(intent);
//            finish();
            return true;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
