package com.github.kazy1991.prefkit.sample;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.github.kazy1991.prefkit.PrefKit;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        PrefKit prefKit = new PrefKit(this);
        SampleSchema samplePrefStore = prefKit.create(SampleSchema.class);
        samplePrefStore.setWelcomeDialogFlag(true);
        samplePrefStore.getWelcomeDialogFlag(false);
    }
}
