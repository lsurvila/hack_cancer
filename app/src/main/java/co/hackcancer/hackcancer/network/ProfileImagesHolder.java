package co.hackcancer.hackcancer.network;

import android.util.SparseArray;

import co.hackcancer.hackcancer.R;

public class ProfileImagesHolder {
    private static ProfileImagesHolder ourInstance;
    private SparseArray<Integer> imageHolder;

    public static ProfileImagesHolder getInstance() {
        if (ourInstance == null) {
            ourInstance = new ProfileImagesHolder();
        }
        return ourInstance;
    }

    private ProfileImagesHolder() {
        imageHolder = new SparseArray<>();
        imageHolder.append(1, R.drawable.profilepic_adriana);
        imageHolder.append(2, R.drawable.profilepic_chim);
        imageHolder.append(3, R.drawable.profilepic_chris);
        imageHolder.append(4, R.drawable.profilepic_joshua);
        imageHolder.append(5, R.drawable.profilepic_liudas);
    }

    public int getImage(long userId) {
        return imageHolder.get((int) userId);
    }

}
