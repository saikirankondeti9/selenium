Feature: to validate registration functionality
@ramse
Scenario: to validate registration with valid credentials
Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
And user wait for element loading till "30" seconds
When user clicks on link using xpath "//a[text()='New User Register Here']"
And user wait for element loading till "30" seconds
Then  user validates title to be 'Adactin.com - New User Registration'
When user enters details in registration form using headers
|useranme|password|confirm password|full name|email id|captcha|
|saikiran|Sai123|Sai123|saikiran k|saikirnkondeti9@gmail.com|india|