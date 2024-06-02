package Part2.PetriDataPackage;

import java.io.Serializable;

import LabSession6.Part2.Enumerations.PetriObjectType;

public class Place implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PetriObjectType Type;
	public String Name;
	public Object Val;

	public Place(String name, PetriObjectType type, Object val) {
		this.Type = type;
		this.Name = name;
		this.Val = val;
	}
}
