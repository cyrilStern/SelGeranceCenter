package fr.tracky.cyrilstern.selgerancecenter.entities;

/**
 * Created by cyrilstern1 on 12/01/2018.
 */

public enum FactoryType {
    ACCOUNT_CONSULTATION("ACCOUNT_CONSULTATIONS"),
    SINISTER_DECLARATION("SINISTER_DECLARATION"),
    PHONE_CALL("PHONE_CALL"),
    MAIL_SEND("MAIL_SEND"),
    SMS_SEND("SMS_SEND");
    private String activityName;

    FactoryType(String activityName) {
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
