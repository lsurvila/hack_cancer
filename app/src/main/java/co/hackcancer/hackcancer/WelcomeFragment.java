package co.hackcancer.hackcancer;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class WelcomeFragment extends Fragment {

    protected TextView mWelcomeText;
    protected TextView mSupporterText;
    protected TextView mFighterText;
    protected RelativeLayout mWelcomeContainer;

    public WelcomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mWelcomeContainer = (RelativeLayout) inflater.inflate(R.layout.fragment_welcome, null, false);

        populateWidgets();

        return mWelcomeContainer;
    }

    private void populateWidgets() {
        mWelcomeText = (TextView) mWelcomeContainer.findViewById(R.id.welcomeMessage);
        mSupporterText = (TextView) mWelcomeContainer.findViewById(R.id.supporter);
        mFighterText = (TextView) mWelcomeContainer.findViewById(R.id.fighter);
    }
}
