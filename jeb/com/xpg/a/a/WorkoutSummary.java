package com.xpg.a.a;

import java.io.Serializable;
import java.util.List;

public class WorkoutSummary implements Serializable {
    private String userName;
    private int userId;
    private String MFPUserId;
    private String MMFTokenId;
    private String MFPTokenId;
    private String FitbitToken;
    private int workoutsCounter;
    private List workoutInfoList;

    public String getUserName() {
        return this.userName;
    }

    public void setUserId(int arg1) {
        this.userId = arg1;
    }

    public void setUserName(String arg1) {
        this.userName = arg1;
    }

    public void setWorkoutInfoList(List arg1) {
        this.workoutInfoList = arg1;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setWorkoutsCounter(int arg1) {
        this.workoutsCounter = arg1;
    }

    public void setMMFTokenId(String arg1) {
        this.MMFTokenId = arg1;
    }

    public String getMMFTokenId() {
        return this.MMFTokenId;
    }

    public void setMFPTokenId(String arg1) {
        this.MFPTokenId = arg1;
    }

    public String getMFPTokenId() {
        return this.MFPTokenId;
    }

    public void setMFPUserId(String arg1) {
        this.MFPUserId = arg1;
    }

    public List getWorkoutInfoList() {
        return this.workoutInfoList;
    }

    public void setFitbitToken(String arg1) {
        this.FitbitToken = arg1;
    }

    public String getMFP_UserId() {
        return this.MFPUserId;
    }

    public String getFitbitToken() {
        return this.FitbitToken;
    }

    @Override
    public String toString() {
        return "WorkoutSummary [userName=" + this.userName + ", userId=" + this.userId + ", MMFTokenId=" + this.MMFTokenId + ", MFPTokenID=" + this.MFPTokenId + ", workoutsCounter=" + this.workoutsCounter + ", workoutInfoList=" + this.workoutInfoList + ", FitbitToken=" + this.FitbitToken + "]";
    }
}
