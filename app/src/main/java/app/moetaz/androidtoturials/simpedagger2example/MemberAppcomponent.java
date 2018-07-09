package app.moetaz.androidtoturials.simpedagger2example;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MemberDataModule.class)
public interface MemberAppcomponent {

    void inject(Main3Activity mainActivity);
}
