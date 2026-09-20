package com.nhlstenden.appstores;

import java.util.List;

public class AppleAppStore extends AppStore
{
    public AppleAppStore(String currency)
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
        if (app.hasNudity())
        {
            throw new IllegalArgumentException("Cannot upload an app which contains nudity");
        }

        List<App> apps = getApps();
        apps.add(app);
        setApps(apps);
    }
}
