package vn.quanlynhanvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import vn.quanlynhanvien.adapters.ViewPagerAdapter;
import vn.quanlynhanvien.fragements.ChatListFragment;
import vn.quanlynhanvien.fragements.ForumFragment;
import vn.quanlynhanvien.fragements.GaleryFragment;
import vn.quanlynhanvien.fragements.HomeFragment;
import vn.quanlynhanvien.fragements.JobsFragment;

public class MainActivity extends AppCompatActivity {

    TextView toolbarTitle;

    ViewPager viewPager;
    TabLayout tabLayout;
    TabLayout.Tab currentTab;

    ViewPagerAdapter adapter;

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new JobsFragment());
        adapter.addFragment(new ForumFragment());
        adapter.addFragment(new ChatListFragment());
        adapter.addFragment(new GaleryFragment());

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab tabCall = tabLayout.getTabAt(0);tabCall.setIcon(R.drawable.tab_home);
        TabLayout.Tab tabCall2 = tabLayout.getTabAt(1);tabCall2.setIcon(R.drawable.tab_jobs);
        TabLayout.Tab tabCall3 = tabLayout.getTabAt(2);tabCall3.setIcon(R.drawable.tab_forum);
        TabLayout.Tab tabCall4 = tabLayout.getTabAt(3);tabCall4.setIcon(R.drawable.tab_chat);
        TabLayout.Tab tabCall5 = tabLayout.getTabAt(4);tabCall5.setIcon(R.drawable.tab_gallery);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Flag Setter
                currentTab = tab;
                if(tab.getPosition() == 0){flag =0;}else if(tab.getPosition() == 1){flag = 1;}
                if(tab.getPosition() == 0){
                    //Library
                    setTitle("Home");
                }
                else if(tab.getPosition() == 1){
                    //Store
                    setTitle("Jobs");
                }
                else if(tab.getPosition() == 2){
                    //Activity
                    setTitle("Forum");
                }
                else if(tab.getPosition() == 3){
                    //Menu
                    setTitle("Chat");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
