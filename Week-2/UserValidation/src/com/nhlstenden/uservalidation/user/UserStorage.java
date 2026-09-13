package com.nhlstenden.uservalidation.user;

import java.util.ArrayList;
import java.util.List;

public class UserStorage
{
    private List<User> users;

    public UserStorage()
    {
        this.setUsers(new ArrayList<>());
    }

    public List<User> getUsers()
    {
        return new ArrayList<>(this.users);
    }

    public void setUsers(List<User> users)
    {
        if (users == null)
        {
            throw new IllegalArgumentException("users cannot be null");
        }

        for (User user : users)
        {
            if (user == null)
            {
                throw new IllegalArgumentException("A user cannot be null");
            }
        }

        this.users = new ArrayList<>(users);
    }

    public void addUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User cannot be null");
        }

        users.add(user);
    }

    public void removeUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User cannot be null");
        }

        users.add(user);
    }
}
