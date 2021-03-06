package co.hackcancer.hackcancer;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import co.hackcancer.hackcancer.helper.VerticalDividerSpaceItemDecoration;
import co.hackcancer.hackcancer.network.HackCancerApi;
import co.hackcancer.hackcancer.network.StaticDataHolder;
import co.hackcancer.hackcancer.network.response.CheersResponse;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * Allows Fighter to see cheers from people and update status.
 */
public class CheersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView listView;
    private ProgressBar progressBar;
    private CheersAdapter adapter;
    private Subscription cheersSubscription;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheersFragment newInstance(String param1, String param2) {
        CheersFragment fragment = new CheersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CheersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cheers, container, false);
        progressBar = (ProgressBar) view.findViewById(R.id.cheers_loading);
        listView = (RecyclerView) view.findViewById(R.id.cheers_list);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.addItemDecoration(new VerticalDividerSpaceItemDecoration(getResources().getDimensionPixelOffset(R.dimen.cheers_divider_height)));
        adapter = new CheersAdapter();
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TODO call real api when there is enough data

    }

    @Override
    public void onResume() {
        super.onResume();
        cheersSubscription = HackCancerApi.getInstance().getCheers(StaticDataHolder.getUserId())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CheersResponse>() {
                    @Override
                    public void call(CheersResponse cheersResponse) {
                        progressBar.setVisibility(View.GONE);
                        adapter.refresh(cheersResponse.cheers);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    @Override
    public void onPause() {
        super.onPause();
        if (cheersSubscription != null) {
            cheersSubscription.unsubscribe();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
