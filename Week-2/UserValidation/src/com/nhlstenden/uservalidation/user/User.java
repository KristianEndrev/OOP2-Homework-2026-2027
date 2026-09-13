package com.nhlstenden.uservalidation.user;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String name;
    private String password;
    private String email;
    private LocalDate dateOfBirth;

    public User(String name, String password, String email, LocalDate dateOfBirth)
    {
        this.setName(name);
        this.setPassword(password);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
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

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        if (password == null || password.isBlank())
        {
            throw new IllegalArgumentException("password cannot be null or blank");
        }

        this.password = password;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if (email == null || email.isBlank())
        {
            throw new IllegalArgumentException("email cannot be null or blank");
        }

        this.email = email;
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

    public int getAge()
    {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
}
