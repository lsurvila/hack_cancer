package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cheer {

    @SerializedName("from_id")
    @Expose
    public long fromId;
    @SerializedName("to_id")
    @Expose
    public long toId;
    @SerializedName("message_type")
    @Expose
    public String messageType;
    @SerializedName("message_text")
    @Expose
    public String messageText;

}