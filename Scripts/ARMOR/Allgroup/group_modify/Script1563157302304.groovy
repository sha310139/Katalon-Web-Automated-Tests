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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/?next=/en-us/')

WebUI.setText(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ ARMOR/input_Login_password'), Keys.chord(
        Keys.ENTER))

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/a_All Groups'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/a_All Groups_1'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/input_gegegege_pk'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/button_Modify Group'), GlobalVariable.G_Small_Timeout)

WebUI.setText(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/input__form-control group-name'), 'katalon-test222')

WebUI.setText(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/textarea_Description_form-control group-desc'), 
    '1222')

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/button_Modify'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Small_Timeout)

smartWait(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/p_Modify Group Success'), GlobalVariable.G_Small_Timeout)

WebUI.delay(1)

if (!WebUI.getText(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/p_Modify Group Success')).equals('Modify Group Success') ) {
	KeywordUtil.markFailed('Modify Group failed')
} // if

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_modify/Page_ARMOR/button_'), GlobalVariable.G_Small_Timeout)

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

