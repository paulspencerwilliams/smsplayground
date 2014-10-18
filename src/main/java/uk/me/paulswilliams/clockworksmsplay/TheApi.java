package uk.me.paulswilliams.clockworksmsplay;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface TheApi {

    @PUT("/users/{userId}/position")
    public Response registerPosition(@Path("userId") int userId, @Body Coordinate coordinate);
}
