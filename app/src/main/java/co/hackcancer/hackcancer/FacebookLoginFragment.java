package co.hackcancer.hackcancer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class FacebookLoginFragment extends Fragment {

    protected RelativeLayout mFacebookLoginContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFacebookLoginContainer = (RelativeLayout) inflater.inflate(R.layout.fragment_facebook_login, null, false);
        return mFacebookLoginContainer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
