package com.nhlstenden.appstores;

public class EmailValidator
{
    public static boolean validateEmail(String email)
    {
        if (email == null || email.isBlank())
        {
            return false;
        }
        if (!email.contains("@") || !email.contains(".") || email.length() < 6)
        {
            return false;
        }

        return true;
    }
}
