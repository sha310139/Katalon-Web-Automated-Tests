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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://172.200.200.5/24#login')

WebUI.setText(findTestObject('IPMITestProject/input_Processing _userid'), 'ADMIN')

WebUI.setEncryptedText(findTestObject('IPMITestProject/input_Processing _password'), 'XmnPW7mE0VA=')

smartWaitClickableAndClick(findTestObject('IPMITestProject/button_Sign me in'), 20) 

smartWaitClickableAndClick(findTestObject('Object Repository/IPMITestProject/Dashboard'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Sensor'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/a_System Inventory'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/span_CPU Info'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/span_DIMM Info'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/span_FRU Information'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/span_Chassis Identify Control'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Logs  Reports'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/span_IPMI Event Log'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/a_User Log'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

'Camera'
smartWaitClickableAndClick(findTestObject('IPMITestProject/div_Settings_icon'),20) 

'BackToSetting'
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

smartWaitClickableAndClick(findTestObject('IPMITestProject/div_Captured BSOD_icon'),20) // 'date&time'
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

smartWaitClickableAndClick(findTestObject('IPMITestProject/div_Date  Time_icon'),20) // External User Services 


smartWaitClickableAndClick(findTestObject('IPMITestProject/div_External User Services_icon'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/div_LDAPE-directory Settings_icon'),20) // General LDAP Settings 

'BackToSetting'
WebUI.navigateToUrl('https://172.200.200.5/24#settings/ext_users/ldap')

smartWaitClickableAndClick(findTestObject('IPMITestProject/div_General Settings_icon'),20) // Role Groups 

'BackToSetting'
WebUI.navigateToUrl('https://172.200.200.5/24#settings/ext_users')

'active_directory'

smartWaitClickableAndClick(findTestObject('Object Repository/IPMITestProject/ActivedirectorySettings'),20)
smartWaitClickableAndClick(findTestObject('Object Repository/IPMITestProject/myObj/ActivedirectorySettings_GS'),20)
'BackToSetting'
WebUI.navigateToUrl('https://172.200.200.5/24#settings/ext_users/active_directory')
smartWaitClickableAndClick(findTestObject('Object Repository/IPMITestProject/myObj/ActivedirectorySettings_RG'),20)



'BackToSetting'
WebUI.navigateToUrl('https://172.200.200.5/24#settings/ext_users')

smartWaitClickableAndClick(findTestObject('IPMITestProject/div_Active Directory Settings_icon (1)'),20)

smartWaitClickableAndClick(findTestObject('IPMITestProject/div_RADIUS Settings_icon'),20)

'BackToSetting'
WebUI.navigateToUrl('https://172.200.200.5/24#settings/ext_users/radius')

smartWaitClickableAndClick(findTestObject('IPMITestProject/div_General RADIUS Settings_icon'),20)
// ---------------External User Services fnish
'BackToSetting'
WebUI.navigateToUrl('https://172.200.200.5/24#settings')
//---------ok----------

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/KVMMouseSetting') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Log Settings') ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Log Settings Policy') ,20)

WebUI.back()

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Advanced Log Settings') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Media Redirection') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/General Settings') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/VMedia Instance Settings') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Remote Session') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Network Settings') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Network IP Settings') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Network Link Configuration') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/DNS Configuration') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Sideband Interface (NC-SI)') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/PAM Order') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Platform Event Filters') ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Event Filters') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Alert Policies') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/LAN Destinations') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/SNMP setting') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Services') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/SMTP Settings') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/SSL Settings') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/View SSL Certificate') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Generate SSL Certificate') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Upload SSL Certificate') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/System Firewall') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/General Firewall Settings') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Existing Firewall Settings') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Add Firewall Settings') ,20)
WebUI.back()
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/IP Firewall Rules') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Existing IP Rules') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Add New IP Rule') ,20)
WebUI.back()
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Port Firewall Rules') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Existing Port Rules') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Add New Port Rule') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/User Management') ,20)
smartWaitClickableAndClick(findTestObject('IPMITestProject/a_Settings'),20) // https://172.200.200.5/24#settings
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Video Recording') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Auto Video Settings') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Video Trigger Settings') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Video Remote Storage') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Pre-Event Video Recordings') ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Remote Control') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Image Redirection') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Local Media') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Remote Media') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Power Control') ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Maintenance') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Backup Configuration') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Firmware Image Location') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Firmware Information ') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Firmware Update'),20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/BIOS Firmware Update') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Preserve Configuration') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Restore Configuration') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Restore Factory Defaults') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/System Administrator') ,20)
WebUI.back()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/BIOS POST Code') ,20)

