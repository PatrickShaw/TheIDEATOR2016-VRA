package com.ideator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class FakeActivity extends AppCompatActivity {
    public static Intent newIntent(Context context)
    {
        return new Intent(context, FakeActivity.class);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportFragmentManager().findFragmentByTag("test") == null)
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment_holder, FakeFragment.newInstance(), "test").commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_fake_to_real_app:
                Intent intentSignIn = SignInActivity.newIntent(this);
                startActivity(intentSignIn);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_fake, menu);
        return super.onCreateOptionsMenu(menu);

    }
}
