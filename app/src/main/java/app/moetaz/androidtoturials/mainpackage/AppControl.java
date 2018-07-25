package app.moetaz.androidtoturials.mainpackage;

import android.app.Application;

import app.moetaz.androidtoturials.dagger2retrofitokhttpgson.AppModule;
import app.moetaz.androidtoturials.dagger2retrofitokhttpgson.DaggerNetComponent;
import app.moetaz.androidtoturials.dagger2retrofitokhttpgson.NetComponent;
import app.moetaz.androidtoturials.dagger2retrofitokhttpgson.NetModule;
import app.moetaz.androidtoturials.simpedagger2example.DaggerMemberAppcomponent;
import app.moetaz.androidtoturials.simpedagger2example.MemberAppcomponent;
import app.moetaz.androidtoturials.simpedagger2example.MemberDataModule;

public class AppControl extends Application {

    private NetComponent mNetComponent;
    private MemberAppcomponent memberAppcomponent;
    private static AppControl app;
    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        memberAppcomponent = DaggerMemberAppcomponent.builder()
                .memberDataModule(new MemberDataModule())
                .build();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://www.jsonplaceholder.typicode.com/"))
                .build();
    }

    public static AppControl getApp() {
        return app;
    }
    public MemberAppcomponent getMemberAppcomponent() {
        return memberAppcomponent;
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
