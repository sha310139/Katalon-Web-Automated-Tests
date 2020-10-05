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

WebUI.navigateToUrl('https://172.200.200.7/#login')

WebUI.setText(findTestObject('Page_AIC_server/input_Processing _userid'), 'ADMIN')

WebUI.setEncryptedText(findTestObject('Page_AIC_server/input_Processing _password'), 'XmnPW7mE0VA=')

WebUI.sendKeys(findTestObject('Page_AIC_server/input_Processing _password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('Page_AIC_server/a_Power Control'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('Page_AIC_server/Status'), GlobalVariable.G_Small_WaitTime)

if (WebUI.getText(findTestObject('Page_AIC_server/Status')).equals('Host is currently on')) {
    WebUI.waitForElementClickable(findTestObject('Page_AIC_server/ins_Power Off_iCheck-helper_1'), GlobalVariable.G_Small_WaitTime)
    WebUI.click(findTestObject('Page_AIC_server/ins_Power Off_iCheck-helper_1'))
} // if
    

smartWaitAndClick(findTestObject('Page_AIC_server/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
WebUI.waitForAlert(10)

WebUI.acceptAlert()

WebUI.delay(10)

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



