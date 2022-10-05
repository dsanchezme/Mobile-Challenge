# Mobile Testing with Appium - Challenge  

Testing IBMb application using Appium in the following scenarios:  

1. **Verify movie overview**  
   > **Given** I am not logged into the application  
   > **When** I search for a movie  
   > And click on the first result  
   > **Then** the overview must match with an existing overview text    

2. **Verify functionality to add a movie to the watchlist**  
   > **Given** I am logged into the application  
   > **When** I search for a movie  
   > And I click on any result  
   > And I click on *Add to Watchlist*  
   > **Then** the watch list must contain the previous movie selected  
   
3. **Verify functionality to rate a movie**  
   > **Given** I am logged into the application  
   > **When** I search for a movie  
   > And I click on the first result  
   > And I click on *Rate* in the *User reviews* section      
   > And I select and submit a rate for the movie  
   > **Then** the message *Rating saved* must be displayed  

4. **Verify functionality to logout from the application**  
   > **Given** I am logged into the application    
   > **When** I go to the account view  
   > And I go to account settings    
   > And I click on *SIGN OUT*   
   > **Then** in the account view must be the button to *Sign in / Sign up*    

## Setup

- Make sure you have correctly installed java (Java 11 is recommended).  
   ```
   java --version
   ```
- Make sure you have correctly installed maven (Maven 3.8.6 is recommended).
   ```
   mvn --version
   ```
- Make sure you have an android device (Physical or emulator) connected, listing the devices attached.  
   ```
   adb devices
   ```
- Copy the name of your device listed and change the `deviceName` property in the file `src/main/resources/capabilities.json` with your device name.
- Install Appium (v1.15.1 recommended) and start a server with simple configuration at host `127.0.0.1` and port `4723`
- Create an account in IMDb.
- Set the credentials in the environment system variables as follows:
   * `IMDB_EMAIL` for the email
   * `IMDB_PASSWORD` for the password
  
## Run tests

To execute the test cases run
```
mvn clean verify
```

## Reports

For generating the allure reports:
1. Download the latest one [allure-commandline](https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/).
2. Extract & copy the `bin` location and add it to the system environment path.
3. Check allure installation.
    ```
    allure --version
    ```
4. Generate reports.
    ```
    allure serve
    ```

## Reference

- [Mobile Testing with Appium Challenge for Endava interns](https://github.com/andreaisabm/MobileWithAppiumChallenge)
- [How to use Allure Report as your Test Reporting Tool](https://www.linkedin.com/pulse/how-use-allure-report-your-test-reporting-tool-md-abdur-rahman-foysal)