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

WebUI.setText(findTestObject('AllRack/Page_ARMOR_scan/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('AllRack/Page_ARMOR_scan/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('AllRack/Page_ARMOR_scan/Page_ ARMOR/input_Login_password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_RMC2 IP_btSelectItem'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/button_Scan'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Scan All Racks_auto-scan'), GlobalVariable.G_Small_Timeout)

WebUI.delay(1)

WebUI.uncheck(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Scan All Racks_auto-scan'))
WebUI.verifyElementNotChecked(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Scan All Racks_auto-scan'), GlobalVariable.G_Small_Timeout)


smartWait(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Interval_update-sel'), GlobalVariable.G_Small_Timeout)
WebUI.check(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Interval_update-sel'))
WebUI.verifyElementChecked(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Interval_update-sel'), GlobalVariable.G_Small_Timeout)

smartWait(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Update Inventory_update-sensor'), GlobalVariable.G_Small_Timeout)
WebUI.check(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Update Inventory_update-sensor'))
WebUI.verifyElementChecked(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/input_Update Inventory_update-sensor'), GlobalVariable.G_Small_Timeout)


smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/button_Submit'), GlobalVariable.G_Small_WaitTime)


smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)

smartWait(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/p_Information'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

if (WebUI.getText(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/p_Information')).equals('Warning')) {
	KeywordUtil.markFailed("Warning")
} // if

if (!WebUI.getText(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/p_Scan All Racks Complete')).equals('Scan All Racks Complete') ) {
	KeywordUtil.markFailed('Scan failed')
} // if

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_scan/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)

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