package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("status")
    @Expose
    private long status;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("error")
    @Expose
    private String error;

    /**
     *
     * @return
     * The status
     */
    public long getStatus() {
        return status;
    }

    /**
     *
     * @return
     * The success
     */
    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
