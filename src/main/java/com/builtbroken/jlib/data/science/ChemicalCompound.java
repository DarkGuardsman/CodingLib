package com.builtbroken.jlib.data.science;

//TODO replace with localized data base, or data file to avoid loading up a ton of combinations when not needed
public enum ChemicalCompound
{
	/**
	 * http://encyclopedia.airliquide.com/encyclopedia.asp?GasID=8#GeneralData
	 */
	BUTANE("Butane", "C4H10", MatterPhase.GAS, 58.12f, 0.0027093f, new HeatingData(133f, 274f, 1379.23f, 6634.23f, 88f)),
	METHANE("Methane", "CH4", MatterPhase.GAS, 16.043f, 0.001816f, new HeatingData(90.65f, 111.55f, 3656.67f, 31789.56f, 27f)),
	WATER("Water", "H20", MatterPhase.LIQUID, 18.01528f, 1000f, new HeatingData(274.15f, 373.13f, 18539.817f, 126004.1476f, 4.24f)),
	AIR("Air", "", MatterPhase.GAS, 29f, .125f, null),
	AMMONIA("Ammonia", "NH3", MatterPhase.GAS, 17.031f, 0.000889f, new HeatingData(195.41f, 239.82f, 332170f, 1369500f, 298.15f)),
	//NITRICACID("Nitric Acid", "HNO2", MatterPhase.LIQUID, 63.01f, 1.5129f, new HeatingData(231f, 356f, ));
	;
    //http://science.jrank.org/pages/6523/Stone-Masonry-Chemical-composition.html
    //SILICON_DIOXIDE("Siliceous stone", "SiO2", MatterPhase.SOLID),
    //("Argillaceous stone", "AlO2", MatterPhase.SOLID);

	/**
	 * Formula
	 */
	public final String formula;
	/**
	 * IUPAC ID
	 */
	public final String compoundName;
	/**
	 * g/mol
	 */
	public final float molarMass;
	/**
	 * g/cm^3
	 */
	public final float density;

	public final MatterPhase defaultPhase;

	public final HeatingData heatingData;

	ChemicalCompound(String name, String formula, MatterPhase phase, float molarMass, float density, HeatingData data)
	{
		this.compoundName = name;
		this.formula = formula;
		this.molarMass = molarMass;
		this.density = density;
		this.defaultPhase = phase;
		this.heatingData = data;
	}
}
