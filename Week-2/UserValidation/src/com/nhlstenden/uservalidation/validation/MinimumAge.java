package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.User;

public class MinimumAge implements ValidationRule
{
    private int age;

    public MinimumAge(int age)
    {
        this.setAge(age);
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        if (age < 1)
        {
            throw new IllegalArgumentException("Age cannot be less than 1");
        }

        this.age = age;
    }

    @Override
    public boolean validate(User user)
    {
        if (user.getAge() < getAge())
        {
            return false;
        }

        return true;
    }
}
