package com.mcmanuellp.woodlandsworld.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class ChatHelper implements ICommandSender
{
	static GuiNewChat newChat = new GuiNewChat(Minecraft.getMinecraft());

	static IChatComponent msg;

	public static void chat(Object object)
	{
		//TODO make it work
	}

	@Override
	public void addChatMessage(IChatComponent p_145747_1_)
	{
		newChat.printChatMessage(p_145747_1_);
	}

	@Override
	public IChatComponent func_145748_c_()
	{
		return null;
	}

	@Override
	public World getEntityWorld()
	{
		return null;
	}

	@Override
	public ChunkCoordinates getPlayerCoordinates()
	{
		return null;
	}

	@Override
	public boolean canCommandSenderUseCommand(int p_70003_1_, String p_70003_2_)
	{
		return false;
	}

	@Override
	public String getCommandSenderName()
	{
		return null;
	}
}
