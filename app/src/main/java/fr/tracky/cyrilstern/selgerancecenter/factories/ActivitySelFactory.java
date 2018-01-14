package fr.tracky.cyrilstern.selgerancecenter.factories;

import android.content.Intent;

import fr.tracky.cyrilstern.selgerancecenter.AccountActivity;
import fr.tracky.cyrilstern.selgerancecenter.LoginActivity;
import fr.tracky.cyrilstern.selgerancecenter.entities.FactoryType;

/**
 * Created by cyrilstern1 on 12/01/2018.
 */

public abstract class ActivitySelFactory {
    private LoginActivity loginActivity;

    public static String activity(String activityName) {

        if (activityName.equals(FactoryType.ACCOUNT_CONSULTATION.getActivityName())) {
            return AccountActivity.class.getName();
        }
        if (activityName.equals(FactoryType.PHONE_CALL.getActivityName())) {
            return Intent.ACTION_VIEW;
        }
        if (activityName.equals(FactoryType.SMS_SEND.getActivityName())) {
            return Intent.ACTION_SENDTO;
        }
        if (activityName.equals(FactoryType.SINISTER_DECLARATION.getActivityName())) {
            String application = Intent.ACTION_CALL;
            return LoginActivity.class.getName();
        }
        return null;
    }
}
