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

WebUI.setText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ ARMOR/input_Login_password'), Keys.chord(
        Keys.ENTER))

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/a_All Racks'), GlobalVariable.G_Large_Timeout)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/a_Venus-Rack'), GlobalVariable.G_Large_Timeout)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/a_JBNODE'), GlobalVariable.G_Large_Timeout)

for (int i = 0 ; i < 5 ; i++) {
	
	WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Exp MFG_btSelectAll'), GlobalVariable.G_Small_Timeout)
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Exp MFG_btSelectAll'), GlobalVariable.G_Large_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/button_Power Control'), GlobalVariable.G_Large_Timeout)

	switch(i) {
		case 0:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Power On_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 1:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Power Off_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 2:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Power On_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 3:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Power Reset_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 4:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Power Cycle_power-action'), GlobalVariable.G_Large_Timeout)
			break
		default:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/input_Power On_power-action'), GlobalVariable.G_Large_Timeout)
	} // switch
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/button_Submit'), GlobalVariable.G_Large_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)

	WebUI.delay(3)
	smartWait(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_Information'), GlobalVariable.G_Small_Timeout)
	
	switch(i) {
		case 0:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_messege')).equals('Power On Complete') ) {
				KeywordUtil.markFailed('Power On failed')
			} // if
			break
		case 1:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_messege')).equals('Power Off Complete') ) {
				KeywordUtil.markFailed('Power Off failed')
			} // if
			break
		case 2:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_messege')).equals('Power On Complete') ) {
				KeywordUtil.markFailed('Power On failed')
			} // if
			break
		case 3:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_messege')).equals('Power Reset Complete') ) {
				KeywordUtil.markFailed('Power Reset failed')
			} // if
			break
		case 4:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_messege')).equals('Power Cycle Complete') ) {
				KeywordUtil.markFailed('Power Cycle failed')
			} // if
			break
		default:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_messege')).equals('Power On Complete') ) {
				KeywordUtil.markFailed('Power On failed')
			} // if
	} // switch
	
	if (WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/p_Information')).equals('Warning')) {
		KeywordUtil.markFailed("Warning")
	} // if

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_JBnode/Page_ARMOR/button_'), GlobalVariable.G_Large_Timeout)
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
