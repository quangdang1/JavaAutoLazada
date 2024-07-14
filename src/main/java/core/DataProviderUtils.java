package core;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	@DataProvider(name = "TestData")
	public Object[][] getData(Method method) {
		//lấy test data dựa trên tên class và tên test method
		String testName = method.getName();
		String className = method.getDeclaringClass().getSimpleName();
		String loginDataPath = CommonFunction.getTestDataPath(className + "_" + testName);
		return ExcelUtils.getTableArray(loginDataPath, false);
	}
}
