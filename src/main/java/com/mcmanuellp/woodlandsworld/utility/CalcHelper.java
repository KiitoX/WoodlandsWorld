package com.mcmanuellp.woodlandsworld.utility;

public class CalcHelper
{
	public static float of16(float of16)
	{
		if(of16 < 1F)
		{
			return 0F;
		}
		else
		{
			if(of16 < 1F)       {of16 = 1F;}
			else if(of16 > 16F) {of16 = 16F;}

			return 1F/16F*of16;
		}
	}
}