package dev.uublabs.rxjava.view.repolist;

import java.util.List;

import dev.uublabs.rxjava.model.Repo;
import dev.uublabs.rxjava.util.BasePresenter;
import dev.uublabs.rxjava.util.BaseView;

/**
 * Created by Admin on 11/29/2017.
 */

public interface RepoListContract
{
    //methods for repolist activity
    interface View extends BaseView
    {
        void setRepos(List<Repo> repos);
        void showProgress(String progress);
    }

    interface Presenter extends BasePresenter<View>
    {
        void getRepos(String username);
    }
}
