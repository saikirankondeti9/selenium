Feature: to validate login functionality
Scenario: to validate login functionality using valid credintials
Given user starts "chrome" browser
And user launch app using url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And user wait for element loading till "30" seconds
When user enters username "Admin" using xpath "//input[@name='username']"
And user enters password "admin123" using xpath "//input[@name='password']"
And user clicks enter button using xpath "//button[text()=' Login ']"
Then user validates title to be "OrangeHRM" 
