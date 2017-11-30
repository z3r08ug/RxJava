package dev.uublabs.rxjava.di.repolist;

import javax.inject.Singleton;

import dagger.Component;
import dev.uublabs.rxjava.view.repolist.RepoList;

/**
 * Created by Admin on 11/29/2017.
 */

@Component(modules = RepoListModule.class)
@Singleton
public interface RepoListComponent
{

    void inject(RepoList repoList);
}
