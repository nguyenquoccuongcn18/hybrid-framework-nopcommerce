set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%\libAllure\aspectjweaver-1.9.20.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAsserJ\*;;%ProjectPath%libAllure\*;%ProjectPath%libExtent5\*;%ProjectPath%libReportNG\*;%ProjectPath%libSelenium\*;" org.testng.TestNG "%ProjectPath%resources\RunReportAllure.xml"
allure serve .\allure-results\
pause

