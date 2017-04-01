package com.github.kazy1991.prefkit.sample;


import com.github.kazy1991.prefkit.annotation.PrefKey;
import com.github.kazy1991.prefkit.annotation.PrefSchema;

@PrefSchema("SampleSchema")
interface SampleSchema {

    String WELCOME_DIALOG = "welcome_dialog";

    @PrefKey(WELCOME_DIALOG)
    void setWelcomeDialogFlag(boolean value);

    @PrefKey(WELCOME_DIALOG)
    boolean getWelcomeDialogFlag(boolean defaultValue);
}
