package co.hackcancer.hackcancer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.hackcancer.hackcancer.network.StaticDataHolder;
import co.hackcancer.hackcancer.network.response.Package;

public class ProductRatingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<co.hackcancer.hackcancer.network.response.Package> items = new ArrayList<>();
    private Context context;
    //private LocationSelectedListener mListener;

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


    static class PackageRatingViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;

        public PackageRatingViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.product_name);
            image = (ImageView) itemView.findViewById(R.id.product_image);

        }

    }

}
