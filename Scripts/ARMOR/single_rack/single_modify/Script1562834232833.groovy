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

WebUI.setText(findTestObject('single_rack/Page_ARMOR_single_modify/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('single_rack/Page_ARMOR_single_modify/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('single_rack/Page_ARMOR_single_modify/input_Login_password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/a_All Racks'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/a_Venus-Rack'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_Modify'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/div_Description'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('single_rack/Page_ARMOR_single_modify/textarea_Description_rack_description'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

String description = WebUI.getAttribute(findTestObject('single_rack/Page_ARMOR_single_modify/textarea_Description_rack_description'), 'value')

WebUI.setText(findTestObject('single_rack/Page_ARMOR_single_modify/textarea_Description_rack_description'), 'RMC1-00:15:b2:ab:af:d6(172.200.240.73)\nRMC2-00:15:b2:ab:af:e2(172.200.240.51)\n333')

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_Save Change'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_Show Detail'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('single_rack/Page_ARMOR_single_modify/p_Modify Rack Success'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_modify/p_Modify Rack Success')).equals('Modify Rack Success')) {
	KeywordUtil.markFailed("Modify Rack Failed")
} // if

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_Modify'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('single_rack/Page_ARMOR_single_modify/textarea_Description_rack_description'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

WebUI.setText(findTestObject('single_rack/Page_ARMOR_single_modify/textarea_Description_rack_description'), description)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_Save Change'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_Show Detail'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('single_rack/Page_ARMOR_single_modify/p_Modify Rack Success'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_modify/p_Modify Rack Success')).equals('Modify Rack Success')) {
	KeywordUtil.markFailed("Modify Rack Failed")
} // if
smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_modify/button_'), GlobalVariable.G_Small_WaitTime)

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