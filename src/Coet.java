import java.util.ArrayList;
import java.util.Arrays;

public class Coet {
	private String name;
	private ArrayList<Propulsor> propulsors;
	private double speed;

	public Coet(String nom, ArrayList<Propulsor> propulsors) {
		this.name = nom;
		this.propulsors = propulsors;
		this.speed = 0;

	}

	@Override
	public String toString() {
		int[] valorsPropulsors = new int[propulsors.size()];
		for (int i = 0; i < propulsors.size(); i++) {
			valorsPropulsors[i] = (propulsors.get(i).potencia);
		}
		return ("El coet " + name + " té " + propulsors.size() + " propulsors." + Arrays.toString(valorsPropulsors));
	}
	
	public void acceleraCoet() {
		for (int i = 0; i < propulsors.size(); i++) {
			propulsors.get(i).accelProp(10);
		}
	}
	
	public void frenaCoet() {
		for (int i = 0; i < propulsors.size(); i++) {
			propulsors.get(i).frenaProp(10);
		}
	}
	
	public double getSpeed() {
		int potenciaTotal=0;
		for (int i = 0; i < propulsors.size(); i++) {
			potenciaTotal += propulsors.get(i).potenciaActual;
		}
		speed = speed + 100 * Math.sqrt(potenciaTotal);
		return speed;
	}


}
