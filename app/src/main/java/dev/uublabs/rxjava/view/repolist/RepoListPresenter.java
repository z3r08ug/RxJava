package dev.uublabs.rxjava.view.repolist;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.uublabs.rxjava.data.remote.RemoteDataSource;
import dev.uublabs.rxjava.di.Calculation;
import dev.uublabs.rxjava.model.Repo;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 11/29/2017.
 */

public class RepoListPresenter implements RepoListContract.Presenter
{
    RepoListContract.View view;
    public static final String TAG = RepoListPresenter.class.getSimpleName() + "_TAG";
    List<Repo> repoList = new ArrayList<>();

    @Override
    public void attachView(RepoListContract.View view)
    {
        this.view = view;
    }

    @Override
    public void detachView()
    {

    }

    @Override
    public void getRepos(String username)
    {

        RemoteDataSource.getUserRepos("z3r08ug")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Repo>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                        view.showProgress("Downloading repos...");
                    }

                    @Override
                    public void onNext(List<Repo> repos)
                    {
                        Log.d(TAG, "onNext: " + repos.size());
                        repoList.addAll(repos);
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        view.showError(e.toString());
                    }

                    @Override
                    public void onComplete()
                    {
                        view.showProgress("Check your logs");
                        view.setRepos(repoList);
                        view.showProgress("Downloaded all repos");
                    }
                });
    }


}
