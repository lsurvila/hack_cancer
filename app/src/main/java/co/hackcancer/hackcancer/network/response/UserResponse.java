package co.hackcancer.hackcancer.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserResponse extends BaseResponse {

    @SerializedName("result")
    @Expose
    private List<Result> result = new ArrayList<>();


    /**
     *
     * @return
     * The result
     */
    public List<Result> getResult() {
        return result;
    }

    public class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

    }

}
