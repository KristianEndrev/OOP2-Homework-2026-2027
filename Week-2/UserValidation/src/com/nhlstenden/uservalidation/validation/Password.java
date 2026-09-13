package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.*;

public class Password implements ValidationRule
{
    private boolean spacesAllowed;
    private boolean specialCharsMandatory;
    private boolean numbersRequired;
    private boolean lowercaseRequired;
    private boolean uppercaseRequired;

    public Password(boolean spacesAllowed, boolean specialCharsMandatory, boolean numbersRequired, boolean lowercaseRequired, boolean uppercaseRequired)
    {
        this.setSpacesAllowed(spacesAllowed);
        this.setSpecialCharsMandatory(specialCharsMandatory);
        this.setNumbersRequired(numbersRequired);
        this.setLowercaseRequired(lowercaseRequired);
        this.setUppercaseRequired(uppercaseRequired);
    }

    public boolean isSpacesAllowed()
    {
        return this.spacesAllowed;
    }

    public void setSpacesAllowed(boolean spacesAllowed)
    {
        this.spacesAllowed = spacesAllowed;
    }

    public boolean isSpecialCharsMandatory()
    {
        return this.specialCharsMandatory;
    }

    public void setSpecialCharsMandatory(boolean specialCharsMandatory)
    {
        this.specialCharsMandatory = specialCharsMandatory;
    }

    public boolean isNumbersRequired()
    {
        return this.numbersRequired;
    }

    public void setNumbersRequired(boolean numbersRequired)
    {
        this.numbersRequired = numbersRequired;
    }

    public boolean isLowercaseRequired()
    {
        return this.lowercaseRequired;
    }

    public void setLowercaseRequired(boolean lowercaseRequired)
    {
        this.lowercaseRequired = lowercaseRequired;
    }

    public boolean isUppercaseRequired()
    {
        return this.uppercaseRequired;
    }

    public void setUppercaseRequired(boolean uppercaseRequired)
    {
        this.uppercaseRequired = uppercaseRequired;
    }

    @Override
    public boolean validate(User user)
    {
        String password = user.getPassword();
        if (!isSpacesAllowed())
        {
            if (password.contains(" "))
            {
                return false;
            }
        }
        if (isSpecialCharsMandatory())
        {
            if (!password.matches(".*[^a-zA-Z0-9].*"))
            {
                return false;
            }
        }
        if (isNumbersRequired())
        {
            if (!password.matches(".*[0-9].*"))
            {
                return false;
            }
        }
        if (isLowercaseRequired())
        {
            if (!password.matches(".*[a-z].*"))
            {
                return false;
            }
        }
        if (isUppercaseRequired())
        {
            if (!password.matches(".*[A-Z].*"))
            {
                return false;
            }
        }

        return true;
    }
}
