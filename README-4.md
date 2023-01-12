

# Parimatch Final Project Team 2

Parimatch is an international holding company that carries out betting activities and organizes gambling on the internet. The Parimatch website provides the user with the opportunity to bet on the outcome of various events within the limits of the account balance.

## Documentation

All necessary information about project you can get in our [Test-plan](https://drive.google.com/drive/folders/1Sm50VdFd1N7NniP4m2nyBp57UJFiHX0A)

## Summary

In project were used different frameworks, tools, libraries and technologies like:

**JAVA**

**Appium**

**Maven**

**TestNG**

**Selenium**

The project has patterns such as **Page Object**, **Fluent/Chain of Invocations**, **Loadable Page**.

If tests fail, thanks to TestNG tools(RetryAnalyzer, TestListener and AnnotationTransformer), they will be restarted.

Reporting is carried out by **Allure Report** framework.

For logging use **Log4j2** library from **Lombok** library.

## Run Locally

1. Clone the project
```bash
  git clone https://git.java-academy.xyz/viktoria.aparina/fp_mobile_theme_2.git
```
2. Go to the project directory
```bash
  cd project_directory
```
3. Install dependencies
```bash
  mvn install
  allure install
```
4. Start device Pixel 3A_XL_API_30 12.0 android version in Android Studio

5. Start Appium server GUI

6. Run test in the project directory
```bash
  mvn clean test
```
7. Generate report in the project directory
```bash
  allure serve
```
If report wasn't generated or you got error, please run this command using MAVEN tab -> Plugins -> allure -> serve.
