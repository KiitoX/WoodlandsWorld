package com.mcmanuellp.woodlandsworld.utility;

public class CalcHelper
{
	public static float of16(float of16)
	{
		if(of16 < 1f)
			of16 = 1f;
		else if(of16 > 16f)
			of16 = 16f;

		return 1f/16f*of16;
	}
}