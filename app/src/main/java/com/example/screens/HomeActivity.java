package com.example.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.screens.fragments.GroupsFragment;
import com.example.screens.fragments.HomeFragment;
import com.example.screens.fragments.SaveProfileFragment;
import com.example.screens.interfaces.FragmentListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    ImageView openDrawer , openBarCode;
    BottomNavigationView navigation;
    FragmentListener fragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentListener = new FragmentListener() {
            @Override
            public void moveFragment(int fragment) {
                if(fragment == 0){
                    navigation.setSelectedItemId(R.id.save_profile);
                    loadFragment(new SaveProfileFragment());
                }
            }
        };

        initComponent();
        initListener();


        toggle = new ActionBarDrawerToggle(this , drawerLayout , R.string.open , R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){
                    case R.id.drawer_home:{
                        Toast.makeText(HomeActivity.this, "home", Toast.LENGTH_SHORT).show();
                        loadFragment(new HomeFragment());
                        navigation.setSelectedItemId(R.id.home_data);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.drawer_activate:{
                        Intent intent = new Intent(HomeActivity.this , ActivateActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.qr_code:{
                        Intent intent = new Intent(HomeActivity.this , ScanCodeActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.read_go_tap_icon_menu:{
                        drawerLayout.closeDrawer(GravityCompat.START);
                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                        bottomSheet.show(getSupportFragmentManager(),
                                "ModalBottomSheet");
                        break;
                    }
                    case R.id.how_to_go_tap:{
                        Intent intent = new Intent(HomeActivity.this , WalkThroughActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.logout:{
                        Intent intent = new Intent(HomeActivity.this , MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                }


                return false;
            }
        });
    }

    private void initListener() {
        openDrawer.setOnClickListener(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.home_data);
        openBarCode.setOnClickListener(this);
    }

    private void initComponent() {
        nav = findViewById(R.id.nav_menu);
        drawerLayout = findViewById(R.id.drawer);
        openDrawer = findViewById(R.id.open_drawer);
        openBarCode = findViewById(R.id.barcode);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.open_drawer:{
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            }
            case R.id.barcode:{
                Intent intent = new Intent(HomeActivity.this , ScanCodeActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.save_profile:
                    loadFragment(new SaveProfileFragment());
                    return true;
                case R.id.navigation_gifts:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    BottomSheetDialog bottomSheet = new BottomSheetDialog();
                    bottomSheet.show(getSupportFragmentManager(),
                            "ModalBottomSheet");
                    return true;
                case R.id.home_data:
                    loadFragment(new HomeFragment(fragmentListener));
                    return true;
                case R.id.bar_code:
                    Intent intent = new Intent(HomeActivity.this , ScanCodeActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.group:
                    loadFragment(new GroupsFragment());
                    return true;
            }
            return false;
        }
    };


}