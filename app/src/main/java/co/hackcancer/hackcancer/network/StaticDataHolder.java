package co.hackcancer.hackcancer.network;

import android.util.SparseArray;

import co.hackcancer.hackcancer.R;

public class StaticDataHolder {
    private static StaticDataHolder ourInstance;
    private SparseArray<Integer> profileImageHolder;
    private SparseArray<Integer> packageImageHolder;
    private static final int USER_ID = 1;

    public static StaticDataHolder getInstance() {
        if (ourInstance == null) {
            ourInstance = new StaticDataHolder();
        }
        return ourInstance;
    }

    private StaticDataHolder() {
        profileImageHolder = new SparseArray<>();
        profileImageHolder.append(1, R.drawable.profilepic_debra);
        profileImageHolder.append(2, R.drawable.profilepic_chim);
        profileImageHolder.append(3, R.drawable.profilepic_chris);
        profileImageHolder.append(4, R.drawable.profilepic_joshua);
        profileImageHolder.append(5, R.drawable.profilepic_liudas);
        profileImageHolder.append(6, R.drawable.profilepic_adriana);

        packageImageHolder = new SparseArray<>();
        packageImageHolder.append(1, R.drawable.aloe_socks);
        packageImageHolder.append(2, R.drawable.baby_oil_lavender);
        packageImageHolder.append(3, R.drawable.biotene_mouth_wash);
        packageImageHolder.append(4, R.drawable.blanket);
        packageImageHolder.append(5, R.drawable.brow_stencils);
    }

    public int getProfileImage(long userId) {
        return profileImageHolder.get((int) userId);
    }

    public int getPackageImage(long packageId) {
        return packageImageHolder.get((int) packageId);
    }

    public static int getUserId() {
        return USER_ID;
    }
}
