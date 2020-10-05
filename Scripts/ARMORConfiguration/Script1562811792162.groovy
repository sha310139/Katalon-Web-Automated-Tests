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

//WebUI.openBrowser('C:\\myWork\\logo\\test.png')

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('http://192.168.42.162/en-us/login/')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Object Repository/ARMORConfiguration/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ ARMOR/button_Login'),20)

// Service Host
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Host Server Configurations'),20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Hostname_hostname'), 'armor-computex1')

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Upload Logo'),20)


WebUI.waitForJQueryLoad(20)
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/ARMORConfiguration/HostServer/input_Browse _uploadfp'), 'C:\\myWork\\logo\\test.png')


smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Upload'),20)
WebUI.delay(3) // wait uploading
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Close'), 20)

//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/ARMORConfiguration/HostServer/button_Restore LOGO')) // if you want to restore

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/HostServer/close'), 20)


//---------DHCP------------

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_DHCP Service Configurations'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Enable DHCP Server_enable-dhcp-server'),20)
WebUI.delay(3)
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Enable DHCP Server_enable-dhcp-server'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Submit'),20)

try{
	smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/DHCP/button_Show Detail') ,20)
	
	WebUI.waitForJQueryLoad(20)
	WebUI.delay(1)
	smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/DHCP/logClose') ,20)
}
catch(Exception ex){
	
}


'close DHCP window'
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/DHCP/DHCP Close'),20)

//-----------Notification------------


smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Notification Configurations'), 20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__smtp-server'), 'smtp.gmail.com')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__server-port'), '587')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__smtp-account'), 'zhongyan')

WebUI.setEncryptedText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__account-passwd'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__sender-email'), 'abc12xy963@gmail.com')

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_Save'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_HintClose'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_SNMP Agent Settings'), 20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/Notification/SNMP Active'), "enable", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/Notification/SNMP Version'), "v1_v2c", true)

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__snmp-agent-edit-community-input'),
	'public')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__snmp-agent-edit-trip-ip-input'), '192.168.20.95')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Location_snmp-agent-edit-syslocation-input'),
	'location')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Contact_snmp-agent-edit-syscontact-input'),
	'contact')

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_Save'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_HintClose'), 20)



smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Advance Options'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Warning_email-warning'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Warning_email-warning'), 20)


smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Error_email-error'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Error_email-error'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Firmware Update_email-fw-update'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Firmware Update_email-fw-update'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Temperature Sensor Enter into Warning Zone_temperture-warning'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Temperature Sensor Enter into Warning Zone_temperture-warning'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Temperature Sensor Enter into Danger Zone_temperture-danger'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Temperature Sensor Enter into Danger Zone_temperture-danger'), 20)

WebUI.scrollToElement(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Power Sensor Enter into Warning Zone_power-warning'), 6)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Power Sensor Enter into Warning Zone_power-warning'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Power Sensor Enter into Warning Zone_power-warning'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Power Sensor Enter into Danger Zone_power-danger'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Power Sensor Enter into Danger Zone_power-danger'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_BMCJBODRMC Sensor Abnormal_sensor-abnormal'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_BMCJBODRMC Sensor Abnormal_sensor-abnormal'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Power OnOffResetCycle Triggered_power-control-triggered'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Power OnOffResetCycle Triggered_power-control-triggered'), 20)

WebUI.scrollToElement(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Node Detached_node-detached'), 6)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Node Detached_node-detached'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Node Detached_node-detached'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_New Node Installed_new-node-installed'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_New Node Installed_new-node-installed'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Node Inventory Updated_node-inventory-updated'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Node Inventory Updated_node-inventory-updated'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_PSU Detached_psu-detached'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_PSU Detached_psu-detached'), 20)

WebUI.scrollToElement(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_PSU Fault_psu-fault'), 6)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_PSU Fault_psu-fault'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_PSU Fault_psu-fault'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Disk Usage Threashold Exceeded on ARMOR Host_armor-disk-usage-threashold'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Disk Usage Threashold Exceeded on ARMOR Host_armor-disk-usage-threashold'), 20)

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Disk Usage Threashold()_armor-disk-usage-threashold-value'),
	'70')

WebUI.scrollToElement(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Raise Severity of Remove Task Success to Warning_remove-task-to-warning'), 6)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Raise Severity of Remove Task Success to Warning_remove-task-to-warning'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Raise Severity of Remove Task Success to Warning_remove-task-to-warning'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Raise Severity of Cancel Task Success to Warning_cancel-task-to-warning'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Raise Severity of Cancel Task Success to Warning_cancel-task-to-warning'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_Save'), 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/Notification/button_HintClose') , 20)


smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Mail Receiver List'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_MailAdd'), 20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input__receiver-mail'), 'zhongyan.wu@aicpc.com.tw')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Description_receiver-description'),
	'zhongyan')


smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Submit_1'), 20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/Notification/button_HintClose') , 20)

boolean hasFind = false
int trNum = 1
while(!hasFind ){
	checkNameObject = new TestObject("check mail"+trNum)
	checkNameObject.addProperty("xpath", ConditionType.EQUALS, "//table[@id='receivers-table']/tbody[1]/tr["+trNum+"]/td[2]", true)
	
	WebUI.comment(WebUI.getText(checkNameObject))
	
	if( WebUI.getText(checkNameObject).equals( 'zhongyan.wu@aicpc.com.tw' ) ){
		selectNameObject = new TestObject("select mail"+trNum)
		checkNameObject.addProperty("xpath", ConditionType.EQUALS, "//table[@id='receivers-table']/tbody/tr["+(trNum)+"]/td/input", true)
		
		
		smartWaitClickableAndClick(checkNameObject, 20)
		hasFind = true
	}
	
	trNum++
}

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_Send Test Email'), 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/Notification/button_HintClose') , 20)


smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/Notification/button_MailRemove') , 20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/Notification/button_CheckRemove') , 20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/Notification/button_HintClose') , 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Notification/button_CloseNotifi'), 20)



//--------------Troubleshooting---------------------

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Troubleshooting'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Scan'), 20)
try{
	smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Troubleshooting/button_Show Detail'), 180)
	smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Troubleshooting/button_closeLog'), 20)
	smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Troubleshooting/button_closeTroubleshooting'), 20)
}
catch(Exception ex){
	smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Troubleshooting/button_ForceClose'), 20)
}



//--------------NTP Service Configurations
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_ARMOR NTP Service Configurations'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Enable NTP Service_sys-auto-sync'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Enable NTP Service_sys-auto-sync'), 20)

WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/NTP Service Configurations/select_Interface'), "LAN2", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/NTP Service Configurations/select_TimeZone'), "Asia/Taipei", true)


WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Primary_sys-primary-ntp-server'), 'tick.stdtime.gov.tw')

WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/input_Secondary_sys-secondary-ntp-server'),
	'tock.stdtime.gov.tw')

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Apply'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/NTP Service Configurations/button_HintClose'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/NTP Service Configurations/button_NTPClose'), 20)

//------------Firmware

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/Firmware Management'), 20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/Device')  , 20)

//DEVICE
//CPNODE
//Upload
WebUI.delay(1)
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/label_CPNODE'), 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/Device_Upload')  , 20)
WebUI.sendKeys(findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_Select_file-up-firmware'), 'C:\\myWork\\Firmware\\venusrack_fw\\all\\AIAQN011_AR1.zip')
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/file_Upload')  , 20)
WebUI.delay(3)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_CloseUploadFirm') , 20)
//Modify
WebUI.delay(3)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_checkbox_btSelectItem2') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_Modify2') , 20)
WebUI.delay(3)
WebUI.setText( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/textarea_Modify_Description') , 'test'+(int)(Math.random()*10))
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifySave') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifyClose') , 20)

//JBOD
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/label_JBOD') , 20)

