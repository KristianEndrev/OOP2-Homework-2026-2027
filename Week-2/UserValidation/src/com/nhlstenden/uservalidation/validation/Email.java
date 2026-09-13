package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.*;

public class Email implements ValidationRule
{
    public Email()
    {
    }

    @Override
    public boolean validate(User user)
    {
        if (!user.getEmail().contains("@"))
        {
            return false;
        }
        else if (!user.getEmail().endsWith(".com")
                && !user.getEmail().endsWith(".org")
                && !user.getEmail().endsWith(".net")
                && !user.getEmail().endsWith(".gov")
                && !user.getEmail().endsWith(".edu"))
        {
            return false;
        }

        return true;
    }
}
