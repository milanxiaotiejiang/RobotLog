
[ ![Download](https://api.bintray.com/packages/milanxiaotiejiang/RobotLog/RobotLog/images/download.svg) ](https://bintray.com/milanxiaotiejiang/RobotLog/RobotLog/_latestVersion)
image::https://api.bintray.com/packages/milanxiaotiejiang/RobotLog/RobotLog/images/download.svg[link="https://bintray.com/milanxiaotiejiang/RobotLog/RobotLog/_latestVersion"]
<a href='https://bintray.com/milanxiaotiejiang/RobotLog/RobotLog/_latestVersion'><img src='https://api.bintray.com/packages/milanxiaotiejiang/RobotLog/RobotLog/images/download.svg'></a>

# 如何使用它
## Step 
	dependencies { 
		implementation 'com.seabreezerobot:LogLibrary:v1.0.0'
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
#### 1.string
    Logger.v("message", "test message");
    Logger.v("test message");
  
#### 2.object
    Logger.i(new Boolean(true));
    
#### 3.bundle
    Logger.d(new Bundle());
    
#### 4.collection
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        list.add("test" + i);
    }
    Logger.i(list);
    
#### 5.intent
    Logger.w(new Intent());
    
#### 6.map
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < 5; i++) {
        map.put("xyy" + i, "test" + i);
    }
    Logger.d(map);
    
#### 7.reference
    Logger.wtf(new SoftReference(0));
    
#### 8.throwable
    Logger.e(new NullPointerException("this object is null!"));
    
#### 9.json
    String json = "{'xyy1':[{'test1':'test1'},{'test2':'test2'}],'xyy2':{'test3':'test3'," +
                    "'test4':'test4'}}";
    Logger.json(json);
    
#### 10.xml
    String xml = "<xyy><test1><test2>key</test2></test1><test3>name</test3><test4>value</test4></xyy>";
    Logger.xml(xml);
    
Copyright [yyyy] [name of copyright owner]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.