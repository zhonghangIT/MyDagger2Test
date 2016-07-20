package com.education.mydagger2test;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhonghang on 16/7/19.
 * Modules是提供依赖注入时所需对象实例的类，它们通过@Module注解来修饰类。
 * 当前类用于生成application类并进行注入
 * includes标识module将要注入MyApplication的任何依赖。
 */
@Module
public class StudentModule {


    /**
     * @return 返回一个Student对象
     * Provides 代表该方法(getontext)提供将要注入到依赖类(MyApplication)的对象(myApplication)
     * Singleton：如果标识为Singleton，那这个函数会一直返回相同的对象实例，
     * 这比常规的单例好很多。否则，每次注入类型都会得到一个新的实例。
     * 在这个例子中，由于我们没有创建新实例，而是返回已经存在的实例,
     * 因此即使不把函数标识为Singleton，每次调用还是会返回相同的实例的，
     * 但这样能够更好地说明提供者到底做了什么。Application实例是唯一的。
     */
    @Provides
    public Student providesStudent() {
        return zhangsan;
    }

    private Student zhangsan;

    public StudentModule() {
        zhangsan = new Student(18, "张三");
    }
}
