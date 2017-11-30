package dev.uublabs.rxjava.di;

/**
 * Created by Admin on 11/29/2017.
 */

public class Calculation
{

    Addition addition;

    public Calculation(Addition addition)
    {
        this.addition = addition;
    }
    public  int add(int a, int b)
    {
        return addition.add(a, b);
    }
}
