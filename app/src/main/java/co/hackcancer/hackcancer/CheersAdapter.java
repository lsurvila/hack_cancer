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
import co.hackcancer.hackcancer.network.response.Cheer;

public class CheersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_STATUS = 0;
    private static final int VIEW_TYPE_TEXT = 1;
    private static final int VIEW_TYPE_IMAGE = 2;

    private List<Cheer> items = new ArrayList<>();
    private Context context;
    //private LocationSelectedListener mListener;



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        switch (viewType) {
            case VIEW_TYPE_STATUS:
            default:
                return new SendStatusViewHolder(inflateView(parent, R.layout.layout_update_status));
            case VIEW_TYPE_TEXT:
            case VIEW_TYPE_IMAGE:
                return new CheerViewHolder(inflateView(parent, R.layout.layout_cheer));
        }
    }

    private View inflateView(ViewGroup parent, int resource) {
        return LayoutInflater.from(context).inflate(resource, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_STATUS:
            default:
                SendStatusViewHolder sendStatusViewHolder = (SendStatusViewHolder) viewHolder;
                break;
            case VIEW_TYPE_TEXT:
                CheerViewHolder textCheerViewHolder = (CheerViewHolder) viewHolder;
                Cheer textCheer = getItem(position);
                textCheerViewHolder.text.setText(textCheer.messageText);
                textCheerViewHolder.profileImage.setImageResource(StaticDataHolder.getInstance().getProfileImage(textCheer.fromId));
                textCheerViewHolder.image.setVisibility(View.GONE);
                break;
            case VIEW_TYPE_IMAGE:
                CheerViewHolder cheerViewHolder = (CheerViewHolder) viewHolder;
                Cheer cheer = getItem(position);
                cheerViewHolder.text.setText(cheer.messageText);
                cheerViewHolder.profileImage.setImageResource(StaticDataHolder.getInstance().getProfileImage(cheer.fromId));
                cheerViewHolder.image.setImageResource(StaticDataHolder.getInstance().getCheersImage(cheer.messageType));
                break;
        }
    }


    private Cheer getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_STATUS;
        } else if (getItem(position).messageType.equals("freeText")) {
            return VIEW_TYPE_TEXT;
        } else {
            return VIEW_TYPE_IMAGE;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void refresh(List<Cheer> items) {
        this.items.clear();
        this.items.add(new Cheer());
        this.items.addAll(items);
        notifyDataSetChanged();
    }

//    public void setOnItemClickListener(LocationSelectedListener landingPageFragmentListener) {
//        mListener = landingPageFragmentListener;
//    }

    static class SendStatusViewHolder extends RecyclerView.ViewHolder {

        public SendStatusViewHolder(View itemView) {
            super(itemView);
        }

    }

    static class CheerViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImage;
        ImageView image;
        TextView text;

        public CheerViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.cheer_text);
            image = (ImageView) itemView.findViewById(R.id.cheer_image);
            profileImage = (ImageView) itemView.findViewById(R.id.cheer_profile_image);
        }

    }


}
