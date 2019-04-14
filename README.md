### Custom FXLauncher Update UI

This example project shows you how you can customize the look and feel of the
FXLauncher user interface.

It is recommended that you create a separate project for the custom UI to make it
easier to embed it into the `fxlauncher.jar`. Basically you implement [UIProvider](https://github.com/edvin/fxlauncher/blob/master/src/main/java/fxlauncher/UIProvider.java)
and add the `META-INF/services/fxlauncher.UIProvider` file, pointing to your implementation. See the
documentation of `UIProvider` on the previous link.

To embed the custom UI, include a step in your app project where you basically
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
                        <!-- Here, `jar` refers to an executable that you can run on 
                        the command line to create a jar file. -->
                        <executable>jar</executable> 
                        <workingDirectory>${app.dir}</workingDirectory>
                        <arguments>
                            <!-- The `u` argument means "update existing archive". Run `jar -h`for more info. -->
                            <!-- The `f` argument means "specify archive file name". Run `jar -h`for more info. -->
                            <argument>uf</argument>
                            <argument>fxlauncher.jar</argument>
                            <!-- The `-C` argument means "change to the specified directory and include 
                            the following files". Run `jar -h`for more info. -->
                            <argument>-C</argument>
                            <argument>${project.basedir}/../fxlauncher-custom-ui/target/classes</argument>
                            <!-- `.` means all the files in the directory. -->
                            <argument>.</argument>
                        </arguments>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
