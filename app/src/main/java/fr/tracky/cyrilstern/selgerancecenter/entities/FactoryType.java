package fr.tracky.cyrilstern.selgerancecenter.entities;

import android.content.Intent;

import fr.tracky.cyrilstern.selgerancecenter.AccountActivity;

/**
 * Created by cyrilstern1 on 12/01/2018.
 */

public enum FactoryType {
    ACCOUNT_CONSULTATION("ACCOUNT_CONSULTATIONS", "ACTIVITY", AccountActivity.class.getName()),
    SINISTER_DECLARATION("SINISTER_DECLARATION", "ACTIVITY", AccountActivity.class.getName()),
    PHONE_CALL("PHONE_CALL", "INTENT", Intent.ACTION_CALL),
    MAIL_SEND("MAIL_SEND", "INTENT", Intent.ACTION_SEND),
    SMS_SEND("SMS_SEND", "INTENT", Intent.ACTION_VIEW);
    private String activityName;

    FactoryType(String activityName, String type, String path) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return this.activityName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
