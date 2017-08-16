package cn.jesse.aop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.testlibrary.TestmoduActivity;

import org.aspectj.org.eclipse.jdt.internal.compiler.batch.Main;

public class MainActivity extends BaseActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = (TextView) findViewById(R.id.tvTest);
        tvTest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TestmoduActivity.class);
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate");
    }
}
