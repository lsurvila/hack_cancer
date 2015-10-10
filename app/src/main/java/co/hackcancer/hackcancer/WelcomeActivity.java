package co.hackcancer.hackcancer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        Fragment fragment = new WelcomeFragment();
// Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
    }

    public void loginWithFacebook(View view) {
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Signing in");
        progress.setMessage("Logging you in with Facebook");
        progress.show();

        Thread timer = new Thread() {
            public void run(){
                try {
                    sleep(1000);
                    progress.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.start();


    }

    public void goToFighterLogin(View view) {
        Fragment fragment = new FacebookLoginFragment();
// Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .commit();
    }

}
