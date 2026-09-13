package com.nhlstenden.uservalidation;
import com.nhlstenden.uservalidation.validation.*;
import com.nhlstenden.uservalidation.user.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidationModuleTest
{
    private UserValidationModule userValidationModule;
    private UserStorage userStorage;
    private ValidationRule emailValidationRule;
    private ValidationRule minimumAgeValidationRule;
    private ValidationRule passwordValidation;
    private ValidationRule usernameValidation;
    private User user;
    private List<ValidationRule> validationRules;

    @BeforeEach
    void setUp()
    {
        user = new User("Franz", "FranziManzi06_", "franzimanzi@gmail.com", LocalDate.of(2009, 5, 29));
        userStorage = new UserStorage();
        userValidationModule = new UserValidationModule(userStorage);
        validationRules = new ArrayList<>();
        emailValidationRule = new Email();
        minimumAgeValidationRule = new MinimumAge(18);
        passwordValidation = new Password(true, true, true, true, true);
        usernameValidation = new Username(userStorage);
    }

    @Test
    void registerUser_properValues_doesNotThrow()
    {
        validationRules.add(emailValidationRule);
        validationRules.add(minimumAgeValidationRule);
        validationRules.add(usernameValidation);
        validationRules.add(passwordValidation);
        userValidationModule.setValidationRules(validationRules);
        User user1 = new User("Kris", "Kris1_", "krisipisi@gmail.com", LocalDate.of(2006, 7, 31));
        assertDoesNotThrow(() -> userValidationModule.registerUser(user1));
    }

    @Test
    void registerUser_ageBelowMinimum_throws()
    {
        validationRules.add(minimumAgeValidationRule);
        userValidationModule.setValidationRules(validationRules);
        assertThrows(IllegalArgumentException.class, () -> {
           userValidationModule.registerUser(user);
        });
    }

    @Test
    void registerUser_ageAboveMinimum_doesNotThrow()
    {
        validationRules.add(minimumAgeValidationRule);
        userValidationModule.setValidationRules(validationRules);
        user.setDateOfBirth(LocalDate.of(2006, 5, 29));
        assertDoesNotThrow(() -> userValidationModule.registerUser(user));
    }

    @Test
    void registerUser_ageAboveMinimum_doesNotThrows()
    {
        validationRules.add(minimumAgeValidationRule);
        userValidationModule.setValidationRules(validationRules);
        user.setDateOfBirth(LocalDate.of(2006, 5, 29));
        assertDoesNotThrow(() -> userValidationModule.registerUser(user));
    }

    @Test
    void registerUser_ageAboveMinimum_userStorageHas1User()
    {
        validationRules.add(minimumAgeValidationRule);
        userValidationModule.setValidationRules(validationRules);
        user.setDateOfBirth(LocalDate.of(2006, 5, 29));
        userValidationModule.registerUser(user);
        assertEquals(1, userValidationModule.getUserStorage().getUsers().size());
    }

    @Test
    void registerUser_passwordWithSpacesWhenRuleIsNoSpacesAllowed_throws()
    {
        Password noSpaces = new Password(false, true, true, true, true);
        userValidationModule.addValidationRule(noSpaces);
        user.setPassword(" FranziManzi06_");
        assertThrows(IllegalArgumentException.class, () -> {
           userValidationModule.registerUser(user);
        });
    }

    @Test
    void registerUser_passwordWithNoSpecialCharsWhenRuleIsSpecialCharsMandatory_throws()
    {
        userValidationModule.addValidationRule(passwordValidation);
        user.setPassword("FranziManzi06");
        assertThrows(IllegalArgumentException.class, () -> {
            userValidationModule.registerUser(user);
        });
    }

    @Test
    void registerUser_passwordWithNoNumbersWhenRuleIsNumbersRequired_throws()
    {
        userValidationModule.addValidationRule(passwordValidation);
        user.setPassword("FranziManzi_");
        assertThrows(IllegalArgumentException.class, () -> {
            userValidationModule.registerUser(user);
        });
    }

    @Test
    void registerUser_passwordWithNoLowercaseWhenRuleIsLowercaseRequired_throws()
    {
        userValidationModule.addValidationRule(passwordValidation);
        user.setPassword("FRANZIMANZI06_");
        assertThrows(IllegalArgumentException.class, () -> {
            userValidationModule.registerUser(user);
        });
    }

    @Test
    void registerUser_passwordWithNoUppercaseWhenRuleIsUppercaseRequired_throws()
    {
        userValidationModule.addValidationRule(passwordValidation);
        user.setPassword("franzimanzi06_");
        assertThrows(IllegalArgumentException.class, () -> {
            userValidationModule.registerUser(user);
        });
    }

}
