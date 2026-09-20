package com.nhlstenden.appstores;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class User
{
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private List<App> apps;

    public User(String name, String email, LocalDate dateOfBirth)
    {
        this.setName(name);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setApps(new ArrayList<>());
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if (EmailValidator.validateEmail(email))
        {
            this.email = email;
        }
        else
        {
            this.email = null;
        }

    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null or in the future");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public List<App> getApps()
    {
        return new ArrayList<>(this.apps);
    }

    public void setApps(List<App> apps)
    {
        if (apps == null)
        {
            throw new IllegalArgumentException("apps cannot be null");
        }

        for (App app : apps)
        {
            if (app == null)
            {
                throw new IllegalArgumentException("An app cannot be null");
            }
        }

        this.apps = new ArrayList<>(apps);
    }

    public int getAge()
    {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void addApp(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("App cannot be null");
        }

        this.apps.add(app);
    }
}
