package com.mcmanuellp.woodlandsworld.tileentity;

public class TileEntityBonfire extends TileEntityWW
{
	private int fuelLevel;
	public static int maxFuelLevel = 64;

	/**
	 * @param value decreases fuel level by this
	 * @return      if possible=true; impossible=false
	 */
	public boolean removeFuel(int value)
	{
		if(this.fuelLevel - value >= 0)
		{
			this.fuelLevel -= value;
			this.markDirty();
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @param value increases fuel level by this
	 */
	public void addFuel(int value)
	{
		this.markDirty();

		if(this.fuelLevel + value < maxFuelLevel)
		{
			this.fuelLevel += value;
		}
		else
		{
			this.fuelLevel = maxFuelLevel;
		}
	}

	/**
	 * @param value sets fuel level to this
	 */
	public void setFuel(int value)
	{
		fuelLevel = value;
		this.markDirty();
	}

	public boolean hasFuel()
	{
		return this.fuelLevel > 0;
	}

	public int getFuel()
	{
		return this.fuelLevel;
	}
}