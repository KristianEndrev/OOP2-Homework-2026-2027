package com.nhlstenden.appstores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AppStoreTest
{
    private AppleAppStore appleAppStore;
    private GooglePlayStore googlePlayStore;
    private App app;
    private App app1;
    private User user;
    private User user1;
    private EmailValidator emailValidator;

    @BeforeEach
    void setUp()
    {
        appleAppStore = new AppleAppStore("euro");
        googlePlayStore = new GooglePlayStore("dollar");
        app = new App("Shadow fight", 200, true, false);
        app1 = new App("Clash Royale", 200, false, false);
        user = new User("Franzkata", "franz@gmail.com", LocalDate.now().minusYears(20));
        user1 = new User("Juleto", "juletobebraat@gmal.com", LocalDate.now().minusYears(20));
        emailValidator = new EmailValidator();
        appleAppStore.uploadApp(app);
        appleAppStore.uploadApp(app1);
    }

    @Test
    void purchaseApp_properValues_notToThrow()
    {
        assertDoesNotThrow(() -> appleAppStore.purchaseApp(user, app));
    }

    @Test
    void purchaseApp_underagedUser_throws()
    {
        user.setDateOfBirth(LocalDate.of(2015, 5, 29));
        assertThrows(DownloadNotAllowedException.class, () -> {
           appleAppStore.purchaseApp(user, app);
        });
    }

    @Test
    void totalRevenue_purchaseOfAppSuccessful_equals140()
    {
        appleAppStore.purchaseApp(user, app);
        assertEquals(140, appleAppStore.getTotalRevenueInCents());
    }

    @Test
    void uploadApp_appWithNudityForAppleAppStore_throws()
    {
        app.setNudity(true);
        assertThrows(IllegalArgumentException.class, () -> {
            appleAppStore.uploadApp(app);
        });
    }

    @Test
    void getRevenueOfAppInCents_purchaseTheGameTwice_equals280()
    {
        appleAppStore.purchaseApp(user, app);
        appleAppStore.purchaseApp(user1, app);
        assertEquals(280, appleAppStore.getRevenueOfAppInCents(app));
    }

    @Test
    void checkForDuplicatePurchase_userAttemptsSecondPurchase_throws()
    {
        appleAppStore.purchaseApp(user, app);
        assertThrows(IllegalArgumentException.class, () -> appleAppStore.purchaseApp(user, app));
    }
}
