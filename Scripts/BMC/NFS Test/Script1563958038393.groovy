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

smartWaitClickableAndClick(findTestObject('Object Repository/BMC_Obj/NFS/div_Manage Licenses_icon'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/BMC_Obj/NFS/div_Media Redirection_icon'), 20)


WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.scrollToElement(findTestObject('Object Repository/BMC_Obj/NFS/ins_Remote Media Support_iCheck-helper'), 5)
if( WebUI.verifyElementNotChecked(findTestObject('Object Repository/BMC_Obj/NFS/ins_Remote Media Support_iCheck-helper'), 20) ){
	
	WebUI.check(findTestObject('Object Repository/BMC_Obj/NFS/ins_Remote Media Support_iCheck-helper'))
}


WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.scrollToElement(findTestObject('Object Repository/BMC_Obj/NFS/ins_Mount CDDVD_iCheck-helper'), 5)
if( WebUI.verifyElementNotChecked(findTestObject('Object Repository/BMC_Obj/NFS/ins_Mount CDDVD_iCheck-helper'), 20) ){
	
	WebUI.check(findTestObject('Object Repository/BMC_Obj/NFS/ins_Mount CDDVD_iCheck-helper'))
	
	WebUI.setText(findTestObject('Object Repository/BMC_Obj/NFS/input_Server Address for CDDVD Images_idcd_remote_server_address'), '172.200.200.21')
	WebUI.setText(findTestObject('Object Repository/BMC_Obj/NFS/input_Path in server_idcd_remote_source_path'), '/tmp')
}



WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.scrollToElement(findTestObject('Object Repository/BMC_Obj/NFS/ins_nfs_iCheck-helper'), 5)
if( WebUI.verifyElementNotChecked(findTestObject('Object Repository/BMC_Obj/NFS/ins_nfs_iCheck-helper'), 20) ){
	
	WebUI.check(findTestObject('Object Repository/BMC_Obj/NFS/ins_nfs_iCheck-helper'))
}



smartWaitClickableAndClick(findTestObject('Object Repository/BMC_Obj/NFS/a_ Save'), 20)

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

