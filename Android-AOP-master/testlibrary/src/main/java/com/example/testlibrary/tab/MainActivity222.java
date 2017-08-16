package com.example.testlibrary.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.testlibrary.R;
import com.example.testlibrary.db.Pageinfo;
import com.example.testlibrary.db.TestDbHelper;
import com.example.testlibrary.tab.adapter.MainViewAdapter;
import com.example.testlibrary.tab.listener.OnTabSelectedListener;
import com.example.testlibrary.tab.widget.Tab;
import com.example.testlibrary.tab.widget.TabContainerView;

import java.util.List;


public class MainActivity222 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);

        try
        {
            List<Pageinfo> list = TestDbHelper.getInstance(this).getTestDb().queryForAll();
            List<Pageinfo> list1 = TestDbHelper.getInstance(this).getTestDb().queryForAll();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        TabContainerView tabContainerView = (TabContainerView) findViewById(R.id.tab_container);
        MainViewAdapter mainViewAdapter=new MainViewAdapter(getSupportFragmentManager(),
                new Fragment[] {new TabFragment1(), new TabFragment2(),new TabFragment3(), new TabFragment4(),new TabFragment5()});
        mainViewAdapter.setHasMsgIndex(5);
        tabContainerView.setAdapter(mainViewAdapter);
        tabContainerView.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {

            }
        });


    }
}
