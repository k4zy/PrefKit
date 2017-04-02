package com.github.kazy1991.prefkit;


import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static com.github.kazy1991.prefkit.TestSchema.booleanKey;
import static com.github.kazy1991.prefkit.TestSchema.floatKey;
import static com.github.kazy1991.prefkit.TestSchema.integerKey;
import static com.github.kazy1991.prefkit.TestSchema.longKey;
import static com.github.kazy1991.prefkit.TestSchema.stringKey;
import static org.assertj.core.api.Java6Assertions.assertThat;


@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class PrefKitTest {

    private TestSchema schema;
    private SharedPreferences pref;
    private final static String schemaName = "TestSchema";

    @Before
    public void before() {
        Context context = ShadowApplication.getInstance().getApplicationContext();
        PrefKit prefKit = new PrefKit(context);
        schema = prefKit.create(TestSchema.class);
        pref = context.getSharedPreferences(schemaName, Context.MODE_PRIVATE);
    }

    @Test
    public void putStringTest() throws Exception {
        schema.putStringValue("test");
        assertThat(pref.getString(stringKey, null)).isEqualTo("test");
    }

    @Test
    public void getStringTest() throws Exception {
        pref.edit().putString(stringKey, "test").commit();
        assertThat(schema.getStringValue(null)).isEqualTo("test");
    }

    @Test
    public void putIntegerTest() throws Exception {
        schema.putIntegerValue(100);
        assertThat(pref.getInt(integerKey, -1)).isEqualTo(100);
    }

    @Test
    public void getIntegerTest() throws Exception {
        pref.edit().putInt(integerKey, 100).commit();
        assertThat(schema.getIntegerValue(-1)).isEqualTo(100);
    }

    @Test
    public void putLongTest() throws Exception {
        schema.putLongValue(100L);
        assertThat(pref.getLong(longKey, -1L)).isEqualTo(100L);
    }

    @Test
    public void getLongTest() throws Exception {
        pref.edit().putLong(longKey, 100L).commit();
        assertThat(schema.getLongValue(-1L)).isEqualTo(100L);
    }

    @Test
    public void putFloatTest() throws Exception {
        schema.putFloatValue(1.5f);
        assertThat(pref.getFloat(floatKey, 0.1f)).isEqualTo(1.5f);
    }

    @Test
    public void getFloatTest() throws Exception {
        pref.edit().putFloat(floatKey, 1.5f).commit();
        assertThat(schema.getFloatValue(0.1f)).isEqualTo(1.5f);
    }

    @Test
    public void putBooleanTest() throws Exception {
        schema.putBooleanValue(true);
        assertThat(pref.getBoolean(booleanKey, false)).isTrue();
    }

    @Test
    public void getBooleanTest() throws Exception {
        pref.edit().putBoolean(booleanKey, true).commit();
        assertThat(schema.getBooleanValue(false)).isTrue();
    }

}
