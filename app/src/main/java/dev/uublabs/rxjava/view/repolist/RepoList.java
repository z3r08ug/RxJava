package dev.uublabs.rxjava.view.repolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import dev.uublabs.rxjava.R;
import dev.uublabs.rxjava.data.remote.RemoteDataSource;
import dev.uublabs.rxjava.di.repolist.DaggerRepoListComponent;
import dev.uublabs.rxjava.model.Repo;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RepoList extends AppCompatActivity implements RepoListContract.View
{

    private static final String TAG = RepoList.class.getSimpleName() + "_TAG";

    @Inject
    RepoListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DaggerRepoListComponent
        DaggerRepoListComponent.create().inject(this);

        presenter.attachView(this);
        presenter.getRepos("z3r08ug");
    }

    @Override
    public void showError(String error)
    {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRepos(List<Repo> repos)
    {
        for (Repo repo : repos)
        {
            Log.d(TAG, "setRepos: " + repo.getName());
        }
    }

    @Override
    public void showProgress(String progress)
    {
        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        presenter.detachView();
    }
}
