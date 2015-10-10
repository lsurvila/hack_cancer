package co.hackcancer.hackcancer.network;

import co.hackcancer.hackcancer.network.response.UserResponse;
import retrofit.http.GET;
import rx.Observable;

public interface HackCancerService {

    @GET("/apis/9da51a4a")
    Observable<UserResponse> getUsers();

}
