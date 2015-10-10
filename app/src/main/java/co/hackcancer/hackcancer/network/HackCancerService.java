package co.hackcancer.hackcancer.network;

import co.hackcancer.hackcancer.network.response.CheersResponse;
import co.hackcancer.hackcancer.network.response.UserResponse;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface HackCancerService {

    @GET("/apis/9da51a4a")
    Observable<UserResponse> getUsers();

    @GET("/users/{user_id}/cheers")
    Observable<CheersResponse> getCheers(@Path("user_id") int userId);

}
