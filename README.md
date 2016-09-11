### Custom FXLauncher Update UI

This example project shows you how you can customize the look and feel of the
FXLauncher user interface.

It is recommended that you create a separate project for the custom UI to make it
easier to embed it into the `fxlauncher.jar`. Basically you implement [UIProvider](https://github.com/edvin/fxlauncher/blob/master/src/main/java/fxlauncher/UIProvider.java)
and add the `META-INF/services/fxlauncher.UIProvider` file, pointing to your implementation. See the
documentation of `UIProvider` on the previous link.

To embed custom UI, include a step in your app project where you basically
embed all the class files from the ui project into the `fxlauncher.jar`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
            <version>1.4.0</version>
            <executions>
                <!-- Here you already have executions for 
                "create-manifest" and "embed-manifest-in-launcher" --> 
                <execution>
                    <id>embed-custom-ui-in-launcher</id>
                    <phase>package</phase>
                    <goals>
                        <goal>exec</goal>
                    </goals>
                    <configuration>
                        <executable>jar</executable>
                        <workingDirectory>${app.dir}</workingDirectory>
                        <arguments>
                            <argument>uf</argument>
                            <argument>fxlauncher.jar</argument>
                            <argument>-C</argument>
                            <argument>${project.basedir}/../fxlauncher-custom-ui/target/classes</argument>
                            <argument>.</argument>
                        </arguments>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```