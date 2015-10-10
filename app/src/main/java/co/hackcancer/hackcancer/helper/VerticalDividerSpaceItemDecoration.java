package co.hackcancer.hackcancer.helper;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class VerticalDividerSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mDividerHeight;

    public VerticalDividerSpaceItemDecoration(int dividerHeight) {
        mDividerHeight = dividerHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (!isLastItem(view, parent)) {
            outRect.bottom = mDividerHeight;
        }
    }

    private boolean isLastItem(View view, RecyclerView parent) {
        return parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1;
    }

}