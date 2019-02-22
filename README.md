
### 如何使用它
### Step 1.
	先在 build.gradle(Project:XXXX) 的 repositories 添加 ： 
	allprojects{
		repositories{
			...
			maven {
			url "https://jitpack.io" 
			} 
		}
	}


### Step 2.
	然后在build.gradle(Module:app) 的 dependencies 添加 
	dependencies { 
		implementation 'com.github.milanxiaotiejiang:robot_log:1.0.0'
	}

### 初始化
	if (BuildConfig.DEBUG) {
  		Log.getLogConfig().configAllowLog(true).configShowBorders(false);
  		Log.plant(new FileTree(this, FileUtil.getCacheDir(this) + File.separator + "log"));
  		Log.plant(new ConsoleTree());
  		Log.plant(new LogcatTree());
	}
