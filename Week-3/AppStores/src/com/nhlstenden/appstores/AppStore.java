package com.nhlstenden.appstores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AppStore
{
    private static final int CEDE_REVENUE_TO_DEV_IN_PERCENT = 30;
    private static final int AGE_RESTRICTION_VIOLENCE = 16;
    private static final int AGE_RESTRICTION_NUDITY = 18;
    private static final String EURO_CURRENCY = "euro";
    private static final String DOLLAR_CURRENCY = "dollar";
    private String currency;
    private int totalRevenueInCents;
    private List<App> apps;
    private List<User> users;
    private List<Purchase> purchases;
    private Map<String, Integer> appRevenueInCents;

    public AppStore(String currency)
    {
        this.setCurrency(currency);
        this.setTotalRevenueInCents(0);
        this.setApps(new ArrayList<>());
        this.setUsers(new ArrayList<>());
        this.setPurchases(new ArrayList<>());
        this.setAppRevenueInCents(new HashMap<>());
    }

    public String getCurrency()
    {
        return this.currency;
    }

    public void setCurrency(String currency)
    {
        if (currency == null || currency.isBlank())
        {
            throw new IllegalArgumentException("currency cannot be null or blank");
        }
        if (!currency.equalsIgnoreCase(EURO_CURRENCY) && !currency.equalsIgnoreCase(DOLLAR_CURRENCY))
        {
            throw new IllegalArgumentException("Currency can only be euro or dollar");
        }

        this.currency = currency;
    }

    public int getTotalRevenueInCents()
    {
        return this.totalRevenueInCents;
    }

    public void setTotalRevenueInCents(int totalRevenueInCents)
    {
        if (totalRevenueInCents < 0)
        {
            throw new IllegalArgumentException("Revenue in cents cannot be negative");
        }

        this.totalRevenueInCents = totalRevenueInCents;
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

    public List<Purchase> getPurchases()
    {
        return new ArrayList<>(this.purchases);
    }

    public void setPurchases(List<Purchase> purchases)
    {
        if (purchases == null)
        {
            throw new IllegalArgumentException("purchases cannot be null");
        }

        for (Purchase purchase : purchases)
        {
            if (purchase == null)
            {
                throw new IllegalArgumentException("A purchase cannot be null");
            }
        }

        this.purchases = new ArrayList<>(purchases);
    }

    public Map<String, Integer> getAppRevenueInCents()
    {
        return new HashMap<>(this.appRevenueInCents);
    }

    public void setAppRevenueInCents(Map<String, Integer> appRevenueInCents)
    {
        if (appRevenueInCents == null)
        {
            throw new IllegalArgumentException("App revenue in cents cannot be null");
        }
        for (String string : appRevenueInCents.keySet())
        {
            if (string.isBlank())
            {
                throw new IllegalArgumentException("The name of the app cannot be blank");
            }
        }
        for (Integer integer : appRevenueInCents.values())
        {
            if (integer < 0)
            {
                throw new IllegalArgumentException("The price of the app cannot be negative");
            }
        }

        this.appRevenueInCents = appRevenueInCents;
    }

    public abstract void uploadApp(App app);

    public void purchaseApp(User user, App app)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (app == null)
        {
            throw new IllegalArgumentException("App cannot be null");
        }
        checkAppExistence(app);
        checkForDuplicatePurchase(user, app);
        verifyAge(user, app);
        downloadApp(user, app);
        totalRevenueInCents += getPriceAfterCededRevenueInCents(app);
        if (appRevenueInCents.containsKey(app.getName()))
        {
            int temp = appRevenueInCents.get(app.getName());
            temp += getPriceAfterCededRevenueInCents(app);
            appRevenueInCents.put(app.getName(), temp);
        }
        else
        {
            appRevenueInCents.put(app.getName(), getPriceAfterCededRevenueInCents(app));
        }
        Purchase purchase = new Purchase(user, app);
        purchases.add(purchase);
    }

    public void verifyAge(User user, App app)
    {
        int userAge = user.getAge();
        if (app.hasViolence() && userAge < AGE_RESTRICTION_VIOLENCE)
        {
            throw new DownloadNotAllowedException("App contains violence. You must be 16 years or older.");
        }
        if (app.hasNudity() && userAge < AGE_RESTRICTION_NUDITY)
        {
            throw new DownloadNotAllowedException("App contains nudity. You must be 18 years or older");
        }
    }

    public int getPriceAfterCededRevenueInCents(App app)
    {
        int cededAmount = app.getPriceInCents() * CEDE_REVENUE_TO_DEV_IN_PERCENT / 100;
        return app.getPriceInCents() - cededAmount;
    }

    public void downloadApp(User user, App app)
    {
        user.addApp(app);
    }

    public int getRevenueOfAppInCents(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("App cannot be null");
        }
        if (!appRevenueInCents.containsKey(app.getName()))
        {
            throw new IllegalArgumentException("App has no revenue");
        }

        return appRevenueInCents.get(app.getName());
    }

    public void checkAppExistence(App app)
    {
        boolean appExists = false;
        for (App existingApp : apps)
        {
            if (app.equals(existingApp))
            {
                appExists = true;
                break;
            }
        }
        if (!appExists)
        {
            throw new IllegalArgumentException("App not found in this App Store");
        }
    }

    public void checkForDuplicatePurchase(User user, App app)
    {
        if (user.getApps().contains(app))
        {
            throw new IllegalArgumentException("User has already purchased this app");
        }
    }

}
