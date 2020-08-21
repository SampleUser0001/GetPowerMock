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
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ GetPowerMock ---
[INFO] sample:GetPowerMock:jar:1.0-SNAPSHOT
[INFO] +- junit:junit:jar:4.11:test
[INFO] |  \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- org.mockito:mockito-core:jar:3.3.3:test
[INFO] |  +- net.bytebuddy:byte-buddy:jar:1.10.5:test
[INFO] |  +- net.bytebuddy:byte-buddy-agent:jar:1.10.5:test
[INFO] |  \- org.objenesis:objenesis:jar:2.6:test
[INFO] +- org.powermock:powermock-api-mockito2:jar:2.0.7:test
[INFO] |  \- org.powermock:powermock-api-support:jar:2.0.7:test
[INFO] |     \- org.powermock:powermock-reflect:jar:2.0.7:test
[INFO] +- org.powermock:powermock-module-junit4:jar:2.0.7:test
[INFO] |  \- org.powermock:powermock-module-junit4-common:jar:2.0.7:test
[INFO] \- org.powermock:powermock-module-junit4-rule-agent:jar:2.0.7:test
[INFO]    +- org.powermock:powermock-core:jar:2.0.7:test
[INFO]    |  \- org.javassist:javassist:jar:3.27.0-GA:test
[INFO]    \- org.powermock:powermock-module-javaagent:jar:2.0.7:test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.568 s
[INFO] Finished at: 2020-08-05T13:34:34+09:00
[INFO] Final Memory: 11M/26M
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
[INFO] Copying mockito-core-3.3.3.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/mockito-core-3.3.3.jar
[INFO] Copying powermock-api-support-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-api-support-2.0.7.jar
[INFO] Copying powermock-module-junit4-rule-agent-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-module-junit4-rule-agent-2.0.7.jar
[INFO] Copying powermock-module-junit4-common-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-module-junit4-common-2.0.7.jar
[INFO] Copying hamcrest-core-1.3.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/hamcrest-core-1.3.jar
[INFO] Copying byte-buddy-1.10.5.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/byte-buddy-1.10.5.jar
[INFO] Copying powermock-module-junit4-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-module-junit4-2.0.7.jar
[INFO] Copying junit-4.11.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/junit-4.11.jar
[INFO] Copying powermock-api-mockito2-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-api-mockito2-2.0.7.jar
[INFO] Copying powermock-core-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-core-2.0.7.jar
[INFO] Copying powermock-reflect-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-reflect-2.0.7.jar
[INFO] Copying byte-buddy-agent-1.10.5.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/byte-buddy-agent-1.10.5.jar
[INFO] Copying objenesis-2.6.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/objenesis-2.6.jar
[INFO] Copying javassist-3.27.0-GA.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/javassist-3.27.0-GA.jar
[INFO] Copying powermock-module-javaagent-2.0.7.jar to /home/ec2-user/environment/GetPowerMock/target/dependency/powermock-module-javaagent-2.0.7.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.578 s
[INFO] Finished at: 2020-08-05T13:38:33+09:00
[INFO] Final Memory: 11M/26M
[INFO] ------------------------------------------------------------------------
```

## 追加調査：カバレッジを取得する

### JaCoCo導入

pom.xmlに下記を追記。
```
    <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.2</version>
        <executions>
            <execution>
                <goals>
                    <goal>prepare-agent</goal>
                </goals>
            </execution>
            <!-- attached to Maven test phase -->
            <execution>
                <id>report</id>
                <phase>test</phase>
                <goals>
                    <goal>report</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
```

テスト実行。
```
mvn clean
mvn compile
mvn test
```

カバレッジレポートが作成される。  
target/site/jacoco/inde.htmlを開く。

### PowerMockを使用したときにカバレッジが正常に取得できない

#### NG

インポート
```
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
```

JUnitソース
```
@RunWith(PowerMockRunner.class)
```

#### OK
pom.xml
```
<dependency>
  <groupId>org.powermock</groupId>
  <artifactId>powermock-module-junit4-rule-agent</artifactId>
  <version>1.6.4</version>
  <scope>test</scope>
</dependency>
```

インポート
```
import org.junit.Rule;
import org.powermock.modules.junit4.rule.PowerMockRule;
```

JUnitソース
```
    @Rule
    public PowerMockRule rule = new PowerMockRule();

```

## テスト結果

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running sample.TaisyouTest
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.241 sec <<< FAILURE!
warning(junit.framework.TestSuite$1)  Time elapsed: 0.018 sec  <<< FAILURE!
junit.framework.AssertionFailedError: No tests found in sample.TaisyouTest
        at junit.framework.Assert.fail(Assert.java:57)
        at junit.framework.TestCase.fail(TestCase.java:227)
        at junit.framework.TestSuite$1.runTest(TestSuite.java:100)
        at junit.framework.TestCase.runBare(TestCase.java:141)
        at junit.framework.TestResult$1.protect(TestResult.java:122)
        at junit.framework.TestResult.runProtected(TestResult.java:142)
        at junit.framework.TestResult.run(TestResult.java:125)
        at junit.framework.TestCase.run(TestCase.java:129)
        at junit.framework.TestSuite.runTest(TestSuite.java:255)
        at junit.framework.TestSuite.run(TestSuite.java:250)
        at org.junit.internal.runners.JUnit38ClassRunner.run(JUnit38ClassRunner.java:84)
        at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)
        at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)
        at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)
        at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)
        at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)
        at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)
        at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)


Results :

Failed tests:   warning(junit.framework.TestSuite$1): No tests found in sample.TaisyouTest

Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
```

## 参考

[Qiita:PowerMockを使ってメソッド内で生成されるインスタンスをモックに置き換える](https://qiita.com/froide_h-hayashi/items/eeb2b5a429afdb79b05b)

[kurukuruzの日記:Mockito+PowerMockで不可視メソッドをspy](https://kurukuruz.hatenablog.jp/entry/2018/05/23/205544)

[Qiita:Mavenを依存ライブラリをダウンロードする用途のみで使う](https://qiita.com/rk05231977/items/9dcf8b6cc3cdc9d50a2d)

[junit4 javadoc](https://junit.org/junit4/javadoc/latest/index.html)

[powermock javadoc](https://javadoc.io/doc/org.powermock/powermock-api-mockito/latest/index.html)

カバレッジ取得：JaCoCo  
[Maven - JaCoCoコードカバレッジの例](https://www.codeflow.site/ja/article/maven__maven-jacoco-code-coverage-example)

カバレッジバグ  
[PowerMock ECLEmmaカバレッジの問題](https://www.it-swarm.dev/ja/java/powermock-eclemma%E3%82%AB%E3%83%90%E3%83%AC%E3%83%83%E3%82%B8%E3%81%AE%E5%95%8F%E9%A1%8C/1046031264/)  
[PowerMock disables EclEmma code coverage #422](https://github.com/powermock/powermock/issues/422)  
