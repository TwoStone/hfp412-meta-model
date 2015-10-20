package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler mBooleanSUBTYPEName = new RegularExpressionHandler( "[(false)" + 
		"(true)]" );
    public static RegularExpressionHandler aggregationStrategySUBTYPEName = new RegularExpressionHandler( "[(SumStrategy)" + 
		"(MaxStrategy)" + 
		"(AvgStrategy)" + 
		"(MinStrategy)]" );
    

}
