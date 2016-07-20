package com.education.mydagger2test;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Lazy;

/**
 * Created by zhonghang on 16/7/19.
 */
@Component(modules = StudentModule.class)
public interface ActivityComponent {
    /**
     * 这种是依赖注入类(MainActivity)中的属性,该类中的属性有@Inject
     *
     * @param activity
     */
    void inject(MainActivity activity);

    /**
     * 懒加载其中的Student,第一次调用get方法时初始化
     *
     * @return
     */
    Lazy<Student> lazyStudent();

    /**
     * 加载,每次调用get都会加载新的实例
     *
     * @return
     */
    Provider<Student> providerStudent();
}
