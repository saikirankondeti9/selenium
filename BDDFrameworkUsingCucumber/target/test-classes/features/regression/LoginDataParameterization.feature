Feature: to validate login functionality
@test1
Scenario: to validate login function using valid credentials
Given user starts "chrome" browser
And user launch app using url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And user wait for element loading till "30" seconds
When user enters username "Admin" using xpath "//input[@name='username']"
And user enters password "admin123" using xpath "//input[@name='password']"
And user clicks enter button using xpath "//button[text()=' Login ']"
Then user validates title to be "OrangeHRM" 
@test2
Scenario Outline: to validate login using invalid credentials
Given user starts "chrome" browser
And user launch app using url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And user wait for element loading till "30" seconds
When user enters username '<username>' using xpath "//input[@name='username']"
And user enters password '<password>' using xpath "//input[@name='password']"
And user clicks enter button using xpath "//button[text()=' Login ']"
Then user validates title to be '<exptitle>'
Examples:
|username|password|exptitle|
|karan|admin123|OrangeHRM|
|Admin|karan12|OrangeHRM|
|kiran|karan12|OrangeHRM|