package com.example.viewpagerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.viewpagerproject.databinding.ActivityMainBinding;
import com.example.viewpagerproject.fragments.HomeFragment;
import com.example.viewpagerproject.fragments.LibraryFragment;
import com.example.viewpagerproject.fragments.SearchFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {
    ActivityMainBinding activityMainBinding;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        setViewPagerAdapter();
        setTitle();

        new TabLayoutMediator(activityMainBinding.tablayout,activityMainBinding.viewPager2,this).attach();
    }

    public void setViewPagerAdapter() {
        ViewPager2Adapter viewPager2Adapter = new
                ViewPager2Adapter(this);
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new LibraryFragment());
        fragmentList.add(new SearchFragment());

        viewPager2Adapter.setData(fragmentList);
        activityMainBinding.viewPager2.setAdapter(viewPager2Adapter);
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }

    public void setTitle(){
        titles = new ArrayList<String>();
        titles.add("Home");
        titles.add("Library");
        titles.add("Search");
    }
}