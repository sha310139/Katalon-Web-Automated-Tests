package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_Small_WaitTime
     
    /**
     * <p></p>
     */
    public static Object G_Small_Timeout
     
    /**
     * <p></p>
     */
    public static Object G_Large_Timeout
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            G_Small_WaitTime = selectedVariables['G_Small_WaitTime']
            G_Small_Timeout = selectedVariables['G_Small_Timeout']
            G_Large_Timeout = selectedVariables['G_Large_Timeout']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
