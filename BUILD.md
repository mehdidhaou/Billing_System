# Build

3 librarires must be fully configured and satisfied in order for this project ot be ran.

## Download Links

- Java JDK 15 :[https://www.techspot.com/downloads/5552-java-15-jdk.html](https://www.techspot.com/downloads/5552-java-15-jdk.html)

- JavaFX Library :[https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)

- MySQL Java Connector :[https://dev.mysql.com/downloads/connector/j](https://dev.mysql.com/downloads/connector/j)



## Configuration

After these three libraries are downloaded they must be configured for project structure. It is recommended that Intellij is used as a default Java IDE.



## Steps

1. Open Project Stucture (File - Project Strcuture).

2. Browse to PROJECT and set the Default SDK to JDK 15 previously downloaded (Click on SDK - Add SDK - JDK - and browse for JDK 15 directory).

3. Browse to MODULES and Click on the + sign, select "JAR or Directories.." and browse to "MySQL/Connector J 8.0/mysql-connector-java.jar". click OK.

4. Browse to LIBRARIES and Click on the + sign, browser to "Javafx-sdk-18.0/bin". click OK.

5. Save changes to Modules by clicking Apply.

6. Close Project Structure and Open Edit Configurations (Run - Edit Configurations..)

7. In the Application "GUI.main" under "Build and Run" you will find an input box named "VM Options" copy paste this command in that box.

```
--module-path "PATH_TO_JAVAFX\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml
```

```

   
```

MacOS : for macOS users path name should not be wrapped in double quotes.



## Wrap Up

Now you should be able to build this project as in compile it properly and run on Java's virtual machine.

for further informaton about JavaFX :[https://openjfx.io/openjfx-docs](https://openjfx.io/openjfx-docs)



## Build

For building Information :[https://www.jetbrains.com/help/idea/compiling-applications.html#run\_packaged\_jar](https://www.jetbrains.com/help/idea/compiling-applications.html#run_packaged_jar)
