package dev.uublabs.rxjava.data.remote;

import java.util.List;

import dev.uublabs.rxjava.model.Repo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Admin on 11/29/2017.
 */

public interface RemoteService
{
    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String username);
}
