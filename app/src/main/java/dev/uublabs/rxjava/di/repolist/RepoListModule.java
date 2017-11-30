package dev.uublabs.rxjava.di.repolist;

import javax.inject.Singleton;

import dagger.Provides;
import dagger.Module;
import dev.uublabs.rxjava.view.repolist.RepoListPresenter;

/**
 * Created by Admin on 11/29/2017.
 */

@Module
public class RepoListModule
{
    @Provides
    @Singleton
    RepoListPresenter providerRepoListPresenter()
    {
        return new RepoListPresenter();
    }
}
