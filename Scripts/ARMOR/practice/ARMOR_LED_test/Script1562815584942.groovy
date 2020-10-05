import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/?next=/en-us/')

WebUI.setText(findTestObject('Object Repository/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('Object Repository/Page_ ARMOR/input_Login_password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/input_RMC2 IP_btSelectItem'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_Enter Maintain Mode'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_Submit_main'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_Show Detail_main'), GlobalVariable.G_Small_Timeout)

smartWait(findTestObject('Object Repository/Page_ARMOR/Enter_Maintain_Mode_Success'), GlobalVariable.G_Small_Timeout)
WebUI.delay(1)

if (!(WebUI.getText(findTestObject('Object Repository/Page_ARMOR/Enter_Maintain_Mode_Success')).equals('Enter Maintain Mode Success'))) {
	
    return false
}

smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_main'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/a_Venus-Rack'), 20)

smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/a_CPNODE'), 20)

WebDriver driver = DriverFactory.getWebDriver()

WebElement table = driver.findElement(By.xpath('//table[@id="cpnode-table"]/tbody'))

List<WebElement> rows = table.findElements(By.tagName('tr'))


//KeywordLogger log = new KeywordLogger()
//log.logInfo("abc"+eleCount)


for (int index = 47 ; index <= (47+rows.size()-1) ; index++) {
	testObject = new TestObject("checkBox")
	testObject.addProperty("xpath", ConditionType.EQUALS, "(//input[@name='btSelectItem'])[" + index + "]", true)
	WebUI.scrollToElement(testObject, 10)
	
	smartWaitAndClick(testObject, 20)
	
	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_LED'), 20)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/input_ON_id-led-switch'), 20)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_Submit_1'), 20)

	smartWaitAndClick(findTestObject('Page_ARMOR/button_Show Detail'), 20)

	smartWait(findTestObject('Object Repository/Page_ARMOR/Turn_On_LED_Complete'), 20)
	WebUI.delay(1)

	if (!(WebUI.getText(findTestObject('Object Repository/Page_ARMOR/Turn_On_LED_Complete')).equals('Turn On LED Complete'))) {
		// LED狀態訊息
		KeywordUtil.markFailed('turn on failed')
	} // if
	
	if (WebUI.getText(findTestObject('Object Repository/Page_ARMOR/p_Warning')).equals('Warning')) {
		// LED狀態訊息
		//KeywordUtil.markFailed('Warning')
		KeywordUtil.markFailed("Warning")
	} // if

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_'), 20)
} // for


//turn off LED
for (int index = 47 ; index <= (47+rows.size()-1) ; index++) {
	testObject = new TestObject("checkBox")
	testObject.addProperty("xpath", ConditionType.EQUALS, "(//input[@name='btSelectItem'])[" + index + "]", true)
	WebUI.scrollToElement(testObject, 10)
	smartWaitAndClick(testObject, 20)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_LED'), 20)
	
	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/input_OFF_id-led-switch'), 20)
	
	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button_Submit_1'), 20)

	smartWaitAndClick(findTestObject('Page_ARMOR/button_Show Detail'), 20)

	smartWait(findTestObject('Object Repository/Page_ARMOR/Turn_On_LED_Complete'), 20)
	WebUI.delay(1)

	if (!(WebUI.getText(findTestObject('Object Repository/Page_ARMOR/Turn_Off_LED_Complete')).equals('Turn Off LED Complete'))) {
		// LED狀態訊息
		KeywordUtil.markFailed('turn off failed')
	} // if
	
	if (WebUI.getText(findTestObject('Object Repository/Page_ARMOR/p_Warning')).equals('Warning')) {
		// LED狀態訊息
		KeywordUtil.markFailed('Warning')
	} // if

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR/button'), 20)
} // for


WebUI.closeBrowser()

def smartWait(TestObject testObject, int waitTime){
	for (int j = 0; j <= waitTime; j++) {
		if(!(
			WebUI.verifyElementClickable(testObject, FailureHandling.OPTIONAL)
			&& WebUI.verifyElementVisible(testObject, FailureHandling.OPTIONAL)
			&& WebUI.verifyElementPresent(testObject, 5, FailureHandling.OPTIONAL))
		){
			WebUI.comment('Element ' + testObject.toString() + ' is not ready.')
			WebUI.delay(1)
			//continue
		} // if
		else{
			WebUI.comment(testObject.toString() + ' is ready')
			WebUI.waitForElementPresent(testObject, 5)
			WebUI.waitForElementVisible(testObject, 5)
			WebUI.waitForElementClickable(testObject, 5)
			WebUI.waitForJQueryLoad(20)
			break
		} // else
		
		if(j==waitTime){
			KeywordUtil.markFailed('Element ' + testObject.toString() + ' was never found')
			break
		} // if
	} // for
} // smartWait()

def smartWaitAndClick(TestObject testObject, int waitTime){
	smartWait(testObject, waitTime)
	WebUI.click(testObject)
} // smartWaitAndClick()