//RMC
//Uplaod
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/label_RMC') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/Device_Upload')  , 20)
WebUI.sendKeys(findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_Select_file-up-firmware'), 'C:\\myWork\\Firmware\\venusrack_fw\\rmc\\VenuRMCv00.01.01.zip')
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/file_Upload')  , 20)
WebUI.delay(3)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_CloseUploadFirm') , 20)
//Modify
WebUI.delay(3)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_checkbox_btSelectItem2') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_Modify2') , 20)
WebUI.delay(3)
WebUI.setText( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/textarea_Modify_Description') , 'test'+(int)(Math.random()*10))
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifySave') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifyClose') , 20)

// RackBP
//Upload
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/label_RackBP') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/Device_Upload')  , 20)
WebUI.sendKeys(findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_Select_file-up-firmware'), 'C:\\myWork\\Firmware\\venusrack_fw\\rackbp\\VenuRBPv00.01.02.zip')
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/file_Upload')  , 20)
WebUI.delay(3)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_CloseUploadFirm') , 20)
//Modify
WebUI.delay(3)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_checkbox_btSelectItem2') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_Modify2') , 20)
WebUI.delay(3)
WebUI.setText( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/textarea_Modify_Description') , 'test'+(int)(Math.random()*10))
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifySave') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifyClose') , 20)

//BIOS
//Upload
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/label_BIOS') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/Device_Upload')  , 20)
WebUI.sendKeys(findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_Select_file-up-firmware'), 'C:\\myWork\\Firmware\\venusrack_fw\\all\\PAVR1002.zip')
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/file_Upload')  , 20)
WebUI.delay(3)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_CloseUploadFirm') , 20)
//Modify
WebUI.delay(3)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_checkbox_btSelectItem2') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_Modify2') , 20)
WebUI.delay(3)
WebUI.setText( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/textarea_Modify_Description') , 'test'+(int)(Math.random()*10))
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifySave') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifyClose') , 20)

//Expander
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/Expander') , 20)

// SAS HBA Card
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/SAS HBA Card') , 20)
//Uplaod
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_SAS HBA_Upload')  , 20)
WebUI.sendKeys(findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_Select_file-up-firmware'), 'C:\\myWork\\Firmware\\venusrack_fw\\all\\DB3008-8e_IR_P15.zip')
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/file_Upload')  , 20)
WebUI.delay(3)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_SAS HBA_UploadClose') , 20)
//Modify
WebUI.delay(3)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/input_Release Note_btSelectItem5') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_SAS HBA_Modify') , 20)
WebUI.delay(3)
WebUI.setText( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/textarea_Modify_Description') , 'test'+(int)(Math.random()*10))
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifySave') , 20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/button_ModifyClose') , 20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/SAS MegaRAID Card') , 20)

	
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORConfiguration/FirmwareManage/FirmwareManage_Close')  , 20)
//WebUI.delay(1000)


// ------------Service Management

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Service Management'), 20)

// --------------Security Management

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Security Management'))


WebUI.navigateToUrl('http://192.168.42.162/en-us/rack/show_racks/')
// -------------Backup and Restore Management

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'), 20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Backup and Restore Management'), 20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Backup and Restore Management/button_CloseBackup') , 20)

// -------------------test Language

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Language'),20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(2)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/languageSel'), "tw", true)
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Apply_1'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Language'),20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(2)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/languageSel'), "ru", true)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Apply_1'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Language'),20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(2)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/languageSel'), "ja", true)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Apply_1'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Language'),20)

WebUI.waitForJQueryLoad(20)
WebUI.delay(2)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/languageSel'), "en-us", true)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/button_Apply_1'),20)

// ---------------------test About

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_Configuration'),20) // button Configuration
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ARMOR/a_About'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/About/about_close'),20)

if(WebUI.getText(findTestObject('Object Repository/ARMORConfiguration/About/span_wwwaicipccom')).equals('www.aicipc.com')){
	WebUI.comment('success')
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

