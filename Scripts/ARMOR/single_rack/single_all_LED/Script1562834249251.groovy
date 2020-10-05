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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/?next=/en-us/')

WebUI.setText(findTestObject('Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('Page_ ARMOR/input_Login_password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/a_All Racks'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/a_Venus-Rack'), GlobalVariable.G_Small_WaitTime)

for (int i = 0 ; i < 5 ; i++) {
	switch(i) {
		case 0:
			smartWait(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_FW Version_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_FW Version_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.click(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_FW Version_btSelectAll'))
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_LED_nodesPool'), GlobalVariable.G_Small_WaitTime)
			break
		case 1:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/a_RMC'), GlobalVariable.G_Small_WaitTime)
			smartWait(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_RMC Version_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_RMC Version_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.click(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_RMC Version_btSelectAll'))
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_LED_RMC'), GlobalVariable.G_Small_WaitTime)
			break
		case 2:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/a_CPNODE'), GlobalVariable.G_Small_WaitTime)
			smartWait(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_BIOS Version_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_BIOS Version_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.click(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_BIOS Version_btSelectAll'))
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_LED_CPnode'), GlobalVariable.G_Small_WaitTime)
			break
		case 3:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/a_JBNODE'), GlobalVariable.G_Small_WaitTime)
			smartWait(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_Exp MFG_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_Exp MFG_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.click(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_Exp MFG_btSelectAll'))
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_LED_JBnode'), GlobalVariable.G_Small_WaitTime)
			break
		case 4:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/a_RACKBP'), GlobalVariable.G_Small_WaitTime)
			smartWait(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_RACKBP_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_RACKBP_btSelectAll'), GlobalVariable.G_Small_Timeout)
			WebUI.click(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_RACKBP_btSelectAll'))
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_LED_RackBP'), GlobalVariable.G_Small_WaitTime)
			break
		default:
			WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_FW Version_btSelectAll'), GlobalVariable.G_Small_Timeout)
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_FW Version_btSelectAll'), GlobalVariable.G_Small_WaitTime)
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_LED_nodesPool'), GlobalVariable.G_Small_WaitTime)
	} // switch
	
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/input_ON_id-led-switch'), GlobalVariable.G_Small_WaitTime)
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_Submit'), GlobalVariable.G_Small_WaitTime)
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Small_WaitTime)
	
	smartWait(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/p_Warning'), GlobalVariable.G_Small_WaitTime)
	
	WebUI.delay(1)
	
	if (WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/p_Warning')).equals('Warning') ) {
		KeywordUtil.markFailed('Warning')
	} // if
	
	smartWait(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/p_Turn On LED Complete'), GlobalVariable.G_Small_WaitTime)
	
	WebUI.delay(1)
	
	if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/p_Turn On LED Complete')).equals('Turn On LED Complete') ) {
		KeywordUtil.markFailed('Turn On LED failed')
	} // if
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_allLED/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)
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