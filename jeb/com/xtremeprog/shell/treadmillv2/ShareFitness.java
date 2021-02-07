package com.xtremeprog.shell.treadmillv2;

import android.content.Context;
import android.content.Intent;
import android.webkit.CookieManager;
import apps.c.ContextSharedPreferences;
import apps.c.d;
import apps.c.j;
import apps.c.m.a;
import apps.c.m.b;
import apps.c.m;
import apps.c.o;
import apps.database.c;
import apps.vo.AppsArticle;
import com.xpg.d.logger_maybe;

public class ShareFitness {
    private static Context ctx;
    private static ShareFitness s_instance;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    static {
    }

    private ShareFitness() {
        this.c = 0;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
    }

    public static ShareFitness get(Context ctx) {
        ShareFitness.ctx = ctx;
        if(ShareFitness.s_instance == null) {
            ShareFitness.s_instance = new ShareFitness();
        }

        return ShareFitness.s_instance;
    }

    public int a() {
        return this.c;
    }

    public String a(String arg5) {
        int v0 = this.c;
        if(v0 == 0) {
            this.d = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_Token_Key_" + arg5, "", 5);
            return this.d;
        }

        if(v0 == 1) {
            this.e = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_Token_Key_" + arg5, "", 5);
            return this.e;
        }

        if(v0 == 2) {
            this.f = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_FitBit_Token_Key_" + arg5, "", 5);
            return this.f;
        }

        return "";
    }

    public void a(int arg1) {
        this.c = arg1;
    }

