package com.mcmanuellp.woodlandsworld.client.handler;

import com.mcmanuellp.woodlandsworld.client.settings.Keybindings;
import com.mcmanuellp.woodlandsworld.reference.Key;
import com.mcmanuellp.woodlandsworld.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler
{
	private static Key getPressedKeyBinding()
	{
		if(Keybindings.charge.isPressed())
		{
			return Key.CHARGE;
		}
		else if(Keybindings.release.isPressed())
		{
			return Key.RELEASE;
		}

		return Key.UNKNOWN;
	}

	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
		//-----------------------debug----------------------TODO debug, disable

		//LogHelper.info(getPressedKeyBinding());

		//--------------------------------------------------
	}
}