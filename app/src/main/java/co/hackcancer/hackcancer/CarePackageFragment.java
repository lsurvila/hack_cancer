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
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.hackcancer.hackcancer.network.HackCancerApi;
import co.hackcancer.hackcancer.network.MockHackCancerApi;
import co.hackcancer.hackcancer.network.StaticDataHolder;
import co.hackcancer.hackcancer.network.response.PackagesResponse;
import co.hackcancer.hackcancer.network.response.Supporter;
import co.hackcancer.hackcancer.network.response.SupportersResponse;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * Allows Fighter to see care packages from people and allows to rate them.
 */
public class CarePackageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView listView;
    private OnFragmentInteractionListener mListener;
    private ProductRatingsAdapter adapter;
    private List<ImageView> profilePics = new ArrayList<>();
    private View supportersView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarePackageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarePackageFragment newInstance(String param1, String param2) {
        CarePackageFragment fragment = new CarePackageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CarePackageFragment() {
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
        View view = inflater.inflate(R.layout.fragment_care_package, container, false);
        adapter = new ProductRatingsAdapter();
        listView = (RecyclerView) view.findViewById(R.id.care_package_reviews);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.setAdapter(adapter);
        ImageView supporter1 = (ImageView) view.findViewById(R.id.supporter_1);
        ImageView supporter2 = (ImageView) view.findViewById(R.id.supporter_2);
        ImageView supporter3 = (ImageView) view.findViewById(R.id.supporter_3);
        ImageView supporter4 = (ImageView) view.findViewById(R.id.supporter_4);
        ImageView supporter5 = (ImageView) view.findViewById(R.id.supporter_5);
        profilePics.add(supporter1);
        profilePics.add(supporter2);
        profilePics.add(supporter3);
        profilePics.add(supporter4);
        profilePics.add(supporter5);
        supportersView = view.findViewById(R.id.container_supporters);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getSupportersAndPackages();

    }

    private void getSupportersAndPackages() {
        HackCancerApi.getInstance().getSupporters(StaticDataHolder.getUserId())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SupportersResponse>() {
                    @Override
                    public void call(SupportersResponse supportersResponse) {
                        if (supportersResponse.supporters.size() > 0) {
                            getPackages();
                            supportersView.setVisibility(View.VISIBLE);
                            for (int i = 0; i < supportersResponse.supporters.size(); i++) {
                                Supporter supporter = supportersResponse.supporters.get(i);
                                profilePics.get(i).setVisibility(View.VISIBLE);
                                profilePics.get(i).setImageResource(StaticDataHolder.getInstance().getProfileImage(supporter.id));
                            }
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getPackages() {
        MockHackCancerApi.getInstance(getContext()).getPackages(StaticDataHolder.getUserId())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<PackagesResponse>() {
                    @Override
                    public void call(PackagesResponse packagesResponse) {
                        adapter.refresh(packagesResponse.packages);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
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
