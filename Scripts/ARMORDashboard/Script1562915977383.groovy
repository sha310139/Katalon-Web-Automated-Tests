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
WebUI.navigateToUrl('http://192.168.42.162/en-us/login/')
WebUI.setText(findTestObject('Object Repository/ARMORConfiguration/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Object Repository/ARMORConfiguration/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORConfiguration/Page_ ARMOR/button_Login'),20)





smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/Dashboard'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/Floor Plan'),20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/button_Generate Coordinate'),20)

WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input__col'), ''+(8+(int)(Math.random()+0.5)))
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input__row'), ''+(8+(int)(Math.random()+0.5)))
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/textarea_Description'), ''+(int)(Math.random()*10+1))

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/button_CreateCoordinate'),20)


smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/button_Upload Floor Layout Image'),20)

WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/ARMORDashboard/input_Browse _uploadfp'), 'C:\\myWork\\logo\\test.png')

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/CheckUpload') ,20)
WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(2)

WebUI.clickOffset(findTestObject('Object Repository/ARMORDashboard/canvas') , 500, 500)

//smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/canvas') ,20)


WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(2)
smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/selectRack') ,20)

smartWaitClickableAndClick(findTestObject('Object Repository/ARMORDashboard/button_Create_AddRack') ,20)
WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(2)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/button_Save changes') ,20)

smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/button_checkSave') ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/Dashboard') ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/Thresholds')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/Node Threshold Settings')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_600 W')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '550'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_600 W')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '600'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)


smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_80 C0') ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '30'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_80 C0')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '80'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_80 C1')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '30'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_80 C1')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '80'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)


smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_1100 W')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '1050'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_1100 W')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '1100'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)


smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_90 C0')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '81'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_90 C0')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '90'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_90 C1')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '81'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/a_90 C1')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '90'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

//-------------------------------------

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_600 JB')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '550'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_600 JB') ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '600'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)


smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_80 JB') ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '30'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_80 JB')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '80'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_80 JB2')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '30'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_80 JB2')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '80'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

//------------------------------------

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_1100 JB') ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '1050'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_1100 JB')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '1100'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)


smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_90 JB') ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '81'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_90 JB')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '90'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_90 JB2')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '81'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)

smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/PageThreshold/a_90 JB2')  ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/input_setNum'), '90'  )
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/button_checkSetNum')  ,20)



smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/Dashboard')  ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/DashboardLabel/a_DashboardLabel') ,20)
smartWaitClickableAndClick( findTestObject('Object Repository/ARMORDashboard/DashboardLabel/button_Information')  ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/button_Power') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/button_Metric') ,20)




for(int i = 0 ; i < 5 ; i++){
	selectObject = new TestObject("select"+i)
	selectObject.addProperty("xpath", ConditionType.EQUALS, "//div[@id='mon-page-all']/div/div/div[2]/div/div[2]/div[3]/div/div/div[2]/div[2]/table/tbody/tr["+(i+1)+"]/td/a/i", true)
	smartWaitClickableAndClick(  selectObject ,20)
}



smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/i_Threshold 2_glyphicon glyphicon-plus icon-plus') ,20)
WebUI.delay(3)


// Click Canvas

WebUI.clickOffset(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/canvas_'), 62, 670 ) // Venus-Rack 1-A
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/Sensor') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Sensor_Refresh') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_ tmp') ,20)

smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/Current Event Log') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Current Event Log_Refresh') ,20)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "today", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "since-yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "current-week", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "other", true)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Start Period_enable-start-period') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_End Period_enable-end-period') ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Start Period_form-control start-period'), '2019/05/15 00:00')
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_End Period_form-control end-period'), '2019/07/15 11:37')
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Apply Period Filter') ,20)
WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "", true)

WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "Info", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "Warning", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "Critical", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "All", true)



WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Search'), '10')
WebUI.sendKeys(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Search'), Keys.chord(Keys.ENTER))
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/closeVenusRackWind') ,20)


WebUI.clickOffset(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/canvas_'), 195, 10 ) // Venus-Rack
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/Sensor') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Sensor_Refresh') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_ tmp') ,20)

smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/PSU') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_PSU_Refresh') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_PSU_tmp') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/PSU_Firmware Version_glyphicon glyphicon-plus icon-plus') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/PSU__glyphicon glyphicon-plus icon-plus') ,20)



smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/Current Event Log') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Current Event Log_Refresh') ,20)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "today", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "since-yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "current-week", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "other", true)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Start Period_enable-start-period') ,20)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_End Period_enable-end-period') ,20)
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Start Period_form-control start-period'), '2019/05/15 00:00')
WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_End Period_form-control end-period'), '2019/07/15 11:37')
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Apply Period Filter') ,20)
WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Timestamp Period Filter'), "", true)

WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "Info", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "Warning", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "Critical", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/select_Severity Filter'), "All", true)



WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Search'), '10')
WebUI.sendKeys(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/input_Search'), Keys.chord(Keys.ENTER))
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/closeVenusRackWind') ,20)

WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(1)

WebUI.clickOffset(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/canvas_'), 150, 10 ) // Venus-Rack

WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_RackNodeDate'), "today", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_RackNodeDate'), "yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_RackNodeDate'), "since-yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_RackNodeDate'), "current-week", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_RackNodeDate'), "other", true)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Apply Period Filter') ,20)
WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_Severity Filter'), "Info", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_Severity Filter'), "Warning", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_Severity Filter'), "Critical", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_Severity Filter'), "All", true)

WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/input_RackNode Search'), '10')
WebUI.sendKeys(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/input_RackNode Search'), Keys.chord(Keys.ENTER))

smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/RackNode Event Log') ,20)

WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogDate'), "today", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogDate'), "yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogDate'), "since-yesterday", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogDate'), "current-week", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogDate'), "other", true)
smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/button_Apply Period Filter') ,20)
WebUI.waitForJQueryLoad(10, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogSeverity Filter'), "Info", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogSeverity Filter'), "Warning", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogSeverity Filter'), "Critical", true)
WebUI.selectOptionByValue(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/select_eventLogSeverity Filter'), "All", true)

WebUI.setText(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/input__eventLogSearch'), '10')
WebUI.sendKeys(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/RackDetail/VenusRackDetail/input__eventLogSearch'), Keys.chord(Keys.ENTER))



/*
for(int y = 700; y <= 2000 ; y++){
	WebUI.clickOffset(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/canvas_'), 120, y) // 100 ~ 125
	try{
		smartWaitClickableAndClick(  findTestObject('Object Repository/ARMORDashboard/DashboardLabel/closeVenusRackWind') ,3)
	}
	catch(Exception ex){
		WebUI.comment('failed y: '+y)
	}
	
	WebUI.delay(1)
}

*/

//WebUI.clickOffset(findTestObject('Object Repository/ARMORDashboard/DashboardLabel/canvas_'), 110, 710) // 100 ~ 125


/*
smartWaitClickableAndClick(   ,20)
*/





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