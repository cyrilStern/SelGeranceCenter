package fr.tracky.cyrilstern.selgerancecenter.viewAdaptateur;

/**
 * Created by cyrilstern1 on 11/01/2018.
 */

public class CardApplication {
    private int backGroundImageRight;
    private String BackgroundColorRight;
    private String textApplicationRight;

    private int backGroundImageLeft;
    private String BackgroundColorLeft;
    private String textApplicationLeft;

    public CardApplication(int backGroundImageRight, String backgroundColorRight, String textApplicationRight, int backGroundImageLeft, String backgroundColorLeft, String textApplicationLeft) {
        this.backGroundImageRight = backGroundImageRight;
        BackgroundColorRight = backgroundColorRight;
        this.textApplicationRight = textApplicationRight;
        this.backGroundImageLeft = backGroundImageLeft;
        BackgroundColorLeft = backgroundColorLeft;
        this.textApplicationLeft = textApplicationLeft;
    }

    public CardApplication() {
    }

    public int getBackGroundImageRight() {
        return backGroundImageRight;
    }

    public void setBackGroundImageRight(int backGroundImageRight) {
        this.backGroundImageRight = backGroundImageRight;
    }

    public String getBackgroundColorRight() {
        return BackgroundColorRight;
    }

    public void setBackgroundColorRight(String backgroundColorRight) {
        BackgroundColorRight = backgroundColorRight;
    }

    public String getTextApplicationRight() {
        return textApplicationRight;
    }

    public void setTextApplicationRight(String textApplicationRight) {
        this.textApplicationRight = textApplicationRight;
    }

    public int getBackGroundImageLeft() {
        return backGroundImageLeft;
    }

    public void setBackGroundImageLeft(int backGroundImageLeft) {
        this.backGroundImageLeft = backGroundImageLeft;
    }

    public String getBackgroundColorLeft() {
        return BackgroundColorLeft;
    }

    public void setBackgroundColorLeft(String backgroundColorLeft) {
        BackgroundColorLeft = backgroundColorLeft;
    }

    public String getTextApplicationLeft() {
        return textApplicationLeft;
    }

    public void setTextApplicationLeft(String textApplicationLeft) {
        this.textApplicationLeft = textApplicationLeft;
    }
}
