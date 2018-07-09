package app.moetaz.androidtoturials.mainpackage;

import android.app.Application;

import app.moetaz.androidtoturials.simpedagger2example.DaggerMemberAppcomponent;
import app.moetaz.androidtoturials.simpedagger2example.MemberAppcomponent;
import app.moetaz.androidtoturials.simpedagger2example.MemberDataModule;

public class AppControl extends Application {


    private MemberAppcomponent memberAppcomponent;
    private static AppControl app;
    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        memberAppcomponent = DaggerMemberAppcomponent.builder()
                .memberDataModule(new MemberDataModule())
                .build();
    }

    public static AppControl getApp() {
        return app;
    }
    public MemberAppcomponent getMemberAppcomponent() {
        return memberAppcomponent;
    }
}
