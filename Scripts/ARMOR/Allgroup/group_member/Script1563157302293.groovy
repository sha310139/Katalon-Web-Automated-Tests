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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://192.168.42.162/en-us/login/?next=/en-us/')

WebUI.setText(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ ARMOR/input_Login_username'), 'admin')

WebUI.setEncryptedText(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ ARMOR/input_Login_password'), '8SQVv/p9jVScEs4/2CZsLw==')

WebUI.sendKeys(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ ARMOR/input_Login_password'), Keys.chord(
        Keys.ENTER))

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/a_All Groups'), GlobalVariable.G_Small_WaitTime)

smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/a_All Groups_1'), GlobalVariable.G_Small_WaitTime)

String searchText = ""
String groupText = ""

for (int i = 0 ; i < 5 ; i++) {
	
	switch(i) {
		case 0:
			searchText = "Venus-Rack"
			groupText = "test_all"
			break
		case 1:
			searchText = "RMC"
			groupText = "test_RMC"
			break
		case 2:
			searchText = "1U"
			groupText = "test_CPnode"
			break
		case 3:
			searchText = "JBod"
			groupText = "test_JBnode"
			break
		case 4:
			searchText = "RackBP"
			groupText = "test_RackBP"
			break
		default:
			searchText = "Venus-Rack"
			groupText = "test_all"
	} // end switch
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebElement table = driver.findElement(By.xpath('//table[@id="group-table"]/tbody'))
	
	List<WebElement> rows = table.findElements(By.tagName('tr'))
	
	int position = 0
	
	for (position = 0 ; position < rows.size() ; position++) {
		testObject = new TestObject("groupName")
		if (position == 0)
			testObject.addProperty("xpath", ConditionType.EQUALS, "//table[@id='group-table']/tbody/tr/td[2]", true)
		else
			testObject.addProperty("xpath", ConditionType.EQUALS, "//table[@id='group-table']/tbody/tr[" + (position+1) + "]/td[2]", true)
			
		if (WebUI.getText(testObject).equals(groupText)) {
			break
		} // if
	} // end for
	
	checkBoxObject = new TestObject("checkBox")

	if (position == 0)
		checkBoxObject.addProperty("xpath", ConditionType.EQUALS, "//input[@name='pk']", true)
	else
		checkBoxObject.addProperty("xpath", ConditionType.EQUALS, "(//input[@name='pk'])[" + (position+1) + "]", true)
	
	smartWaitAndClick(checkBoxObject, GlobalVariable.G_Small_WaitTime)

	smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/button_Add Members'), GlobalVariable.G_Small_WaitTime)

	smartWait(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/input_Search_search-input'), GlobalVariable.G_Small_WaitTime)
	
	WebUI.setText(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/input_Search_search-input'), searchText)

	smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/button_Search'), GlobalVariable.G_Small_WaitTime)

	smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/input_No matching records found_btSelectAll'), GlobalVariable.G_Small_WaitTime)

	smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/button_Add Group Members'), GlobalVariable.G_Small_WaitTime)

	smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/button_Show Detail'), GlobalVariable.G_Large_Timeout)

	smartWait(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/p_Information'), GlobalVariable.G_Small_WaitTime)

	WebUI.delay(1)

	if (WebUI.getText(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/p_Information')).equals('Warning') ) {
		KeywordUtil.markFailed('Warning')
	} // if

	WebUI.delay(1)

	smartWait(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/p_Add Group Member Complete'), GlobalVariable.G_Small_WaitTime)

	if (!WebUI.getText(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/p_Add Group Member Complete')).equals('Add Group Member Complete') ) {
		KeywordUtil.markFailed('Add member failed')
	} // if

	smartWaitAndClick(findTestObject('Allgroup/Page_ARMOR_group_member/Page_ARMOR/button_'), GlobalVariable.G_Small_WaitTime)
} // end for

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