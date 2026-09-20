package com.nhlstenden.appstores;

import java.util.List;

public class GooglePlayStore extends AppStore
{
    public GooglePlayStore(String currency)
    {
        super(currency);
    }

    @Override
    public void uploadApp(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("App cannot be null");
        }
        for (App existingApp : getApps())
        {
            if(app.equals(existingApp))
            {
                throw new IllegalArgumentException("App already uploaded");
            }
        }

        List<App> apps = getApps();
        apps.add(app);
        setApps(apps);
    }
}
