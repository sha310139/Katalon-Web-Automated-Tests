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
import com.kms.katalon.core.util.KeywordUtil

def smartWaitClickableAndClick(TestObject testObject, int waitTime){
	for (int j = 0; j <= waitTime; j++) {
		if(!(
			WebUI.verifyElementClickable(testObject, FailureHandling.OPTIONAL)
			&& WebUI.verifyElementVisible(testObject, FailureHandling.OPTIONAL)
			&& WebUI.verifyElementPresent(testObject, 5, FailureHandling.OPTIONAL))
		){
			WebUI.comment('Element ' + testObject.toString() + ' is not ready.')
			WebUI.delay(1)
			//continue
		}else{
			WebUI.comment(testObject.toString() + ' is ready')
			WebUI.waitForElementPresent(testObject, 5)
			WebUI.waitForElementVisible(testObject, 5)
			WebUI.waitForElementClickable(testObject, 5)
			WebUI.waitForJQueryLoad(20)
			WebUI.click(testObject)
			return true
			break
		}
		if(j==waitTime){
			try{
				KeywordUtil.markFailed('Element ' + testObject.toString() + ' was never found')
			}
			catch(Exception ex){
				
			}
			
			return false
			break
		}
	}
}


WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/')
WebUI.waitForElementVisible(findTestObject('LEDProject/Page_ ARMOR/input_Login_username'), 20)
WebUI.setText(findTestObject('LEDProject/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('LEDProject/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

smartWaitClickableAndClick(findTestObject('LEDProject/Page_ ARMOR/button_Login'),20)

smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/input_RMC2 IP_btSelectItem'),20)


smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_Enter Maintain Mode'),20)


smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_Submit'),20)


smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_Show Detail'),20)


WebUI.waitForJQueryLoad(20)
WebUI.waitForElementVisible(findTestObject('LEDProject/Page_ARMOR/checkSuccess'), 20)
WebUI.delay(1)

if(WebUI.getText(findTestObject('LEDProject/Page_ARMOR/checkSuccess')).equals("Enter Maintain Mode Success")){
	WebUI.comment('success')
    smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_'),20) // close
	WebUI.delay(1)
	WebUI.waitForElementVisible(findTestObject('LEDProject/Page_ARMOR/a_Venus-Rack'), 20)
    WebUI.delay(1)
	
	smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/a_Venus-Rack'),20)
	/*
	smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/a_CPNODE'),20)
	WebUI.waitForElementVisible(findTestObject('LEDProject/Page_ARMOR/a_CPNODE'), 20)
	WebUI.waitForElementClickable(findTestObject('LEDProject/Page_ARMOR/a_CPNODE'), 20)
	*/
	//WebUI.click(findTestObject('LEDProject/Page_ARMOR/a_CPNODE'))
	smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/a_CPNODE'),300)
	WebUI.delay(1)

	//47
	boolean needToStop = false
	int num = 47
	while(!needToStop){
		
		
		
		
		
		try{
						String selectNum = Integer.toString(num)
			
						myNewObject = new TestObject("CheckBox"+selectNum)
						myNewObject.addProperty("xpath", ConditionType.EQUALS, "(//input[@name='btSelectItem'])["+selectNum+"]", true)
						
						WebUI.scrollToElement(myNewObject, 6)
						/*
						WebUI.waitForElementVisible(myNewObject, 20)
						WebUI.click(myNewObject)
						*/
						smartWaitClickableAndClick(myNewObject,20)
						
						smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_LED'),20)
						
						smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/input_ON_id-led-switch'),20)
						//smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/Page_ARMOR/input_OFF_id-led-switch'),20)
					
						smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_Submit_1'),20)
	
			//WebUI.delay(5)
		}
		catch(Exception ex){
			needToStop = true
		}
		try{
			smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_Show Detail_1'),40)
			WebUI.delay(2)
			smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_1'),20)
			num++
		}
		catch(Exception ex){
			
		}
		
		
		
	}
	
}
else{
	smartWaitClickableAndClick(findTestObject('LEDProject/Page_ARMOR/button_'),20)
}

//WebUI.closeBrowser()

