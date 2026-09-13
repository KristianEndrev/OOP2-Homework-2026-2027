package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.*;

public class Username implements ValidationRule
{
    private UserStorage userStorage;

    public Username(UserStorage userStorage)
    {
        this.setUserStorage(userStorage);
    }

    public UserStorage getUserStorage()
    {
        return this.userStorage;
    }

    public void setUserStorage(UserStorage userStorage)
    {
        if (userStorage == null)
        {
            throw new IllegalArgumentException("user storage cannot be null");
        }

        this.userStorage = userStorage;
    }

    @Override
    public boolean validate(User user)
    {
        for (User user1 : userStorage.getUsers())
        {
            if (user.getName().equals(user1.getName()))
            {
                return false;
            }
        }

        return true;
    }
}
