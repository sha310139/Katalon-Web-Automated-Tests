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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://172.200.200.7/#login')
WebUI.waitForElementVisible(findTestObject('Object Repository/NTPObj/input_Processing _userid'), 20)
WebUI.setText(findTestObject('Object Repository/NTPObj/input_Processing _userid'), 'ADMIN')

WebUI.setEncryptedText(findTestObject('Object Repository/NTPObj/input_Processing _password'), 'XmnPW7mE0VA=')

smartWaitClickableAndClick(findTestObject('Object Repository/NTPObj/button_Sign me in'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/NTPObj/a_Settings'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/NTPObj/div_Captured BSOD_icon'), 20)
WebUI.waitForPageLoad(20)
WebUI.scrollToElement(findTestObject('Object Repository/NTPObj/ins_Automatic Date  Time_iCheck-helper'), 5)
WebUI.delay(1)
//WebUI.check(findTestObject('Object Repository/NTPObj/ins_Automatic Date  Time_iCheck-helper'))

if( WebUI.verifyElementNotChecked(findTestObject('Object Repository/NTPObj/ins_Automatic Date  Time_iCheck-helper'), 20) ){
	
	WebUI.check(findTestObject('Object Repository/NTPObj/ins_Automatic Date  Time_iCheck-helper'))
}


//WebUI.selectOptionByValue(findTestObject('Object Repository/NTPObj/ins_Automatic Date  Time_iCheck-helper'), "1", true)
WebUI.setText(findTestObject('Object Repository/NTPObj/input_Primary NTP Server_idprimary_ntp'), '172.200.200.21')

WebUI.setText(findTestObject('Object Repository/NTPObj/input_Secondary NTP Server_idsecondary_ntp'), '172.200.200.25')

smartWaitClickableAndClick(findTestObject('Object Repository/NTPObj/a_ Save'), 20)

WebUI.acceptAlert()
WebUI.waitForJQueryLoad(20, FailureHandling.OPTIONAL)
WebUI.acceptAlert()

def smartWaitClickableAndClick(TestObject testObject, int waitTime) {
	for (int j = 0; j <= waitTime; j++) {
		if (!((WebUI.verifyElementClickable(testObject, FailureHandling.OPTIONAL) && WebUI.verifyElementVisible(testObject,
			FailureHandling.OPTIONAL)) && WebUI.verifyElementPresent(testObject, 5, FailureHandling.OPTIONAL))) {
			WebUI.scrollToElement(testObject, 5)

			WebUI.comment(('Element ' + testObject.toString()) + ' is not ready.')

			WebUI.delay(1)
		} else {
			WebUI.comment(testObject.toString() + ' is ready')

			WebUI.waitForElementPresent(testObject, 20)

			WebUI.waitForElementVisible(testObject, 20)

			WebUI.waitForElementClickable(testObject, 20)

			WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
			WebUI.click(testObject)

			break
		}
		
		if (j == waitTime) {
			KeywordUtil.markFailed(('Element ') + ' was never found')

			break
		}
	}
}