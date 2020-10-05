import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
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

			WebUI.waitForJQueryLoad(20)

			WebUI.click(testObject)

			break
		}
		
		if (j == waitTime) {
			KeywordUtil.markFailed(('Element ' + testObject.toString()) + ' was never found')

			break
		}
	}
}

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://172.200.200.5/24#login')

WebUI.setText(findTestObject('IPMITestProject/input_Processing _userid'), 'ADMIN')

WebUI.setEncryptedText(findTestObject('IPMITestProject/input_Processing _password'), 'XmnPW7mE0VA=')

smartWaitClickableAndClick(findTestObject('IPMITestProject/button_Sign me in'), 20)

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Power Control') ,20)

int stepnum


if(WebUI.getText(findTestObject('Object Repository/IPMITestProject/myObj/PowerStatus')).equals("Host is currently on")){
	stepnum = 1
}
else{
	stepnum = 0
}

int performNum = 0
while( performNum < 10 ){
	WebUI.waitForJQueryLoad(20)
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/IPMITestProject/div_Performing Power Action Please Wait'),1000, FailureHandling.OPTIONAL)
	WebUI.waitForJQueryLoad(20)
	if( stepnum == 0 ){
		WebUI.waitForElementClickable(findTestObject('Object Repository/IPMITestProject/ins_Power On_iCheck-helper'), 20)
		WebUI.click( findTestObject('Object Repository/IPMITestProject/ins_Power On_iCheck-helper'))
		smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/PowerCtl_ Perform Action') ,3600)
		WebUI.acceptAlert()
		stepnum = 1
	}
	else if( stepnum == 1 ){
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/IPMITestProject/ins_Power Off_iCheck-helper'), 20)
		WebUI.click( findTestObject('Object Repository/IPMITestProject/ins_Power Off_iCheck-helper'))
		smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/PowerCtl_ Perform Action') ,3600)
		WebUI.acceptAlert()
		stepnum = 0
		performNum++
	}
	
}

WebUI.closeBrowser()