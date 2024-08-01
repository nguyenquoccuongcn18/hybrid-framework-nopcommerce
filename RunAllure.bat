set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.20.jar" -classpath "%ProjectPath%out\production\hybrid-framework-nopcommerce;%ProjectPath%libAllure\*;%ProjectPath%libLog4Jver2\*;%ProjectPath%libReportNG\*;%ProjectPath%libSelenium\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%resources\RunReportAllure.xml"
allure serve .\allure-json\
pause