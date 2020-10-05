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

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/?next=/en-us/')

WebUI.setText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ ARMOR/input_Login_password'), Keys.chord(Keys.ENTER))

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_All Racks'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_Venus-Rack'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_CPNODE'), GlobalVariable.G_Small_Timeout)

// ---------------------------------- BIOS ----------------------------------------

for (int i = 0 ; i < 2 ; i++) {

	WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Update BIOS'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Update BIOS firmware via BMC_update-bios-protocol'), GlobalVariable.G_Small_Timeout)
	
	// force_update checkbox
	if ((i % 2) == 0) {
        // first & third -> uncheck force_update
        smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)

        WebUI.uncheck(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'))

        WebUI.verifyElementNotChecked(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout) 
	} // if

	// second & fourth -> check force_update
	else {
		smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)

		WebUI.check(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'))

		WebUI.verifyElementChecked(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
	} // else
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Submit_update'), GlobalVariable.G_Small_Timeout)

	WebUI.waitForJQueryLoad(GlobalVariable.G_Small_Timeout)	

	while (!WebUI.waitForElementClickable(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)) {
		WebUI.delay(30)
	} // while

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)

	WebUI.delay(3)
	smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/messege'), GlobalVariable.G_Small_Timeout)

	if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/messege')).equals('Update BIOS Firmware Complete') ) {
		KeywordUtil.markFailed('update BIOS failed')
	} // if

	if (WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Warning')).equals('Warning')) {
		//KeywordUtil.markFailed('Warning')
		KeywordUtil.markFailed("Warning")
	} // if
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_'), GlobalVariable.G_Small_Timeout)
} // end for

// ---------------------------------- end BIOS ----------------------------------------
/*
// ---------------------------------- BMC ----------------------------------------

for (int i = 0 ; i < 4 ; i++) {
	WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)
	
	// check current version
	version = WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/td_BMC_Version'))
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)

	WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Update BMC'), GlobalVariable.G_Small_Timeout)
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Update BMC'), GlobalVariable.G_Small_Timeout)
	
	// choose version
	if (version.equals('PA36M001.6')) {
		smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), GlobalVariable.G_Small_Timeout)
		WebUI.selectOptionByValue(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), '1', true)
		// choose version 15
	} // if
	else {
		smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), GlobalVariable.G_Small_Timeout)
		WebUI.selectOptionByValue(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/select_AIAQN0111PA36M0016PA36M0015'), '13', true)
		// choose version 16
	} // else
	
	
	// force_update checkbox
	if (i % 2 == 0) {  // first & third -> uncheck force_update
		smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
		WebUI.uncheck(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'))
		WebUI.verifyElementNotChecked(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
	} // if
	else {		// second & fourth -> check force_update
		smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
		WebUI.check(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'))
		WebUI.verifyElementChecked(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Force update_force-update'), GlobalVariable.G_Small_Timeout)
	} // else
	
	if (i < 2) {	  // first & second -> preserve
		smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Preserve configurations_keep-bmc-config'), GlobalVariable.G_Small_Timeout)
	} // if
	else {			  // third & fourth -> overwrite all
		smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Overwrite all configurations_keep-bmc-config'), GlobalVariable.G_Small_Timeout)
	} // else
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Submit_update'), GlobalVariable.G_Small_Timeout)
	
	while (!WebUI.waitForElementClickable(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)) {
		WebUI.delay(30)
	} // while
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)
	
	smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/messege'), GlobalVariable.G_Small_Timeout)
	WebUI.delay(3)
	if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/messege')).equals('Update BMC Firmware Complete') ) {
		KeywordUtil.markFailed('update BMC failed')
	} // if
	
	if (WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Warning')).equals('Warning')) {
		KeywordUtil.markFailed("Warning")
	} // if
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_'), GlobalVariable.G_Small_Timeout)
} // for

// ---------------------------------- end BMC ----------------------------------------
*/
// ---------------------------------- Power ----------------------------------------

