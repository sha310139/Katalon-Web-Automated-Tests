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

WebUI.navigateToUrl('https://172.200.200.7/24#login')

WebUI.setText(findTestObject('Page_AIC/input_Processing _userid'), 'ADMIN')

WebUI.setEncryptedText(findTestObject('Page_AIC/input_Processing _password'), 'XmnPW7mE0VA=')

WebUI.sendKeys(findTestObject('Page_AIC/input_Processing _password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('Page_AIC/a_Dashboard'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_Sensor'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_System Inventory'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_CPU Info'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_DIMM Info'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_FRU Information'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/span_Chassis Identify Control'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_Chassis Identify Control'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_Logs  Reports'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_IPMI Event Log0'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_User Log'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_Settings'), GlobalVariable.G_Small_WaitTime)

// ------------------------ just setting -------------------------


smartWaitAndClick(findTestObject('Page_AIC/div_Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Captured BSOD_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Date  Time_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_External User Services_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_LDAPE-directory Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_General Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_LDAPE-directory Settings_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Active directory Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_General Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Active Directory Settings_icon (1)'), GlobalVariable.G_Small_WaitTime)


smartWaitAndClick(findTestObject('Page_AIC/div_RADIUS Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_General RADIUS Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()
WebUI.back()



smartWaitAndClick(findTestObject('Page_AIC/div_External User Services_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()



// Log Setting
smartWaitAndClick(findTestObject('Page_AIC/div_KVM Mouse Setting_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Log Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Log Settings Policy_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()


// Media Setting
smartWaitAndClick(findTestObject('Page_AIC/div_Manage Licenses_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Media Redirection_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_General Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_VMedia Instance Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()


// Networking
smartWaitAndClick(findTestObject('Page_AIC/div_Media Redirection Settings_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Network Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Network Bond Configuration_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Network Link Configuration_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_DNS Configuration_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()

// PAM Order Setting
smartWaitAndClick(findTestObject('Page_AIC/div_Network Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

// Platform Event Filter
smartWaitAndClick(findTestObject('Page_AIC/div_PAM Order Settings_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Platform Event Filters_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Event Filters_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Alert Policies_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()


// SNMP
smartWaitAndClick(findTestObject('Page_AIC/div_SAS IT Management_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()


// Service
smartWaitAndClick(findTestObject('Page_AIC/div_SNMP setting_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

// SMTP setting
smartWaitAndClick(findTestObject('Page_AIC/div_Services_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

// SSL setting
smartWaitAndClick(findTestObject('Page_AIC/div_SMTP Settings_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_SSL Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_View SSL certificate_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Generate SSL certificate_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()


// System Firewall
smartWaitAndClick(findTestObject('Page_AIC/div_SSL Settings_icon_main'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_System Firewall_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_General Firewall Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Existing Firewall Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_General Firewall Settings_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_IP Firewall Rules_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Existing IP Rules_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_IP Address Firewall Rules_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Port Firewall Rules_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Existing Port Rules_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_System Firewall_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_User Management_icon'), GlobalVariable.G_Small_WaitTime)


smartWaitAndClick(findTestObject('Page_AIC/div_Video Recording_icon'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Auto Video Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Video Trigger Settings_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Video Remote Storage_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()
WebUI.back()
WebUI.back()

// ------------------------ just setting -------------------------

smartWaitAndClick(findTestObject('Page_AIC/a_Remote Control'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_Image Redirection'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/div_Image Redirection_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Local Images_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/a_Power Control'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_Maintenance'), GlobalVariable.G_Small_WaitTime)



smartWaitAndClick(findTestObject('Page_AIC/div_Maintenance_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Dual Image configuration_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Firmware Image Location_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Firmware Information_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Firmware Update_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_BIOS Firmware Update_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Preserve Configuration_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Restore Configuration_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_Restore Factory Defaults_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

smartWaitAndClick(findTestObject('Page_AIC/div_System Administrator_icon'), GlobalVariable.G_Small_WaitTime)
WebUI.back()

// -------------------------------- end first step -------------------------------------

// -------------------------------- second step -------------------------------------
smartWaitAndClick(findTestObject('Page_AIC/a_Chassis Identify Control'), GlobalVariable.G_Small_WaitTime)

for (int i = 0 ; i < 10 ; i++) {
	smartWaitAndClick(findTestObject('Page_AIC/input_Chassis Identify On_force_on'), GlobalVariable.G_Small_WaitTime)
	
	smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
	WebUI.acceptAlert()
	smartWaitAndClick(findTestObject('Page_AIC/input_Chassis Identify Off_force_on'), GlobalVariable.G_Small_WaitTime)

	smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
	WebUI.acceptAlert()
} // for
// -------------------------------- end second step -------------------------------------


// -------------------------------- third step -------------------------------------
smartWaitAndClick(findTestObject('Page_AIC/a_Logs  Reports'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_IPMI Event Log0'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/button_Download Event Logs'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/button_Clear Event Logs'), GlobalVariable.G_Small_WaitTime)
WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
WebUI.acceptAlert()
smartWaitAndClick(findTestObject('Page_AIC/a_User Log'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/button_Save User Logs'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/button_Clear User Logs'), GlobalVariable.G_Small_WaitTime)
WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
WebUI.acceptAlert()
// -------------------------------- end third step -------------------------------------


// -------------------------------- fourth step -------------------------------------
smartWaitAndClick(findTestObject('Page_AIC/a_Remote Control'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_ Launch KVM'), GlobalVariable.G_Small_WaitTime)

WebUI.switchToWindowTitle('Remote KVM')

//smartWaitAndClick(findTestObject('Page_AIC/span_You havenotifications_power_ctrl_btn'), GlobalVariable.G_Small_WaitTime)

//smartWaitAndClick(findTestObject('Page_AIC/span_You havenotifications_power_ctrl_btn'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Page_AIC/a_Stop KVM'), GlobalVariable.G_Small_WaitTime)

WebUI.switchToWindowTitle('AIC')
// -------------------------------- end fourth step -------------------------------------

// -------------------------------- fiveth step -------------------------------------
smartWaitAndClick(findTestObject('Page_AIC/a_Power Control'), GlobalVariable.G_Small_WaitTime)

for (int i = 0 ; i < 10 ; i++) {
	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_WaitTime)

	if (WebUI.getText(findTestObject('Page_AIC/div_Host is currently off')).equals('Host is currently on')) {
		WebUI.waitForElementNotVisible(findTestObject('Page_AIC/div_Performing Power Action Please Wait'), GlobalVariable.G_Small_WaitTime)
		WebUI.waitForElementClickable(findTestObject('Page_AIC/ins_Power Off_iCheck-helper'), GlobalVariable.G_Small_WaitTime)
		WebUI.click(findTestObject('Page_AIC/ins_Power Off_iCheck-helper'))
		smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
		WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
		WebUI.acceptAlert()
	} // if

	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementNotVisible(findTestObject('Page_AIC/div_Performing Power Action Please Wait'), GlobalVariable.G_Small_WaitTime)
	smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
	WebUI.acceptAlert()

	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementNotVisible(findTestObject('Page_AIC/div_Performing Power Action Please Wait'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementClickable(findTestObject('Page_AIC/ins_Power Off_iCheck-helper'), GlobalVariable.G_Small_WaitTime)
	WebUI.click(findTestObject('Page_AIC/ins_Power Off_iCheck-helper'))
	smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
	WebUI.acceptAlert()

	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementNotVisible(findTestObject('Page_AIC/div_Performing Power Action Please Wait'), GlobalVariable.G_Small_WaitTime)
	smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
	WebUI.acceptAlert()

	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementNotVisible(findTestObject('Page_AIC/div_Performing Power Action Please Wait'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementClickable(findTestObject('Page_AIC/ins_Power Cycle_iCheck-helper'), GlobalVariable.G_Small_WaitTime)
	WebUI.click(findTestObject('Page_AIC/ins_Power Cycle_iCheck-helper'))
	smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
	WebUI.acceptAlert()

	
	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementNotVisible(findTestObject('Page_AIC/div_Performing Power Action Please Wait'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementClickable(findTestObject('Page_AIC/ins_Hard Reset_iCheck-helper'), GlobalVariable.G_Small_WaitTime)
	WebUI.click(findTestObject('Page_AIC/ins_Hard Reset_iCheck-helper'))
	smartWaitAndClick(findTestObject('Page_AIC/a_ Perform Action'), GlobalVariable.G_Small_WaitTime)
	WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
	WebUI.acceptAlert()

	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_WaitTime)
	WebUI.waitForElementNotVisible(findTestObject('Page_AIC/div_Performing Power Action Please Wait'), GlobalVariable.G_Small_WaitTime)
} // for
// -------------------------------- end fiveth step -------------------------------------

smartWaitAndClick(findTestObject('Page_AIC/a_Sign out'), GlobalVariable.G_Small_WaitTime)
WebUI.waitForAlert(GlobalVariable.G_Small_WaitTime)
WebUI.acceptAlert()


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

