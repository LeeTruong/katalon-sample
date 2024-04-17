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

response = WS.sendRequest(findTestObject('API_Helper/PostPet'), FailureHandling.STOP_ON_FAILURE)

actual_id = WS.getElementPropertyValue(response, 'id')

response_delete = WS.sendRequest(findTestObject('API_Helper/DeletePet', [('petID') : actual_id]))

actual_message = WS.getElementPropertyValue(response_delete, 'message')

printf('actual_message', actual_message)

WS.verifyResponseStatusCode(response_delete, 200)

WS.verifyElementPropertyValue(response_delete, 'message', actual_id)

response_get = WS.sendRequest(findTestObject('API_Helper/GetpetbyID', [('petID') : actual_id]))

WS.verifyResponseStatusCode(response_get, 404)

WS.verifyElementPropertyValue(response_get, 'message', 'Pet not found')

