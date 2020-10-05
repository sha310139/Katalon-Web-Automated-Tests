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
//def info = ['Username': '', 'Description':'', 'Email': '', 'Password': '', 'Confirm Password' : '']

data = TestDataFactory.findTestData("Data Files/userData")

WebUI.openBrowser('')

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/')

WebUI.setText(findTestObject('CreateUser/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('CreateUser/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

smartWaitClickableAndClick(findTestObject('CreateUser/Page_ ARMOR/button_Login'),20)


int userID = 0
int numOfUser = 8

for(  ; userID < numOfUser ; userID++ ){
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/a_Configuration'),20)
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/a_Role and Permission Management'),20)
	
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/a_Create Role'),20)
	
	WebUI.setText(findTestObject('CreateUser/Page_ARMOR/input_Role name_role-name'), data.getValue(1, userID+2))
	
	WebUI.setText(findTestObject('CreateUser/Page_ARMOR/input_Description_role-desc'), data.getValue(1, userID+2))
	
	smartWaitClickableAndClick(findTestObject('Object Repository/CreateUser/Page_ARMOR/button_Next'),20)
	
	
	
	
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/input_Can add rack_can_add_rack'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/input_Can delete rack_can_del_rack'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/input_Can import rack_can_import_rack'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/input_Can modify rack_can_modify_rack'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/input_Can scan rack_can_scan_rack'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/input_Can set maintain mode_can_set_maintain_mode'),20)
	
	smartWaitClickableAndClick(findTestObject('Object Repository/CreateUser/Page_ARMOR/button_Next'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/button_Finish'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/button_Close'),20)
	
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/a_Configuration'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/a_User Management'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/a_Add User'),20)
	
	
	
	
	
	
	WebUI.setText(findTestObject('CreateUser/Page_ARMOR/input_Username_name'), data.getValue(1, userID+2))
	
	WebUI.setText(findTestObject('CreateUser/Page_ARMOR/input_Description_desc'), data.getValue(2, userID+2))
	
	WebUI.setText(findTestObject('CreateUser/Page_ARMOR/input_Email_email'), data.getValue(3, userID+2))
	
	WebUI.setText(findTestObject('CreateUser/Page_ARMOR/input_Password_passwd'), data.getValue(4, userID+2))
	
	WebUI.setText(findTestObject('CreateUser/Page_ARMOR/input_Confirm Password_cfpasswd'), data.getValue(5, userID+2))
	
	'addUserNext'
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/button_Next (1)'),20)
	
	boolean hasFind = false
	int trNum = 1
	while(!hasFind ){
		checkNameObject = new TestObject("check role"+userID)
		checkNameObject.setParentObject(findTestObject('Object Repository/CreateUser/Page_ARMOR/iframe_Continue_1562752228593'))
		checkNameObject.addProperty("xpath", ConditionType.EQUALS, "//div[@id='form-step-1']/div/div/div/div[2]/div[2]/table/tbody/tr["+trNum+"]/td[2]", true)
		
		if( WebUI.getText(checkNameObject).equals(data.getValue(1, userID+2) ) ){
			selectNameObject = new TestObject("select role"+userID)
			checkNameObject.addProperty("xpath", ConditionType.EQUALS, "(//input[@name='btSelectItem'])["+trNum+"]", true)
			smartWaitClickableAndClick(checkNameObject, 20)
			hasFind = true
		}
		
		trNum++
	}
	
	
	//smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/input_Description_btSelectItem'),20)
	
	smartWaitClickableAndClick(findTestObject('CreateUser/Page_ARMOR/button_Next (1)'),20)
	
	smartWaitClickableAndClick(findTestObject('Object Repository/CreateUser/Page_ARMOR/button_Finish (1)'),20)
	
	smartWaitClickableAndClick(findTestObject('Object Repository/CreateUser/Page_ARMOR/button_Close (1)'),20)
}



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