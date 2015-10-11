package co.hackcancer.hackcancer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class YourFriendsFragment extends Fragment {

    protected RelativeLayout mYourFriendsContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mYourFriendsContainer = (RelativeLayout) inflater.inflate(R.layout.fragment_your_friends, null, false);
        return mYourFriendsContainer;
    }
}
