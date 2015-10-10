package co.hackcancer.hackcancer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import co.hackcancer.hackcancer.network.HackCancerApi;
import co.hackcancer.hackcancer.network.response.UserResponse;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HackCancerApi.getInstance().getUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserResponse>() {
                    @Override
                    public void call(UserResponse userResponse) {
                        Toast.makeText(getContext(), "Hello " + userResponse.getResult().get(0).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
