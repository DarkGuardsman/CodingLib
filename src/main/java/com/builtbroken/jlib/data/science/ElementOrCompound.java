package com.builtbroken.jlib.data.science;

/**
 * Class to Represent an Element or a compound
 * Useful for things that can have either an element OR a compound
 */
public class ElementOrCompound {

    private ChemElement element;

    private ChemicalCompound compound;

    public ElementOrCompound(ChemElement element){
        this.element = element;
    }

    public ElementOrCompound(ChemicalCompound compound){
        this.compound = compound;
    }

    public boolean isElement(){
        return this.element != null;
    }

    public boolean isCompound(){
        return this.compound != null;
    }

    public ChemElement getElement(){
        return this.element;
    }

    public ChemicalCompound getCompound(){
        return this.compound
    }
}
