# PowerMockのjarを取得したい

## 使ったコマンド
mvn compile  
mvn dependency:tree  
mvn dependency:copy-dependencies  

## 実行結果

### mvn compile

コンパイルする。

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building GetPowerMock 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ GetPowerMock ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ec2-user/environment/getPowerMock/GetPowerMock/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ GetPowerMock ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.810 s
[INFO] Finished at: 2020-05-20T01:29:34Z
[INFO] Final Memory: 12M/30M
[INFO] ------------------------------------------------------------------------
```

### mvn dependency:tree

ライブラリ間の依存関係を出力する。

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building GetPowerMock 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ GetPowerMock ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ec2-user/environment/getPowerMock/GetPowerMock/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ GetPowerMock ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.810 s
[INFO] Finished at: 2020-05-20T01:29:34Z
[INFO] Final Memory: 12M/30M
[INFO] ------------------------------------------------------------------------
```

### mvn dependency:copy-dependencies

依存ライブラリをダウンロードする。

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building GetPowerMock 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:copy-dependencies (default-cli) @ GetPowerMock ---
[INFO] Copying powermock-api-support-2.0.7.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/powermock-api-support-2.0.7.jar
[INFO] Copying powermock-module-junit4-common-2.0.7.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/powermock-module-junit4-common-2.0.7.jar
[INFO] Copying hamcrest-core-1.3.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/hamcrest-core-1.3.jar
[INFO] Copying byte-buddy-agent-1.9.10.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/byte-buddy-agent-1.9.10.jar
[INFO] Copying mockito-core-2.28.2.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/mockito-core-2.28.2.jar
[INFO] Copying powermock-module-junit4-2.0.7.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/powermock-module-junit4-2.0.7.jar
[INFO] Copying junit-4.11.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/junit-4.11.jar
[INFO] Copying powermock-api-mockito2-2.0.7.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/powermock-api-mockito2-2.0.7.jar
[INFO] Copying powermock-core-2.0.7.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/powermock-core-2.0.7.jar
[INFO] Copying byte-buddy-1.9.10.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/byte-buddy-1.9.10.jar
[INFO] Copying powermock-reflect-2.0.7.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/powermock-reflect-2.0.7.jar
[INFO] Copying objenesis-2.6.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/objenesis-2.6.jar
[INFO] Copying javassist-3.27.0-GA.jar to /home/ec2-user/environment/getPowerMock/GetPowerMock/target/dependency/javassist-3.27.0-GA.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.528 s
[INFO] Finished at: 2020-05-20T01:30:50Z
[INFO] Final Memory: 10M/25M
[INFO] ------------------------------------------------------------------------
```

## 参考

[Qiita:PowerMockを使ってメソッド内で生成されるインスタンスをモックに置き換える](https://qiita.com/froide_h-hayashi/items/eeb2b5a429afdb79b05b)

[kurukuruzの日記:Mockito+PowerMockで不可視メソッドをspy](https://kurukuruz.hatenablog.jp/entry/2018/05/23/205544)

[Qiita:Mavenを依存ライブラリをダウンロードする用途のみで使う](https://qiita.com/rk05231977/items/9dcf8b6cc3cdc9d50a2d)

[junit4 javadoc](https://junit.org/junit4/javadoc/latest/index.html)

[powermock javadoc](https://javadoc.io/doc/org.powermock/powermock-api-mockito/latest/index.html)
