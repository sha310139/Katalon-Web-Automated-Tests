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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.78:8080/')

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_All Racks'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_48'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/button_Group Configuration'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/button_Add'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('Object Repository/Page_ TOAST/textarea_concat(Please Enter group  s name that you wanna add)_groupname_text'), GlobalVariable.G_Small_WaitTime)

int randomNum = Math.random() * 100;

String name = 'katalon_wei_'+ randomNum;

WebUI.setText(findTestObject('Object Repository/Page_ TOAST/textarea_concat(Please Enter group  s name that you wanna add)_groupname_text'), name)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_Main'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/h5_TestTimeSecs'), GlobalVariable.G_Small_WaitTime)

WebUI.scrollToElement(findTestObject('Object Repository/Page_ TOAST/input_Stressapptest_stressapptest'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/input_Stressapptest_stressapptest'), GlobalVariable.G_Small_WaitTime)

WebUI.scrollToElement(findTestObject('Object Repository/Page_ TOAST/input_TestTimeSecs_stressapptest_test_time'), GlobalVariable.G_Small_WaitTime)

smartWait(findTestObject('Object Repository/Page_ TOAST/input_TestTimeSecs_stressapptest_test_time'), GlobalVariable.G_Small_WaitTime)

WebUI.setText(findTestObject('Object Repository/Page_ TOAST/input_TestTimeSecs_stressapptest_test_time'), '180')

WebUI.scrollToElement(findTestObject('Object Repository/Page_ TOAST/input_LINPACK Benchmarks(runme_xeon64)_runme_xeon64'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/input_LINPACK Benchmarks(runme_xeon64)_runme_xeon64'), GlobalVariable.G_Small_WaitTime)

WebUI.scrollToElement(findTestObject('Object Repository/Page_ TOAST/input_Fio_fio'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/input_Fio_fio'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_Add'), GlobalVariable.G_Small_WaitTime)

WebUI.scrollToElement(findTestObject('Object Repository/Page_ TOAST/button_Close'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/button_Close'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_-_start-burnin btn'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/button_Start'), GlobalVariable.G_Small_WaitTime)

WebUI.delay(1)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_-_stop-burnin btn'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_ TOAST/button_Stop'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_-_group-setting btn'), GlobalVariable.G_Small_WaitTime)
 
smartWait(findTestObject('Object Repository/Page_ TOAST/td_katalon_wei_49'), GlobalVariable.G_Small_WaitTime)
 
WebUI.doubleClick(findTestObject('Object Repository/Page_ TOAST/td_katalon_wei_49'))

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_-_start-burnin btn'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/button_Start'), GlobalVariable.G_Small_WaitTime)

while(true) {
	// to wait for burnin finish
	CharSequence progressText = WebUI.getText(findTestObject('Object Repository/Page_ TOAST/td_Progress'))
	if (progressText.contains('Finish'))
		break
	else if (progressText.contains('timeout')) {  // Boot timeout
		KeywordUtil.markError("Boot timeout")
		KeywordUtil.logInfo("has timeout")
	} // else if
	WebUI.delay(60)
} // while

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_Stopped_report btn'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/a_Finish_download-report btn'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Object Repository/Page_ TOAST/span_'), GlobalVariable.G_Small_WaitTime)

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

