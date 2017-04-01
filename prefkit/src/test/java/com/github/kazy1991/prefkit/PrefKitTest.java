package com.github.kazy1991.prefkit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;


@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class PrefKitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        PrefKit prefKit = new PrefKit(ShadowApplication.getInstance().getApplicationContext());
        TestSchema schema = prefKit.create(TestSchema.class);
        schema.getSampleValue(false);
        schema.setSampleValue(true);
    }
}
