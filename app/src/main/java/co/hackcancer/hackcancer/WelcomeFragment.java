package co.hackcancer.hackcancer;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import co.hackcancer.hackcancer.network.HackCancerApi;
import co.hackcancer.hackcancer.network.MockHackCancerApi;
import co.hackcancer.hackcancer.network.response.UserResponse;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * A placeholder fragment containing a simple view.
 */
public class WelcomeFragment extends Fragment {

    protected TextView mWelcomeText;
    protected TextView mSupporterText;
    protected TextView mFighterText;
    protected TextView mHiThereText;
    protected RelativeLayout mWelcomeContainer;

    public WelcomeFragment() {
        super();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*HackCancerApi.getInstance().getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserResponse>() {
                    @Override
                    public void call(UserResponse userResponse) {
                        showUsers(userResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        showError(throwable);
                    }
                });

        MockHackCancerApi.getInstance(getContext()).getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserResponse>() {
                    @Override
                    public void call(UserResponse userResponse) {
                        showUsers(userResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        showError(throwable);
                    }
                });*/
    }

    private void showUsers(UserResponse userResponse) {
        String users = "";
        for (UserResponse.Result user : userResponse.getResult()) {
            users += user.getName() + " ";
        }
        Toast.makeText(getContext(), users, Toast.LENGTH_SHORT).show();
    }

    private void showError(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
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
        mHiThereText = (TextView) mWelcomeContainer.findViewById(R.id.hiThere);

        mHiThereText.setText(String.format(getString(R.string.WelcomeText), "Chris"));
    }
}
