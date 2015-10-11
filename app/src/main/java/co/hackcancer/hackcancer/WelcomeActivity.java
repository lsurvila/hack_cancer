package co.hackcancer.hackcancer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class WelcomeActivity extends AppCompatActivity {

    private Fragment mWelcomeFragment;
    private Fragment mFacebookFragment;
    private Fragment mYourFriendsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        mWelcomeFragment = new WelcomeFragment();
// Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainFrame, mWelcomeFragment)
                .commit();
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
                    finish();
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.start();

        ((FacebookLoginFragment) mFacebookFragment).showFacebookSignIn(false);
        ((FacebookLoginFragment) mFacebookFragment).showFacebookInvites(true);
    }

    public void goToFighterLogin(View view) {
        mFacebookFragment = new FacebookLoginFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainFrame, mFacebookFragment)
                .commit();
    }

    public void skipFbInvites(View view) {
        mYourFriendsFragment = new YourFriendsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainFrame, mYourFriendsFragment)
                .commit();
        //startActivity(new Intent(getBaseContext(), MainSupporterActivity.class));
    }

}
