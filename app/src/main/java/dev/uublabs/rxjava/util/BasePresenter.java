package dev.uublabs.rxjava.util;

/**
 * Created by Admin on 11/29/2017.
 */

public interface BasePresenter <V extends BaseView>
{
    void attachView(V view);
    void detachView();
}