// 2

smartWaitClickableAndClick(findTestObject('IPMITestProject/span_Chassis Identify Control'),20)
int stepNum = 0
for(int i = 0 ; i < 10 ; i++){
	if(stepNum == 0){
		smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/input_Chassis Identify On_force_on') ,20)
		stepNum = 1
	}
	else{
		smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/input_Chassis Identify Off_force_on') ,20)
		stepNum = 0
	}
	
	smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/Chassis_ Perform Action') ,20)
	WebUI.acceptAlert()
	WebUI.delay(1)
	
}

//3


smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/LogsAndReports') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/IPMI Event Log') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/button_Download Event Logs') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/button_Clear Event Logs') ,20)
WebUI.acceptAlert()
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/User Log') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/button_Save User Logs') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/button_Clear User Logs') ,20)
WebUI.acceptAlert()

//4

WebUI.delay(5)
smartWaitClickableAndClick(findTestObject('Object Repository/IPMITestProject/myObj/Remote Control'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/IPMITestProject/myObj/Launch KVM'), 20)

WebUI.switchToWindowTitle('Remote KVM')

WebUI.click(findTestObject('Object Repository/IPMITestProject/a_Stop KVM'))

//5
 
 
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
		stepnum = 2
	}
	else if(stepnum == 2){
		if(WebUI.getText(findTestObject('Object Repository/IPMITestProject/myObj/PowerStatus')).equals("Host is currently off")){
			WebUI.waitForElementClickable(findTestObject('Object Repository/IPMITestProject/ins_Power On_iCheck-helper'), 20)
			WebUI.click( findTestObject('Object Repository/IPMITestProject/ins_Power On_iCheck-helper'))
			WebUI.delay(5)
			smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/PowerCtl_ Perform Action') ,3600)
			WebUI.acceptAlert()
			
			WebUI.waitForJQueryLoad(20)
			WebUI.waitForElementNotVisible(findTestObject('Object Repository/IPMITestProject/div_Performing Power Action Please Wait'),1000, FailureHandling.OPTIONAL)
			WebUI.waitForJQueryLoad(20)
		}
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/IPMITestProject/ins_Power Cycle_iCheck-helper'), 20)
		WebUI.click( findTestObject('Object Repository/IPMITestProject/ins_Power Cycle_iCheck-helper') )
		smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/PowerCtl_ Perform Action') ,3600)
		WebUI.acceptAlert()
		
		stepnum = 3
	}
	else if(stepnum == 3){
		if(WebUI.getText(findTestObject('Object Repository/IPMITestProject/myObj/PowerStatus')).equals("Host is currently off")){
			WebUI.waitForElementClickable(findTestObject('Object Repository/IPMITestProject/ins_Power On_iCheck-helper'), 20)
			WebUI.click( findTestObject('Object Repository/IPMITestProject/ins_Power On_iCheck-helper'))
			WebUI.delay(5)
			smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/PowerCtl_ Perform Action') ,3600)
			WebUI.acceptAlert()
			
			WebUI.waitForJQueryLoad(20)
			WebUI.waitForElementNotVisible(findTestObject('Object Repository/IPMITestProject/div_Performing Power Action Please Wait'),1000, FailureHandling.OPTIONAL)
			WebUI.waitForJQueryLoad(20)
		}
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/IPMITestProject/ins_Hard Reset_iCheck-helper'), 20)
		WebUI.click( findTestObject('Object Repository/IPMITestProject/ins_Hard Reset_iCheck-helper') )
		smartWaitClickableAndClick( findTestObject('Object Repository/IPMITestProject/myObj/PowerCtl_ Perform Action') ,3600)
		WebUI.acceptAlert()
		
		performNum++
		
		stepnum = 0
	}
	
	
	
}


WebUI.comment('success')

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

