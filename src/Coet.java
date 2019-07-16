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

	public void desiredSpeed(int desiredSpeed) {
		int potenciaTotal = 0;
		double segons = 0;
		double potenciaActual = 0;
		for (int i = 0; i < propulsors.size(); i++) {
			potenciaTotal += propulsors.get(i).potencia;
		}
		double[] maxAccelPerTurn = new double[11];
		// calculem maxima potencia de tots els reactors cada un dels deu primers segons
		for (int i = 0; i < 10; i++) {
			int potenciaPerTorn = 0;
			for (int e = 0; e < propulsors.size(); e++) {
				if (propulsors.get(e).potencia <= (i + 1) * 10) {
					potenciaPerTorn += (propulsors.get(e).potencia);
				} else {
					potenciaPerTorn += (i + 1) * 10;
				}
				maxAccelPerTurn[i] = 100 * Math.sqrt(potenciaPerTorn);
			}
		}

		while ((potenciaActual + maxAccelPerTurn[(int) segons] < desiredSpeed) && (segons <= 9)) {
			potenciaActual += maxAccelPerTurn[(int) segons];
			segons++;
			
		}

		while ((potenciaActual + maxAccelPerTurn[9]) < desiredSpeed) {
			potenciaActual += maxAccelPerTurn[9];
			segons++;
		}

		if (segons <= 9) {
			segons += 1 - ((potenciaTotal + maxAccelPerTurn[(int) segons] * (segons))
					/ (potenciaTotal + maxAccelPerTurn[(int) segons] * segons + 1));
		} else {

			segons += 1 - ((potenciaTotal + maxAccelPerTurn[9] * (segons))
					/ (potenciaTotal + maxAccelPerTurn[9] * segons + 1));
			
		}
		System.out.println("el coet tardarà " + segons +"segons");
		for (int i = 0; i < propulsors.size(); i++) {
			propulsors.get(i).setSecs(segons);
			propulsors.get(i).start();
		}
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
		int potenciaTotal = 0;
		for (int i = 0; i < propulsors.size(); i++) {
			potenciaTotal += propulsors.get(i).potenciaActual;
		}
		if (potenciaTotal >= 0) {
			speed = speed + (100 * Math.sqrt(potenciaTotal));
			return speed;
		} else {
			speed = speed - (100 * Math.sqrt(Math.abs(potenciaTotal)));
			return speed;
		}
	}

}
