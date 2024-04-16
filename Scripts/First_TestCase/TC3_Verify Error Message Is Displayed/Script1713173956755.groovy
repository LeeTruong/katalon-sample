import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Verify Successful Open Login Form'
WebUI.callTestCase(findTestCase('First_TestCase/TC1_Verify Successful Open Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Input User Name'
WebUI.sendKeys(findTestObject('Page_CURA Login/Page_CURA Login Form/input_Username_username'), findTestData('Login Data').getValue(
        1, 2))

'Input Password'
WebUI.sendKeys(findTestObject('Page_CURA Login/Page_CURA Login Form/input_Password_password'), findTestData('Login Data').getValue(
        2, 2))

'Click Login Button'
WebUI.click(findTestObject('Page_CURA Login/Page_CURA Login Form/button_Login'))

'Get Error message'
actual_error_msg = WebUI.getText(findTestObject('Page_CURA Login/Page_CURA Error message/p_Error message'))

'Verify Error Message is displayed correctly when input wrong username and password\n'
WebUI.verifyEqual(actual_error_msg, findTestData('Login Data').getValue(3, 2))

