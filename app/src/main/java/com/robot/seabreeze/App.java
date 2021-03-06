package com.robot.seabreeze;

import android.app.Application;

import com.robot.seabreeze.log.Logger;
import com.robot.seabreeze.log.inner.ConsoleTree;
import com.robot.seabreeze.log.inner.FileTree;
import com.robot.seabreeze.log.inner.LogcatTree;

/**
 * Author: MiLan
 * Date: 2019/2/22
 * Description:
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Logger.getLogConfig()
                    .configAllowLog(true)
                    .configShowBorders(true);
            Logger.plant(new FileTree(this, "Logger"));
//            Logger.plant(new ConsoleTree());
            Logger.plant(new LogcatTree());
        }
    }
}