    public void a(Context arg5, String arg6, int arg7) {
        if(!d.d(arg5)) {
            j.a("==MMF refreh token无网络==" + arg7, "==不刷新==" + arg6);
            return;
        }

        String v0 = this.e(arg6);
        if(!d.strNotEmpty(v0) && !d.a(v0, "0000000000000000000000000000000000000000")) {
            j.a("==MMF refresh token不为空==" + arg7, "==要刷新==" + arg6);
            if(c.a().a(arg5).size() > 0) {
                j.a("==mmfList size > 0==" + arg7, "==不refresh token==" + arg6);
                return;
            }

            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().b("55xtz5n5kmdphxxsmbvgn68byrvnqbxj", "t8WV9adqUT6D47yvqd9gFu65MZUFcNKWtNwC9GCHJG6", v0);
                    return d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg6) {
                    String v0 = "";
                    if(arg6 != null) {
                        try {
                            AppsArticle v6_1 = (AppsArticle)arg6;
                            v0 = v6_1.getAccess_token();
                            String v1 = v6_1.getRefresh_token();
                            String v6_2 = v6_1.getUser_id();
                            ShareFitness.get(arg5).h(v6_2, arg6 + "");
                            ShareFitness.get(arg5).k(v0, arg6 + "");
                            ShareFitness.get(arg5).e(v1, arg6 + "");
                            j.a("==mmf refresh token success==" + arg7, v0 + " |");
                        }
                        catch(Exception v6) {
                            v6.printStackTrace();
                        }
                    }

                    if(d.strNotEmpty(v0)) {
                        int v6_3 = arg7;
                        if(v6_3 < 5) {
                            ShareFitness.this.a(arg5, arg6, v6_3 + 1);
                            return;
                        }

                        j.a("==超过5次refreshMMFToken失败==", "===");
                        Intent v6_4 = new Intent();
                        v6_4.putExtra("userId", arg6 + "");
                        v6_4.setAction("NOTIFICATION_REFRESH_MMF_TOKEN_FAILED_5_TIMES");
                        AppsRunner.get(arg5).a().sendBroadcast(v6_4);
                    }
                }
            });
            return;
        }

        j.a("==MMF refresh token为空==" + arg7, "==不刷新==" + arg6);
    }

    public void a(Context arg5, String arg6, com.xtremeprog.shell.treadmillv2.AppsApplication.a arg7) {
        if(!d.d(arg5)) {
            j.a("==MMF refreh token无网络==", "==不刷新==" + arg6);
            if(arg7 != null) {
                arg7.a();
            }

            return;
        }

        String v0 = this.e(arg6);
        if(!d.strNotEmpty(v0) && !d.a(v0, "0000000000000000000000000000000000000000")) {
            j.a("==MMF refresh token不为空==", "==要刷新==" + arg6);
            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().b("55xtz5n5kmdphxxsmbvgn68byrvnqbxj", "t8WV9adqUT6D47yvqd9gFu65MZUFcNKWtNwC9GCHJG6", v0);
                    return d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg6) {
                    String v0 = "";
                    if(arg6 != null) {
                        try {
                            AppsArticle v6_1 = (AppsArticle)arg6;
                            v0 = v6_1.getAccess_token();
                            String v1 = v6_1.getRefresh_token();
                            String v6_2 = v6_1.getUser_id();
                            ShareFitness.get(arg5).h(v6_2, arg6 + "");
                            ShareFitness.get(arg5).k(v0, arg6 + "");
                            ShareFitness.get(arg5).e(v1, arg6 + "");
                            j.a("==mmf refresh token success==", v0 + " |");
                        }
                        catch(Exception v6) {
                            v6.printStackTrace();
                        }
                    }

                    com.xtremeprog.shell.treadmillv2.AppsApplication.a v6_3 = arg7;
                    if(v6_3 != null) {
                        v6_3.a();
                        if(d.strNotEmpty(v0)) {
                            arg7.b();
                        }
                    }
                }
            });
            return;
        }

        j.a("==MMF refresh token为空==", "==不刷新==" + arg6);
        if(arg7 != null) {
            arg7.a();
        }
    }

    public void a(String arg6, int arg7) {
        String v1;
        String v6;
        Context v7;
        if(arg7 == -1) {
            ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_ExpireTime_Key_" + arg6, Integer.valueOf(0), 1);
            v7 = ShareFitness.ctx;
            v6 = "ShareFitnessType_MapMyFitness_ExpireTime_Date_Key_" + arg6;
            v1 = "";
        }
        else {
            ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_ExpireTime_Key_" + arg6, Integer.valueOf(0), 1);
            v7 = ShareFitness.ctx;
            v6 = "ShareFitnessType_MapMyFitness_ExpireTime_Date_Key_" + arg6;
            v1 = "2021-02-07 10:53:48";
        }

        ContextSharedPreferences.SharedPreferencesEditor(v7, v6, v1, 5);
    }

    public void setPrefsMyFitnessPalTokenKey(String arg4, String arg5) {
        this.e = arg4;
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_Token_Key_" + arg5, arg4, 5);
    }

    public String getPrefsMapMyFitnessTokenKey(String arg4) {
        String v4 = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_Token_Key_" + arg4, "", 5);
        return d.strNotEmpty(v4) ? "" : v4;
    }

    public void b() {
        try {
            CookieManager v0_1 = CookieManager.getInstance();
            v0_1.removeSessionCookie();
            v0_1.removeExpiredCookie();
            v0_1.removeAllCookie();
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }
    }

    public void b(Context arg6, String arg7, int arg8) {
        if(!d.d(arg6)) {
            j.a("==MFP refreh token无网络==" + arg8, "==不刷新==" + arg7);
            return;
        }

        String v0 = this.getPrefsMFP_UserId(arg7);
        String v1 = this.f(arg7);
        if(!d.strNotEmpty(v0) && !d.a(v0, "000000000000000") && !d.strNotEmpty(v1) && !d.a(v1, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            j.a("==MFP refresh token不为空==" + arg8, "==要刷新==" + arg7);
            if(c.a().b(arg6).size() > 0) {
                j.a("==mfpList size > 0==" + arg8, "==不refresh token==" + arg7);
                return;
            }

            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().c("afgfitness", "c7e6915ed48f7befbaa3", v1, v0);
                    return d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg7) {
                    String v0 = "";
                    if(arg7 != null) {
                        try {
                            AppsArticle v7_1 = (AppsArticle)arg7;
                            v0 = v7_1.getAccess_token();
                            String v1 = v7_1.getRefresh_token();
                            String v2 = v7_1.getUser_id();
                            String v7_2 = v7_1.getExpires_in();
                            ShareFitness.get(arg6).l(v0, arg7 + "");
                            ShareFitness.get(arg6).d(v1, arg7 + "");
                            ShareFitness.get(arg6).setPrefsMFP_UserId(v2, arg7 + "");
                            ShareFitness.get(arg6).b(arg7 + "", d.a(v7_2, 0).intValue());
                            j.a("==mfp refresh_token success==", v0 + " | " + v1 + " | " + arg7);
                        }
                        catch(Exception v7) {
                            v7.printStackTrace();
                        }
                    }

                    if(d.strNotEmpty(v0)) {
                        int v7_3 = arg8;
                        if(v7_3 < 5) {
                            ShareFitness.this.b(arg6, arg7, v7_3 + 1);
                            return;
                        }

                        j.a("==超过5次refresshMFPToken失败==", "==");
                        Intent v7_4 = new Intent();
                        v7_4.putExtra("userId", arg7 + "");
                        v7_4.setAction("NOTIFICATION_REFRESH_MFP_TOKEN_FAILED_5_TIMES");
                        AppsRunner.get(arg6).a().sendBroadcast(v7_4);
                    }
                }
            });
            return;
        }

        j.a("==MFP refresh token为空==" + arg8, "==不刷新==" + arg7);
    }

    public void b(Context arg6, String arg7, com.xtremeprog.shell.treadmillv2.AppsApplication.a arg8) {
        if(!d.d(arg6)) {
            j.a("==MFP refreh token无网络==", "==不刷新==" + arg7);
            if(arg8 != null) {
                arg8.a();
            }

            return;
        }

        String v0 = this.getPrefsMFP_UserId(arg7);
        String v1 = this.f(arg7);
        if(!d.strNotEmpty(v0) && !d.a(v0, "000000000000000") && !d.strNotEmpty(v1) && !d.a(v1, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            j.a("==MFP refresh token不为空==", "==要刷新==" + arg7);
            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().c("afgfitness", "c7e6915ed48f7befbaa3", v1, v0);
                    return d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg7) {
                    if(arg7 != null) {
                        try {
                            AppsArticle v7_1 = (AppsArticle)arg7;
                            String v0 = v7_1.getAccess_token();
                            String v1 = v7_1.getRefresh_token();
                            String v2 = v7_1.getUser_id();
                            String v7_2 = v7_1.getExpires_in();
                            ShareFitness.get(arg6).l(v0, arg7 + "");
                            ShareFitness.get(arg6).d(v1, arg7 + "");
                            ShareFitness.get(arg6).setPrefsMFP_UserId(v2, arg7 + "");
                            ShareFitness.get(arg6).b(arg7 + "", d.a(v7_2, 0).intValue());
                            j.a("==mfp refresh_token success==", v0 + " | " + v1 + " | " + arg7);
                        }
                        catch(Exception v7) {
                            v7.printStackTrace();
                        }
                    }

                    com.xtremeprog.shell.treadmillv2.AppsApplication.a v7_3 = arg8;
                    if(v7_3 != null) {
                        v7_3.a();
                    }
                }
            });
            return;
        }

        j.a("==MFP refresh token为空==", "==不刷新==" + arg7);
        if(arg8 != null) {
            arg8.a();
        }
    }

    public void b(String arg6, int arg7) {
        String v1;
        String v6;
        Context v7;
        if(arg7 == -1) {
            ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_ExpireTime_Key_" + arg6, Integer.valueOf(0), 1);
            v7 = ShareFitness.ctx;
            v6 = "ShareFitnessType_MyFitnessPal_ExpireTime_Date_Key_" + arg6;
            v1 = "";
        }
        else {
            ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_ExpireTime_Key_" + arg6, Integer.valueOf(0), 1);
            v7 = ShareFitness.ctx;
            v6 = "ShareFitnessType_MyFitnessPal_ExpireTime_Date_Key_" + arg6;
            v1 = "2021-02-07 10:53:48";
        }

        ContextSharedPreferences.SharedPreferencesEditor(v7, v6, v1, 5);
    }

    public void b(String arg4, String arg5) {
        this.d = arg4;
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_Token_Key_" + arg5, arg4, 5);
    }

    public String c() {
        logger_maybe.e("授权路径", "https://www.fitbit.com/oauth2/authorize?client_id=227WN7&response_type=code&scope=activity+nutrition+heartrate+location+nutrition+profile+settings+sleep+social+weight&redirect_uri=https://johnsondemo.herokuapp.com/authorization_callback/");
        int v0 = this.c;
        if(v0 == 0) {
            return "https://www.mapmyfitness.com/v7.1/oauth2/authorize?client_id=55xtz5n5kmdphxxsmbvgn68byrvnqbxj&response_type=code&redirect_uri=https://johnsondemo.herokuapp.com/authorization_callback/";
        }

        if(v0 == 1) {
            return "http://api.myfitnesspal.com/v2/oauth2/auth?client_id=afgfitness&response_type=code&scope=diary+measurements+private-exercises&redirect_uri=https://johnsondemo.herokuapp.com/authorization_callback/";
        }

        return v0 == 2 ? "https://www.fitbit.com/oauth2/authorize?client_id=227WN7&response_type=code&scope=activity+nutrition+heartrate+location+nutrition+profile+settings+sleep+social+weight&redirect_uri=https://johnsondemo.herokuapp.com/authorization_callback/" : "";
    }

    public String getPrefsMFPTokenId(String arg4) {
        String v4 = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_Token_Key_" + arg4, "", 5);
        return d.strNotEmpty(v4) ? "" : v4;
    }

    public void c(Context arg6, String arg7, int arg8) {
        if(!d.d(arg6)) {
            j.a("==FB refreh token无网络==" + arg8, "==不刷新==" + arg7);
            return;
        }

        String v0 = this.getPrefsFitbitUserId(arg7);
        String v1 = this.g(arg7);
        if(!d.strNotEmpty(v0) && !d.a(v0, "000000") && !d.strNotEmpty(v1) && !d.a(v1, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            j.a("==FB refresh token不为空==" + arg8, "==要刷新==" + arg7);
            if(c.a().c(arg6).size() > 0) {
                j.a("==fbList size > 0==" + arg8, "==不refresh token==" + arg7);
                return;
            }

            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().d("227WN7", "2a036801e9f03a1186a4204415354c90", v1, v0);
                    return d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg7) {
                    String v0 = "";
                    if(arg7 != null) {
                        try {
                            AppsArticle v7_1 = (AppsArticle)arg7;
                            v0 = v7_1.getAccess_token();
                            String v1 = v7_1.getRefresh_token();
                            String v2 = v7_1.getUser_id();
                            String v7_2 = v7_1.getExpires_in();
                            ShareFitness.get(arg6).m(v0, arg7 + "");
                            ShareFitness.get(arg6).f(v1, arg7 + "");
                            ShareFitness.get(arg6).i(v2, arg7 + "");
                            ShareFitness.get(arg6).c(arg7 + "", d.a(v7_2, 0).intValue());
                            j.a("==fb refresh_token success==", v0 + " | " + v1 + " | " + arg7);
                        }
                        catch(Exception v7) {
                            v7.printStackTrace();
                        }
                    }

                    if(d.strNotEmpty(v0)) {
                        int v7_3 = arg8;
                        if(v7_3 < 5) {
                            ShareFitness.this.c(arg6, arg7, v7_3 + 1);
                            return;
                        }

                        j.a("==超过5次refresshFBToken失败==", "==");
                        Intent v7_4 = new Intent();
                        v7_4.putExtra("userId", arg7 + "");
                        v7_4.setAction("NOTIFICATION_REFRESH_FB_TOKEN_FAILED_5_TIMES");
                        AppsRunner.get(arg6).a().sendBroadcast(v7_4);
                    }
                }
            });
            return;
        }

        j.a("==FB refresh token为空==" + arg8, "==不刷新==" + arg7);
    }

    public void c(Context arg6, String arg7, com.xtremeprog.shell.treadmillv2.AppsApplication.a arg8) {
        if(!d.d(arg6)) {
            j.a("==FB refreh token无网络==", "==不刷新==" + arg7);
            if(arg8 != null) {
                arg8.a();
            }

            return;
        }

        String v0 = this.getPrefsFitbitUserId(arg7);
        String v1 = this.g(arg7);
        if(!d.strNotEmpty(v0) && !d.a(v0, "000000") && !d.strNotEmpty(v1) && !d.a(v1, "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")) {
            j.a("==FB refresh token不为空==", "==要刷新==" + arg7);
            m.a(new a() {
                @Override  // apps.c.m$a
                public Object a() {
                    String v0 = o.a().d("227WN7", "2a036801e9f03a1186a4204415354c90", v1, v0);
                    return d.strNotEmpty(v0) ? null : AppsArticle.toAppsArticle(v0);
                }
            }, new b() {
                @Override  // apps.c.m$b
                public void a(Object arg7) {
                    if(arg7 != null) {
                        try {
                            AppsArticle v7_1 = (AppsArticle)arg7;
                            String v0 = v7_1.getAccess_token();
                            String v1 = v7_1.getRefresh_token();
                            String v2 = v7_1.getUser_id();
                            String v7_2 = v7_1.getExpires_in();
                            ShareFitness.get(arg6).m(v0, arg7 + "");
                            ShareFitness.get(arg6).f(v1, arg7 + "");
                            ShareFitness.get(arg6).i(v2, arg7 + "");
                            ShareFitness.get(arg6).c(arg7 + "", d.a(v7_2, 0).intValue());
                            j.a("==fb refresh_token success==", v0 + " | " + v1 + " | " + arg7);
                        }
                        catch(Exception v7) {
                            v7.printStackTrace();
                        }
                    }

                    com.xtremeprog.shell.treadmillv2.AppsApplication.a v7_3 = arg8;
                    if(v7_3 != null) {
                        v7_3.a();
                    }
                }
            });
            return;
        }

        j.a("==FB refresh token为空==", "==不刷新==" + arg7);
        if(arg8 != null) {
            arg8.a();
        }
    }

    public void c(String arg6, int arg7) {
        String v1;
        String v6;
        Context v7;
        if(arg7 == -1) {
            ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_ExpireTime_Key_" + arg6, Integer.valueOf(0), 1);
            v7 = ShareFitness.ctx;
            v6 = "ShareFitnessType_FitBit_ExpireTime_Date_Key_" + arg6;
            v1 = "";
        }
        else {
            ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_ExpireTime_Key_" + arg6, Integer.valueOf(0), 1);
            v7 = ShareFitness.ctx;
            v6 = "ShareFitnessType_FitBit_ExpireTime_Date_Key_" + arg6;
            v1 = "2021-02-07 10:53:48";
        }

        ContextSharedPreferences.SharedPreferencesEditor(v7, v6, v1, 5);
    }

    public void c(String arg4, String arg5) {
        this.f = arg4;
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_Token_Key_" + arg5, arg4, 5);
    }

    public String getPrefsFitbitTokenId(String arg4) {
        String v4 = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_FitBit_Token_Key_" + arg4, "", 5);
        return d.strNotEmpty(v4) ? "" : v4;
    }

    public void d(String arg4, String arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_RefreshToken_Key_" + arg5, arg4, 5);
    }

    public String e(String arg4) {
        return (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_RefreshToken_Key_" + arg4, "", 5);
    }

    public void e(String arg4, String arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_RefreshToken_Key_" + arg5, arg4, 5);
    }

    public String f(String arg4) {
        return (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_RefreshToken_Key_" + arg4, "", 5);
    }

    public void f(String arg4, String arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_RefreshToken_Key_" + arg5, arg4, 5);
    }

    public String g(String arg4) {
        return (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_FitBit_RefreshToken_Key_" + arg4, "", 5);
    }

    public void setPrefsMFP_UserId(String arg4, String arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_UserId_Key_" + arg5, arg4, 5);
    }

    public String getPrefsMFP_UserId(String arg4) {
        return (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_UserId_Key_" + arg4, "", 5);
    }

    public void h(String arg4, String arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_UserId_Key_" + arg5, arg4, 5);
    }

    public String getPrefsFitbitUserId(String arg4) {
        return (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_FitBit_UserId_Key_" + arg4, "", 5);
    }

    public void i(String arg4, String arg5) {
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_UserId_Key_" + arg5, arg4, 5);
    }

    public String j(String arg5) {
        int v0 = this.c;
        if(v0 == 0) {
            this.g = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_AuthCode_Key_" + arg5, "", 5);
            return this.g;
        }

        if(v0 == 1) {
            this.h = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_AuthCode_Key_" + arg5, "", 5);
            return this.h;
        }

        if(v0 == 2) {
            this.i = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, "ShareFitnessType_FitBit_AuthCode_Key_" + arg5, "", 5);
            return this.i;
        }

        return "";
    }

    public void j(String arg5, String arg6) {
        String v3;
        StringBuilder v2;
        Context v0_1;
        int v0 = this.c;
        if(v0 == 0) {
            this.g = arg5;
            v0_1 = ShareFitness.ctx;
            v2 = new StringBuilder();
            v3 = "ShareFitnessType_MapMyFitness_AuthCode_Key_";
            v2.append(v3);
            v2.append(arg6);
            ContextSharedPreferences.SharedPreferencesEditor(v0_1, v2.toString(), arg5, 5);
            return;
        }

        if(v0 == 1) {
            this.h = arg5;
            v0_1 = ShareFitness.ctx;
            v2 = new StringBuilder();
            v3 = "ShareFitnessType_MyFitnessPal_AuthCode_Key_";
            v2.append(v3);
            v2.append(arg6);
            ContextSharedPreferences.SharedPreferencesEditor(v0_1, v2.toString(), arg5, 5);
            return;
        }

        if(v0 == 2) {
            this.i = arg5;
            v0_1 = ShareFitness.ctx;
            v2 = new StringBuilder();
            v3 = "ShareFitnessType_FitBit_AuthCode_Key_";
            v2.append(v3);
            v2.append(arg6);
            ContextSharedPreferences.SharedPreferencesEditor(v0_1, v2.toString(), arg5, 5);
            return;
        }
    }

    public void k(String arg3, String arg4) {
        String v4 = this.getPrefsMapMyFitnessTokenKey(arg4);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, v4, arg3, 5);
    }

    public boolean k(String arg1) {
        return d.strNotEmpty(this.a(arg1));
    }

    public void l(String arg5) {
        ShareFitness.get(ShareFitness.ctx).k("", arg5 + "");
        ShareFitness.get(ShareFitness.ctx).l("", arg5 + "");
        ShareFitness.get(ShareFitness.ctx).m("", arg5 + "");
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_Token_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_Token_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_Token_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_RefreshToken_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_RefreshToken_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_RefreshToken_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_UserId_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_UserId_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_UserId_Key_" + arg5, "", 5);
        ShareFitness.get(ShareFitness.ctx).a(arg5 + "", -1);
        ShareFitness.get(ShareFitness.ctx).b(arg5 + "", -1);
        ShareFitness.get(ShareFitness.ctx).c(arg5 + "", -1);
        try {
            CookieManager v5_1 = CookieManager.getInstance();
            v5_1.removeSessionCookie();
            v5_1.removeExpiredCookie();
            v5_1.removeAllCookie();
        }
        catch(Exception v5) {
            v5.printStackTrace();
        }
    }

    public void l(String arg3, String arg4) {
        String v4 = this.getPrefsMFPTokenId(arg4);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, v4, arg3, 5);
    }

    public void m(String arg5) {
        ShareFitness.get(ShareFitness.ctx).l("", arg5 + "");
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_Token_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_RefreshToken_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MyFitnessPal_UserId_Key_" + arg5, "", 5);
        ShareFitness.get(ShareFitness.ctx).b(arg5 + "", -1);
        try {
            CookieManager v5_1 = CookieManager.getInstance();
            v5_1.removeSessionCookie();
            v5_1.removeExpiredCookie();
            v5_1.removeAllCookie();
        }
        catch(Exception v5) {
            v5.printStackTrace();
        }
    }

    public void m(String arg3, String arg4) {
        String v4 = this.getPrefsFitbitTokenId(arg4);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, v4, arg3, 5);
    }

    public void n(String arg5) {
        ShareFitness.get(ShareFitness.ctx).k("", arg5 + "");
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_Token_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_RefreshToken_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_MapMyFitness_UserId_Key_" + arg5, "", 5);
        ShareFitness.get(ShareFitness.ctx).a(arg5 + "", -1);
        try {
            CookieManager v5_1 = CookieManager.getInstance();
            v5_1.removeSessionCookie();
            v5_1.removeExpiredCookie();
            v5_1.removeAllCookie();
        }
        catch(Exception v5) {
            v5.printStackTrace();
        }
    }

    public void o(String arg5) {
        ShareFitness.get(ShareFitness.ctx).m("", arg5 + "");
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_Token_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_RefreshToken_Key_" + arg5, "", 5);
        ContextSharedPreferences.SharedPreferencesEditor(ShareFitness.ctx, "ShareFitnessType_FitBit_UserId_Key_" + arg5, "", 5);
        ShareFitness.get(ShareFitness.ctx).c(arg5 + "", -1);
        try {
            CookieManager v5_1 = CookieManager.getInstance();
            v5_1.removeSessionCookie();
            v5_1.removeExpiredCookie();
            v5_1.removeAllCookie();
        }
        catch(Exception v5) {
            v5.printStackTrace();
        }
    }

    public String p(String arg4) {
        String v0 = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, arg4, "", 5);
        return d.strNotEmpty(v0) ? arg4 : v0;
    }

    public String q(String arg4) {
        String v0 = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, arg4, "", 5);
        return d.strNotEmpty(v0) ? arg4 : v0;
    }

    public String r(String arg4) {
        String v0 = (String)ContextSharedPreferences.SharedPreferences(ShareFitness.ctx, arg4, "", 5);
        return d.strNotEmpty(v0) ? arg4 : v0;
    }
}
