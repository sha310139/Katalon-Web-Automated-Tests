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

for (int i = 0 ; i < 6 ; i++) {
	smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_RMC1-0015b2abafd6(172200240_btSelectItem'), GlobalVariable.G_Small_Timeout)
	smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/button_Network Time Synchronization'), GlobalVariable.G_Small_Timeout)
	smartWait(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/select_option'), GlobalVariable.G_Small_Timeout)
	switch(i%3) {
		case 0 :
			WebUI.selectOptionByValue(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/select_option'), 'Asia/Tokyo', true)
			WebUI.check(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'))
			WebUI.verifyElementChecked(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'), GlobalVariable.G_Small_Timeout)
			break
		case 1 :
			WebUI.selectOptionByValue(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/select_option'), 'Asia/Tokyo', true)
			WebUI.uncheck(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'))
			WebUI.verifyElementNotChecked(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'), GlobalVariable.G_Small_Timeout)
			break
		case 2 :
			WebUI.selectOptionByValue(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/select_option'), 'Asia/Taipei',true)
			WebUI.check(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'))
			WebUI.verifyElementChecked(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'), GlobalVariable.G_Small_Timeout)
			break
		default :
			WebUI.selectOptionByValue(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/select_option'), 'Asia/Taipei',true)
			WebUI.check(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'))
			WebUI.verifyElementChecked(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Enable'), GlobalVariable.G_Small_Timeout)
	} // switch
	
	if (i < 3) {
		smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Use ARMOR of NTP server_sync-source'), GlobalVariable.G_Small_Timeout)
	} // end if
	else {
		smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/input_Use Other of NTP Server(Primary NTP Server)(Secondary NTP Server)_sync-source'), GlobalVariable.G_Small_Timeout)
	} // else
	
	smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/button_Time Sync'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)
	
	smartWait(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/p_Apply Network Time Synchronization Complete'), GlobalVariable.G_Small_Timeout)
	
	if (!WebUI.getText(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/p_Apply Network Time Synchronization Complete')).equals('Apply Network Time Synchronization Complete') ) {
		KeywordUtil.markFailed('Apply Network Time Synchronization failed')
	} // if
	
	if (WebUI.getText(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/p_Information')).equals('Warning')) {
		KeywordUtil.markFailed("Warning")
	} // if
	
	smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_network/Page_ARMOR/button_'), GlobalVariable.G_Small_Timeout)
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