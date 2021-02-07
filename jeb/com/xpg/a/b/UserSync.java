package com.xpg.a.b;

public class UserSync {
    private int userSlot;
    private String userName;
    private int userWeight;
    private int userBirthYear;
    private int userBirthMonth;
    private int userBirthDay;
    private int units;
    private int customProgramCRC;
    private int customHeartrateCRC;
    private int myFirst5kWeek;
    private int myFirst5kWorkout;
    private int myFirst5kWalkSpeed;
    private int myFirst5kJogSpeed;
    private int myFirst5kResetCounter;
    private String MMFTokenId;
    private String MFPTokenId;
    private String MFP_UserId;
    private String FitbitToken;

    public int getUserSlot() {
        return this.userSlot;
    }

    public void setUserSlot(int arg1) {
        this.userSlot = arg1;
    }

    public void setUserName(String arg1) {
        this.userName = arg1;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserWeight(int arg1) {
        this.userWeight = arg1;
    }

    public void setMMFTokenId(String arg1) {
        this.MMFTokenId = arg1;
    }

    public int getUserWeight() {
        return this.userWeight;
    }

    public void setUserBirthYear(int arg1) {
        this.userBirthYear = arg1;
    }

    public void setMFPTokenId(String arg1) {
        this.MFPTokenId = arg1;
    }

    public int getUserBirthYear() {
        return this.userBirthYear;
    }

    public void setUserBirthMonth(int arg1) {
        this.userBirthMonth = arg1;
    }

    public void setMFP_UserId(String arg1) {
        this.MFP_UserId = arg1;
    }

    public int getUserBirthMonth() {
        return this.userBirthMonth;
    }

    public void setUserBirthDay(int arg1) {
        this.userBirthDay = arg1;
    }

    public void setFitbitToken(String arg1) {
        this.FitbitToken = arg1;
    }

    public int getUserBirthday() {
        return this.userBirthDay;
    }

    public void setUnits(int arg1) {
        this.units = arg1;
    }

    public int getUnits() {
        return this.units;
    }

    public void setCustomProgramCRC(int arg1) {
        this.customProgramCRC = arg1;
    }

    public int getCustomProgramCRC() {
        return this.customProgramCRC;
    }

    public void setCustomHeartrateCRC(int arg1) {
        this.customHeartrateCRC = arg1;
    }

    public int getCustomHeartrateCRC() {
        return this.customHeartrateCRC;
    }

    public void setMyFirst5kWeek(int arg1) {
        this.myFirst5kWeek = arg1;
    }

    public int getMyFirst5kWeek() {
        return this.myFirst5kWeek;
    }

    public void setMyFirst5kWorkout(int arg1) {
        this.myFirst5kWorkout = arg1;
    }

    public int getMyFirst5kWorkout() {
        return this.myFirst5kWorkout;
    }

    public void setMyFirst5kWalkSpeed(int arg1) {
        this.myFirst5kWalkSpeed = arg1;
    }

    public int getMyFirst5kWalkSpeed() {
        return this.myFirst5kWalkSpeed;
    }

    public void setMyFirst5kJogSpeed(int arg1) {
        this.myFirst5kJogSpeed = arg1;
    }

    public int getMyFirst5kJogSpeed() {
        return this.myFirst5kJogSpeed;
    }

    public void setMyFirst5kResetCounter(int arg1) {
        this.myFirst5kResetCounter = arg1;
    }

    public int getMyFirst5kResetCounter() {
        return this.myFirst5kResetCounter;
    }

    public String getMMFTokenId() {
        return this.MMFTokenId;
    }

    public String getMFPTokenId() {
        return this.MFPTokenId;
    }

    public String getMFP_UserId() {
        return this.MFP_UserId;
    }

    public String getFitbitToken() {
        return this.FitbitToken;
    }

    @Override
    public String toString() {
        return "UserSync [userSlot=" + this.userSlot + ", userName=" + this.userName + ", userWeight=" + this.userWeight + ", userBirthYear=" + this.userBirthYear + ", userBirthMonth=" + this.userBirthMonth + ", userBirthDay=" + this.userBirthDay + ", units=" + this.units + ", customProgramCRC=" + this.customProgramCRC + ", customHeartrateCRC=" + this.customHeartrateCRC + ", myFirst5kWeek=" + this.myFirst5kWeek + ", myFirst5kWorkout=" + this.myFirst5kWorkout + ", myFirst5kWalkSpeed=" + this.myFirst5kWalkSpeed + ", myFirst5kJogSpeed=" + this.myFirst5kJogSpeed + ", myFirst5kResetCount=" + this.myFirst5kResetCounter + ", MMFTokenID=" + this.MMFTokenId + ", MFPTokenID=" + this.MFPTokenId + ",MFP_UserId=" + this.MFP_UserId + ", FitbitToken=" + this.FitbitToken + "]";
    }
}
