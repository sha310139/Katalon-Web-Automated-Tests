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

WebUI.setText(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ ARMOR/input_Login_password'), Keys.chord(Keys.ENTER))

// ---------------------------------- Enter maintain mode first -----------------------------------------

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/input_RMC1-0015b2abafd6(172200240_btSelectItem'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_Enter Maintain Mode'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_Submit'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_Show Detail_maintain'), GlobalVariable.G_Large_Timeout)

smartWait(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/p_Enter Maintain Mode Success'), GlobalVariable.G_Small_Timeout)

WebUI.delay(1)

if (!WebUI.getText(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/p_Enter Maintain Mode Success')).equals('Enter Maintain Mode Success') ) {
	KeywordUtil.markFailed('Enter Maintain Mode failed')
} // if

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_maintain'), GlobalVariable.G_Small_Timeout)

// ---------------------------------- Enter maintain mode end -----------------------------------------

// ---------------------------------- Delete -----------------------------------------

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/input_RMC1-0015b2abafd6(172200240_btSelectItem'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_Delete Rack'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_Remove Rack'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)

smartWait(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/p_Delete Rack Success'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

if (!WebUI.getText(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/p_Delete Rack Success')).equals('Delete Rack Success') ) {
	KeywordUtil.markFailed('Delete failed')
} // if

smartWaitAndClick(findTestObject('AllRack/Page_ARMOR_delete_rack/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)

// ---------------------------------- Delete end -----------------------------------------

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