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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/?next=/en-us/')

WebUI.setText(findTestObject('BIOSandBMCUpdate/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('BIOSandBMCUpdate/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('BIOSandBMCUpdate/Page_ ARMOR/input_Login_password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/a_Venus-Rack'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/a_CPNODE'), GlobalVariable.G_Small_Timeout)

for (int i = 0 ; i < 4 ; i++) {
	WebUI.scrollToElement(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)
	
	// check current version
	version = WebUI.getText(findTestObject('BIOSandBMCUpdate/Page_ARMOR/td_BMC_Version'))
	
	smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)

	WebUI.scrollToElement(findTestObject('BIOSandBMCUpdate/Page_ARMOR/button_Update BMC'), GlobalVariable.G_Small_Timeout)
	
	smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/button_Update BMC'), GlobalVariable.G_Small_Timeout)
	
	// choose version
	if (version.equals('PA36M001.6')) {
		smartWait(findTestObject('BIOSandBMCUpdate/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), GlobalVariable.G_Small_Timeout)
		WebUI.selectOptionByValue(findTestObject('BIOSandBMCUpdate/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), '1', true)
		// choose version 15
	} // if
	else {
		smartWait(findTestObject('BIOSandBMCUpdate/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), GlobalVariable.G_Small_Timeout)
		WebUI.selectOptionByValue(findTestObject('BIOSandBMCUpdate/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), '13', true)
		// choose version 16
	} // else
	
	
	// force_update checkbox 
	if (i % 2 == 0) {  // first & third -> uncheck force_update
		smartWait(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
		WebUI.uncheck(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Force update_force-update'))
		WebUI.verifyElementNotChecked(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
	} // if
	else {		// second & fourth -> check force_update
		smartWait(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
		WebUI.check(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Force update_force-update'))
		WebUI.verifyElementChecked(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
	} // else 
	
	if (i < 2) {	  // first & second -> preserve
		smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Preserve configurations_keep-bmc-config'), GlobalVariable.G_Small_Timeout)
	} // if
	else {			  // third & fourth -> overwrite all
		smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/input_Overwrite all configurations_keep-bmc-config'), GlobalVariable.G_Small_Timeout)
	} // else
	
	smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/button_Submit'), GlobalVariable.G_Small_Timeout)
	
	smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)
	
	smartWait(findTestObject('BIOSandBMCUpdate/Page_ARMOR/messege'), GlobalVariable.G_Small_Timeout)
	WebUI.delay(3)
	if (!WebUI.getText(findTestObject('BIOSandBMCUpdate/Page_ARMOR/messege')).equals('Update BMC Firmware Complete') ) {
		return false
	} // if
	
	smartWaitAndClick(findTestObject('BIOSandBMCUpdate/Page_ARMOR/button_'), GlobalVariable.G_Small_Timeout)
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


