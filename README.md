# UIFramework

This framework contains the following test cases to verify some features of Wikipedia Advanced Search functionality:

-> Test 1 to check that "Do you mean" hint appears if there is no corresponding page.

-> Test 2 checks that results do not contain specific text introduced by "Not this text" criteria.

-> Test 3 verifies that all the results correspond to the "File type" criteria.

-> Test 4 checks that all the results are sorted by edit date.


**Technologies**:

- Java with Selenium 4
- Maven
- TestNG
- Allure reports
- Apache POI


**Description**:

-> In general the testing framework is based on the Page Object Model design pattern.

-> Page Factory pattern from Selenium tool is used in the Page Objects to navigate the execution flow.

-> Chaining model is applied by returning the instance of a new page to navigate to.

-> Strategy design pattern is used to manage instantiation of WebDriver for different browsers (for instance support is for Chrome and Firefox).

-> RetryAnalyser is inherited from the TestNG framework. In particular, it serves to relaunch the test in case of an synchornisation issue during test execution.

-> Data Driven test framework approach. Test data is uploaded before test execution.

-> Triggering screenshot capture on failure with Allure framework.


**Execution**:

To launch test in Chrome: "mvn clean test -Dsurefire.suiteXmlFiles=testng.xml", or Firefox "mvn clean test -Dbrowser=firefox -Dsurefire.suiteXmlFiles=testng.xml"

For parallel run of test cases (in Chrome): "mvn clean test -Dsurefire.suiteXmlFiles=testng_parallel.xml"

To launch Allure reports: "allure serve target\allure-results".


**Assumptions**:

-> Test starts from Wikipedia home page, but could be directly from the advanced search page.

-> Check only the first page on results.

-> In case of an issue during execution RetryAnalyzer relaunch the test.

-> All search terms/words are externalised in Excel file data folder.


**Improvements**:

-> Add support for other browsers and platformes, use RemoteWebDriver with DesiredCapabilities to execute the test on cloud, BrowserStack or LambdaTest.

