package co.hackcancer.hackcancer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FacebookLoginFragment extends Fragment {

    protected RelativeLayout mFacebookLoginContainer;
    protected ImageView mFacebookSignin;
    protected ImageView mFacebookInvites;
    protected TextView mSkip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFacebookLoginContainer = (RelativeLayout) inflater.inflate(R.layout.fragment_facebook_login, null, false);

        mSkip = (TextView) mFacebookLoginContainer.findViewById(R.id.skip);

        return mFacebookLoginContainer;
    }

    public void showFacebookInvites(Boolean show) {
        if (mFacebookLoginContainer == null) {
            return;
        }

        if (mFacebookInvites == null) {
            mFacebookInvites = (ImageView) mFacebookLoginContainer.findViewById(R.id.facebookInvite);
        }

        mFacebookInvites.setVisibility(show ? View.VISIBLE : View.GONE);
        showSkipButton(show);
    }

    public void showFacebookSignIn(Boolean show) {
        if (mFacebookLoginContainer == null) {
            return;
        }

        if (mFacebookSignin == null) {
            mFacebookSignin = (ImageView) mFacebookLoginContainer.findViewById(R.id.facebookLogin);
        }

        mFacebookSignin.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showSkipButton(Boolean show) {
        if (mFacebookLoginContainer == null) {
            return;
        }

        if (mSkip == null) {
            mSkip = (TextView) mFacebookLoginContainer.findViewById(R.id.skip);
        }

        mSkip.setVisibility(show ? View.VISIBLE : View.GONE);
    }

}
