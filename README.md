
# 如何使用它
## Step 1.
	先在 build.gradle(Project:XXXX) 的 repositories 添加 ： 
	allprojects{
		repositories{
			...
			maven {
			    url "https://jitpack.io" 
			} 
		}
	}

## Step 2.
	然后在build.gradle(Module:app) 的 dependencies 添加 
	dependencies { 
		implementation 'com.github.milanxiaotiejiang:RobotLog:Tag'
	}

## 初始化
    自定义Application中初始化
	if (BuildConfig.DEBUG) {
        Logger.getLogConfig()
            .configAllowLog(true)//是否输出
            .configShowBorders(true);//图标
        Logger.plant(new FileTree(this, "Logger"));//本地
        Logger.plant(new ConsoleTree());//控制台
        Logger.plant(new LogcatTree());//logcat
    }
    
## 使用
####1.string
  Logger.v("message", "test message");
  Logger.v("test message");
  
####2.object
    Logger.i(new Boolean(true));
    
####3.bundle
    Logger.d(new Bundle());
    
####4.collection
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        list.add("test" + i);
    }
    Logger.i(list);
    
####5.intent
    Logger.w(new Intent());
    
####6.map
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < 5; i++) {
        map.put("xyy" + i, "test" + i);
    }
    Logger.d(map);
    
####7.reference
    Logger.wtf(new SoftReference(0));
    
####8.throwable
    Logger.e(new NullPointerException("this object is null!"));
    
####9.json
    String json = "{'xyy1':[{'test1':'test1'},{'test2':'test2'}],'xyy2':{'test3':'test3'," +
                    "'test4':'test4'}}";
    Logger.json(json);
    
####10.xml
    String xml = "<xyy><test1><test2>key</test2></test1><test3>name</test3><test4>value</test4></xyy>";
    Logger.xml(xml);