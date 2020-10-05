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

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/button_Add Stand-alone Rack'), GlobalVariable.G_Small_WaitTime)

WebUI.waitForJQueryLoad(20)

WebUI.delay(1)

int randomNum = Math.random() * 100;

String name = 'wei_'+ randomNum;

WebUI.setText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/input__rack_location'), name)

WebUI.setText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/input_Unique Chassis Number_rack_chassis'), 
    '123-45678123456781')

WebUI.setText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/input_RMC1 MAC Address_rmc1_mac'), '00:12:b1:ab:qq:ww')

WebUI.setText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/input_RMC1 IP Address_rmc1_ip'), '192.198.192.55')

WebUI.setText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/input_RMC2 MAC Address_rmc2_mac'), '00:12:b1:ab:qq:w3')

WebUI.setText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/input_RMC2 IP Address_rmc2_ip'), '192.198.192.77')

WebUI.setText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/textarea_Description_rack_description'), 
    '321')

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/button_Add Rack'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)

smartWait(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/p_Add Rack Success'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

if (!WebUI.getText(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/p_Add Rack Success')).equals('Add Rack Success') ) {
	KeywordUtil.markFailed('Add failed')
} // if

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_add_rack/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)

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


