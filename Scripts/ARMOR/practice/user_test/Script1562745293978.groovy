import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/?next=/en-us/')

WebUI.setText(findTestObject('Object Repository/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('Object Repository/Page_ ARMOR/input_Login_password'), Keys.chord(Keys.ENTER))

for (int i = 0 ; i < 8 ; i++) {
	
	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/b_Configuration_caret'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/a_Role and Permission Management'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/a_Create Role'), GlobalVariable.G_Small_Timeout)
	
	WebUI.setText(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Role name_role-name'), 'wei_1111'+i)

	WebUI.setText(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Description_role-desc'), 'wei'+i)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Next'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Can add rack_can_add_rack'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Can delete rack_can_del_rack'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Can import rack_can_import_rack'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Can modify rack_can_modify_rack'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Can scan rack_can_scan_rack'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Can set maintain mode_can_set_maintain_mode'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Next'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Finish'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Close'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/a_Configuration'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/a_User Management'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/a_Add User'), GlobalVariable.G_Small_Timeout)

	def data = TestDataFactory.findTestData("Data Files/user_data")	

	WebUI.setText(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Username_name'), data.getValue(1, i+2))

	WebUI.setText(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Description_desc'), data.getValue(2, i+2))

	WebUI.setText(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Email_email'), data.getValue(3, i+2))

	WebUI.setText(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Password_passwd'), data.getValue(4, i+2))

	WebUI.setText(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/input_Confirm Password_cfpasswd'), data.getValue(4, i+2))

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Next_1'), GlobalVariable.G_Small_Timeout)
	
	WebUI.switchToFrame(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/iframe_Continue_1562752460384'), GlobalVariable.G_Small_Timeout)
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebElement table = driver.findElement(By.xpath('//*[@id="form-step-1"]/div/div/div[1]/div[2]/div[2]/table/tbody'))
	
	List<WebElement> rows = table.findElements(By.tagName('tr'))
	
	int position = 0
	
	for (position = 0 ; position < rows.size() ; position++) {
		testObject = new TestObject("roleName")
		if (position == 0)
			testObject.addProperty("xpath", ConditionType.EQUALS, "//div[@id='form-step-1']/div/div/div/div[2]/div[2]/table/tbody/tr/td[2]", true)
		else 
			testObject.addProperty("xpath", ConditionType.EQUALS, "//div[@id='form-step-1']/div/div/div/div[2]/div[2]/table/tbody/tr[" + (position+1) + "]/td[2]", true)
			
		if (WebUI.getText(testObject).equals("wei_1111"+i)) {
			break
		} // if
	} // end for
	
	checkBoxObject = new TestObject("checkBox")

	if (position == 0)
		checkBoxObject.addProperty("xpath", ConditionType.EQUALS, "//input[@name='btSelectItem']", true)
	else
		checkBoxObject.addProperty("xpath", ConditionType.EQUALS, "(//input[@name='btSelectItem'])[" + (position+1) + "]", true)

	KeywordUtil.logInfo(""+position)
	smartWaitAndClick(checkBoxObject, GlobalVariable.G_Small_Timeout)

	WebUI.switchToDefaultContent()
	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Next_1'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Finish_1'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('Object Repository/Page_ARMOR_user/Page_ARMOR/button_Close_1'), GlobalVariable.G_Small_Timeout)
} // end for

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


