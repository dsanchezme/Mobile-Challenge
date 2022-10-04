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

   
