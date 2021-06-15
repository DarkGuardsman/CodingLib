package com.builtbroken.jlib.data.science;
/**@deprecated Removing as this should be JSON data loaded per application */
@Deprecated
public enum ElementProperty
{
	nonmetal("Non-metal"),
	inertGas("Inert gas"),
	halogen("Halogen"),
	alkaliMetal("Alkali metal"),
	alkalineEarthMetal("Alkaline earth metal"),
	semimetallic("Metalloid"),
	otherMetal("Other metal"),
	transitionMetal("Transition metal"),
	lanthanide("Lanthanide"),
	actinide("Actinide");

	final String name;

	ElementProperty(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
