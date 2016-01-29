package com.samirrk.patterns;

public class ADog extends ACreature 
{

	@Override
	public void setName(String Name) 
	{
		name = Name;

	}

	@Override
	public String getName() 
	{
		
		return name;
	}

}
