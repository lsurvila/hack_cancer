package co.hackcancer.hackcancer;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.hackcancer.hackcancer.network.StaticDataHolder;
import co.hackcancer.hackcancer.network.response.Package;

public class ProductRatingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<co.hackcancer.hackcancer.network.response.Package> items = new ArrayList<>();
    private Context context;
    private FragmentManager fragmentManager;
    //private LocationSelectedListener mListener;

    public ProductRatingsAdapter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new PackageRatingViewHolder(inflateView(parent, R.layout.layout_product_rating));
    }

    private View inflateView(ViewGroup parent, int resource) {
        return LayoutInflater.from(context).inflate(resource, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        PackageRatingViewHolder packageRatingViewHolder = (PackageRatingViewHolder) viewHolder;
        Package pack = getItem(position);
        packageRatingViewHolder.text.setText(pack.name);
        packageRatingViewHolder.image.setImageResource(StaticDataHolder.getInstance().getPackageImage(pack.packageId));
    }


    private Package getItem(int position) {
        return items.get(position);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void refresh(List<Package> items) {
        this.items = items;
        notifyDataSetChanged();
    }

//    public void setOnItemClickListener(LocationSelectedListener landingPageFragmentListener) {
//        mListener = landingPageFragmentListener;
//    }

    class PackageRatingViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;
        RatingBar ratingBar;


        public PackageRatingViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SubmitReviewDialogFragment dialog = new SubmitReviewDialogFragment();
                    dialog.show(fragmentManager, "fragment_dialog");
                }
            });
            text = (TextView) itemView.findViewById(R.id.product_name);
            image = (ImageView) itemView.findViewById(R.id.product_image);
            ratingBar = (RatingBar) itemView.findViewById(R.id.product_rating_stars);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    ratingBar.setNumStars((int) rating);
//                    SubmitReviewDialogFragment dialog = new SubmitReviewDialogFragment();
//                    dialog.show(fragmentManager, "fragment_dialog");
                }
            });
            ratingBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    SubmitReviewDialogFragment dialog = new SubmitReviewDialogFragment();
//                    dialog.show(fragmentManager, "fragment_dialog");
                }
            });
        }

    }

}
