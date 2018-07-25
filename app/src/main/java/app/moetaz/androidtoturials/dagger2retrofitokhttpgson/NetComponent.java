package app.moetaz.androidtoturials.dagger2retrofitokhttpgson;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(Main2Activity activity);
}