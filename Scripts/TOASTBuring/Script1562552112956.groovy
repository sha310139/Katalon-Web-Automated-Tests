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
			WebUI.scrollToElement(testObject, 5)
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
			/*
			try{
				WebUI.click(testObject)
			}
			catch(Exception ex){
				WebUI.scrollToElement
			}
			*/
			break
		}
		if(j==waitTime){
			KeywordUtil.markFailed('Element ' + testObject.toString() + ' was never found')
			break
		}
	}
}



WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://192.168.42.78:8080/')

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/a_All Racks'),20)

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/a_48'),20)
int randomNum = Math.random()*100
String groupName = "Katalon_yan"+randomNum

// ok

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/button_Group Configuration'),20)

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/button_Add'),20)


WebUI.setText(findTestObject('TOASTProject/Page_ TOAST/textarea_concat(Please Enter group  s name that you wanna add)_groupname_text'), 
    groupName)

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/input_Stressapptest_stressapptest'),20)

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/h5_TestTimeSecs'),20)

WebUI.setText(findTestObject('TOASTProject/Page_ TOAST/input_TestTimeSecs_stressapptest_test_time'), '80')

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/input_LINPACK Benchmarks(runme_xeon64)_runme_xeon64'),20)

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/input_Fio_fio'),20)

smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/a_Add'),20)

'endGroup'
smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/button_Close'),20)


//smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/input_katalon_btSelectItem'),20) // select box 15B
smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/Page_ TOAST/Page_ TOAST/input_Global_btSelectItem15A'),20) // select box 

WebUI.delay(1)
'burning'

/*
smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/a_Finish_start-burnin btn'),20)
smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/button_checkStart'),20)
WebUI.delay(2)
smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/a_Finish_stop-burnin btn'),20)
smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/button_checkStop'),20)
*/

 // ok
smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/Page_ TOAST/Page_ TOAST/a_-_group-setting btn15A'),20)

WebUI.delay(1)

int tdNum = 1
boolean isTail = false
while(!isTail){
	try{
		myNewObject = new TestObject("Group"+tdNum)
		myNewObject.addProperty("xpath", ConditionType.EQUALS, "id('grouptable')/tbody[1]/tr["+tdNum+"]/td[1]", true)
		if(WebUI.getText(myNewObject).equalsIgnoreCase(groupName)){
			WebUI.doubleClick(myNewObject)
			isTail = true
		}
	}
	catch(Exception ex){
		isTail = true
	}
	tdNum++
	
	WebUI.delay(1)
}


smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/Page_ TOAST/Page_ TOAST/a_-_start-burnin btn15A'),20)
smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/button_checkStart'),20)
 

boolean end = false


while(!end){
	
	try{
		//WebUI.scrollToElement(findTestObject('Object Repository/TOASTProject/Page_ TOAST/Page_ TOAST/Page_ TOAST/td_15Atext'))
		fnishObject = new TestObject("fnish")
		fnishObject.addProperty("xpath", ConditionType.EQUALS, "//table[@id='table']/tbody/tr[21]/td[9]/span", true)
		CharSequence status = WebUI.getText(fnishObject)
		WebUI.comment(status)
		if(status.contains('Finish')){
			end = true
		}
		else if(status.contains('timeout')){
			end = true
		}
		else{
			WebUI.delay(60)
		}
		
	}
	catch(Exception ex){
		WebUI.delay(60)
	}
	
	//WebUI.comment(WebUI.getText(findTestObject('Object Repository/TOASTProject/Page_ TOAST/Page_ TOAST/td_status_text15B')))
	
}


smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/Page_ TOAST/Page_ TOAST/a_-_report btn15A'),20)
 
smartWaitClickableAndClick(findTestObject('TOASTProject/Page_ TOAST/input_Operation_btSelectItem'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/button_Download'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/TOASTProject/Page_ TOAST/button_Close2'),20)


WebUI.delay(5)
//WebUI.closeBrowser()

