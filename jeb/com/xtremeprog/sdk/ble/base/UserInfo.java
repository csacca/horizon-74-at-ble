package com.xtremeprog.sdk.ble.base;

public class UserInfo {
    private int acceptedTerms;
    private int age;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private int desiredDisplayUnits;
    private int gender;
    private String passcode;
    private int shareWorkoutData;
    private int userId;
    private int userLanguageId;
    private String userName;
    private int userWeightX10;
    private String xID;

    public UserInfo() {
    }

    public UserInfo(int arg1, String arg2, String arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, String arg12, int arg13, int arg14) {
        this.userId = arg1;
        this.xID = arg2;
        this.passcode = arg3;
        this.gender = arg4;
        this.userWeightX10 = arg5 * 10;
        this.age = arg6;
        this.birthYear = arg7;
        this.birthMonth = arg8;
        this.birthDay = arg9;
        this.userLanguageId = arg10;
        this.desiredDisplayUnits = arg11;
        this.userName = arg12;
        this.acceptedTerms = arg13;
        this.shareWorkoutData = arg14;
    }

    public int getAcceptedTerms() {
        return this.acceptedTerms;
    }

    public int getAge() {
        return this.age;
    }

    public int getBirthDay() {
        return this.birthDay;
    }

    public int getBirthMonth() {
        return this.birthMonth;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public int getDesiredDisplayUnits() {
        return this.desiredDisplayUnits;
    }

    public int getGender() {
        return this.gender;
    }

    public String getPasscode() {
        return this.passcode;
    }

    public int getShareWorkoutData() {
        return this.shareWorkoutData;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getUserLanguageId() {
        return this.userLanguageId;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getUserWeightX10() {
        return this.userWeightX10;
    }

    public String getxID() {
        return this.xID;
    }

    public void setAcceptedTerms(int arg1) {
        this.acceptedTerms = arg1;
    }

    public void setAge(int arg1) {
        this.age = arg1;
    }

    public void setBirthDay(int arg1) {
        this.birthDay = arg1;
    }

    public void setBirthMonth(int arg1) {
        this.birthMonth = arg1;
    }

    public void setBirthYear(int arg1) {
        this.birthYear = arg1;
    }

    public void setDesiredDisplayUnits(int arg1) {
        this.desiredDisplayUnits = arg1;
    }

    public void setGender(int arg1) {
        this.gender = arg1;
    }

    public void setPasscode(String arg1) {
        this.passcode = arg1;
    }

    public void setShareWorkoutData(int arg1) {
        this.shareWorkoutData = arg1;
    }

    public void setUserId(int arg1) {
        this.userId = arg1;
    }

    public void setUserLanguageId(int arg1) {
        this.userLanguageId = arg1;
    }

    public void setUserName(String arg1) {
        this.userName = arg1;
    }

    public void setUserWeightX10(int arg1) {
        this.userWeightX10 = arg1;
    }

    public void setxID(String arg5) {
        if(arg5.length() < 14) {
            int v0;
            for(v0 = arg5.length(); v0 < 14; ++v0) {
                arg5 = "0" + arg5;
            }
        }

        this.xID = arg5;
    }

    @Override
    public String toString() {
        return "UserInfo [userId=" + this.userId + ", xID=" + this.xID + ", passcode=" + this.passcode + ", gender=" + this.gender + ", userWeightX10=" + this.userWeightX10 + ", age=" + this.age + ", birthYear=" + this.birthYear + ", birthMonth=" + this.birthMonth + ", birthDay=" + this.birthDay + ", userLanguageId=" + this.userLanguageId + ", desiredDisplayUnits=" + this.desiredDisplayUnits + ", userName=" + this.userName + ", acceptedTerms=" + this.acceptedTerms + ", shareWorkoutData=" + this.shareWorkoutData + "]";
    }
}
