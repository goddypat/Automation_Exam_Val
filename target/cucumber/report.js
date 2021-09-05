$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/WhiteColor.feature");
formatter.feature({
  "line": 2,
  "name": "Validate White Functions",
  "description": "",
  "id": "validate-white-functions",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@WhiteColor"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "\"White\" button exists",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "White",
      "offset": 1
    }
  ],
  "location": "BackgroundColor.button_exists(String)"
});
formatter.result({
  "duration": 875481300,
  "error_message": "java.lang.IllegalStateException: The driver executable does not exist: C:\\Users\\12147\\January 2021 Selenium\\Automation_Exam\\.\\driver\\chromedriver.exe\r\n\tat com.google.common.base.Preconditions.checkState(Preconditions.java:534)\r\n\tat org.openqa.selenium.remote.service.DriverService.checkExecutable(DriverService.java:136)\r\n\tat org.openqa.selenium.remote.service.DriverService.findExecutable(DriverService.java:131)\r\n\tat org.openqa.selenium.chrome.ChromeDriverService.access$000(ChromeDriverService.java:32)\r\n\tat org.openqa.selenium.chrome.ChromeDriverService$Builder.findDefaultExecutable(ChromeDriverService.java:137)\r\n\tat org.openqa.selenium.remote.service.DriverService$Builder.build(DriverService.java:339)\r\n\tat org.openqa.selenium.chrome.ChromeDriverService.createDefaultService(ChromeDriverService.java:88)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:123)\r\n\tat util.BrowserFactory.init(BrowserFactory.java:19)\r\n\tat step.BackgroundColor.button_exists(BackgroundColor.java:19)\r\n\tat ✽.Given \"White\" button exists(features/WhiteColor.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 7,
  "name": "1 User should be able to change background color to white",
  "description": "",
  "id": "validate-white-functions;1-user-should-be-able-to-change-background-color-to-white",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "User should be able to click on the white button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the background color will change to \"white\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BackgroundColor.user_should_be_able_to_click_on_the_white_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "white",
      "offset": 37
    }
  ],
  "location": "BackgroundColor.the_background_color_will_change_to(String)"
});
formatter.result({
  "status": "skipped"
});
});