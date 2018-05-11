package group8.tkgd.menurestaurantapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.adapter.SectionsPagerAdapter;
import group8.tkgd.menurestaurantapp.fragment.BeerFragment;
import group8.tkgd.menurestaurantapp.fragment.ChickenFragment;
import group8.tkgd.menurestaurantapp.fragment.FishFragment;
import group8.tkgd.menurestaurantapp.fragment.SquidFragment;
import group8.tkgd.menurestaurantapp.fragment.WineFragment;

public class MainMenuActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        Fragment fishFragment = new FishFragment();
        Fragment squidFragment = new SquidFragment();
        Fragment chickenFragment = new ChickenFragment();
        Fragment beerFragment = new BeerFragment();
        Fragment wineFragment = new WineFragment();
        fragments.add(fishFragment);
        fragments.add(squidFragment);
        fragments.add(chickenFragment);
        fragments.add(beerFragment);
        fragments.add(wineFragment);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragments);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_menu,menu);
        if(menu instanceof MenuBuilder){

            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.item_action_search:
                Intent intent1 = new Intent(MainMenuActivity.this, SearchListActivity.class);
                startActivity(intent1);
                break;
            case R.id.item_action_sign_in:
                Intent intent2 = new Intent(MainMenuActivity.this, LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.item_action_order_management:
                Intent intent3 = new Intent(MainMenuActivity.this, OrderManagementActivity.class);
                startActivity(intent3);
                break;
            case R.id.item_action_menu_management:
                Intent intent4 = new Intent(MainMenuActivity.this, MenuManagementActivity.class);
                startActivity(intent4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
