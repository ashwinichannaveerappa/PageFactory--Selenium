package resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter=0;
	int retrylimit=1;
	public boolean retry(ITestResult result) {
		if(counter<retrylimit)
		{
			counter++;//increase the counter
			return true;
		}

				return false;
	}

	

}
