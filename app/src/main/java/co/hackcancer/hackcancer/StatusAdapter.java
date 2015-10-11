package co.hackcancer.hackcancer;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.hackcancer.hackcancer.network.StaticDataHolder;
import co.hackcancer.hackcancer.network.response.*;

/**
 * Created by Chris on 11/10/2015.
 */
public class StatusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<co.hackcancer.hackcancer.network.response.Status> items = new ArrayList<>();
    private Context context;
    private FragmentManager fragmentManager;

    public StatusAdapter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new StatusViewHolder(inflateView(parent, R.layout.layout_status));
    }

    private View inflateView(ViewGroup parent, int resource) {
        return LayoutInflater.from(context).inflate(resource, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        StatusViewHolder packageRatingViewHolder = (StatusViewHolder) viewHolder;
        Status status = getItem(position);
        packageRatingViewHolder.statusText.setText(status.status);
        //packageRatingViewHolder.image.setImageResource(StaticDataHolder.getInstance().getPackageImage(pack.packageId));
    }

    private Status getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void refresh(List<Status> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    class StatusViewHolder extends RecyclerView.ViewHolder {
        TextView statusText;

        public StatusViewHolder(View itemView) {
            super(itemView);
            statusText = (TextView) itemView.findViewById(R.id.statusText);
        }
    }
}
