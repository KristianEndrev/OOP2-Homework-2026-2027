package com.nhlstenden.uservalidation.validation;
import com.nhlstenden.uservalidation.user.*;

public interface ValidationRule
{
    public boolean validate(User user);
}
