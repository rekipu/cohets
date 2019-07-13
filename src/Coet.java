import java.util.ArrayList;
import java.util.Arrays;

public class Coet {
	private String name;
	private ArrayList<Propulsor> propulsors;
	
	public Coet(String nom ,ArrayList<Propulsor> propulsors) {
		this.name= nom;
		this.propulsors = propulsors;
		
	}
	
	@Override
	  public String toString() {
	    return ("El coet " + name + " té " + propulsors.size() + " propulsors." + Arrays.toString(propulsors));
	  }

}
