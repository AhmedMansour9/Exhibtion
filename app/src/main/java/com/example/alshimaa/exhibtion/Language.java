package com.example.alshimaa.exhibtion;

import java.util.Locale;

/**
 * Created by ic on 9/26/2018.
 */

public class Language {

    public static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }

    public static boolean isRTL() {
        return isRTL(Locale.getDefault());
    }

}