for (int i = 0 ; i < 5 ; i++) {
	
	WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Large_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Power Control'), GlobalVariable.G_Large_Timeout)

	switch(i) {
		case 0:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Power On_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 1:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Power Off_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 2:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Power On_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 3:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Power Reset_power-action'), GlobalVariable.G_Large_Timeout)
			break
		case 4:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Power Cycle_power-action'), GlobalVariable.G_Large_Timeout)
			break
		default:
			smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Power On_power-action'), GlobalVariable.G_Large_Timeout)
	} // switch
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Submit_powerContorl'), GlobalVariable.G_Large_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)


	smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete'), GlobalVariable.G_Small_Timeout)
	WebUI.delay(3)
	
	switch(i) {
		case 0:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete')).equals('Power On Complete') ) {
				KeywordUtil.markFailed('Power On failed')
			} // if
			break
		case 1:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete')).equals('Power Off Complete') ) {
				KeywordUtil.markFailed('Power Off failed')
			} // if
			break
		case 2:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete')).equals('Power On Complete') ) {
				KeywordUtil.markFailed('Power On failed')
			} // if
			break
		case 3:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete')).equals('Power Reset Complete') ) {
				KeywordUtil.markFailed('Power Reset failed')
			} // if
			break
		case 4:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete')).equals('Power Cycle Complete') ) {
				KeywordUtil.markFailed('Power Cycle failed')
			} // if
			break
		default:
			if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete')).equals('Power On Complete') ) {
				KeywordUtil.markFailed('Power On failed')
			} // if
	} // switch
	
	if (WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Information')).equals('Warning')) {
		KeywordUtil.markFailed("Warning")
	} // if

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_'), GlobalVariable.G_Large_Timeout)
} // end for

// ---------------------------------- end Power ----------------------------------------

/*
// ---------------------------------- LED ----------------------------------------

WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_WaitTime)
smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_LED_CPnode'), GlobalVariable.G_Small_WaitTime)
	
	
smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_ON_id-led-switch'), GlobalVariable.G_Small_WaitTime)
	
smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Submit'), GlobalVariable.G_Small_WaitTime)
	
smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Small_WaitTime)
	
smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Warning'), GlobalVariable.G_Small_WaitTime)
	
WebUI.delay(1)
	
if (WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Warning')).equals('Warning') ) {
	KeywordUtil.markFailed('Warning')
} // if
	
smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete'), GlobalVariable.G_Small_WaitTime)
	
WebUI.delay(1)
	
if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Turn On LED Complete')).equals('Turn On LED Complete') ) {
	KeywordUtil.markFailed('Turn On LED failed')
} // if

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)

// ---------------------------------- end LED ----------------------------------------
*/
// ---------------------------------- get inventory ----------------------------------------

for (int i = 0 ; i < 2 ; i++) {

	WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_WaitTime)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Get Inventory'), GlobalVariable.G_Small_WaitTime)
	if ( i % 2 == 0 ) {
		smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Reset_power-control'), GlobalVariable.G_Small_WaitTime)
	} // if
	else {
		smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_Power OFF_power-control'), GlobalVariable.G_Small_WaitTime)
	} // else
	
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Submit_inventory'), GlobalVariable.G_Small_WaitTime)

	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)

	smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Information'), GlobalVariable.G_Small_WaitTime)

	WebUI.delay(1)

	if (WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Information')).equals('Warning') ) {
		KeywordUtil.markFailed('Warning')
	} // if

	smartWait(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Get Inventory Complete'), GlobalVariable.G_Small_WaitTime)

	WebUI.delay(1)

	if (!WebUI.getText(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Get Inventory Complete')).equals('Get Inventory Complete') ) {
		KeywordUtil.markFailed('Get Inventory failed')
	} // if

	WebUI.delay(3)
	smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)
} // end for

WebUI.scrollToElement(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/input_PAVR1001_btSelectItem'), GlobalVariable.G_Small_Timeout)
smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/img_PA36M0016_center'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_FRU'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_CPU'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_DIMM'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_HDD'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_Intel NIC'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_Mellanox NIC'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/li_HBA'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_HBA'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_MegaRAID'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/a_Expander'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Set as Default'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/p_Set Default Inventory Success'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('single_rack/Page_ARMOR_single_CPnode/Page_ARMOR/button_info'), GlobalVariable.G_Small_WaitTime)




// ---------------------------------- end get inventory ----------------------------------------

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
