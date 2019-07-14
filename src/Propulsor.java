
public class Propulsor {
	int potencia;
	int potenciaActual;
	
	public Propulsor(int potencia, int maxPotencia) {
		this.potencia = potencia;
		this.potenciaActual = 0;
		
	}
	@Override
	  public String toString() {
		return ("la potencia maxima d'aquest propulsor es de " + potencia + " i actualment esta a una potencia de " + potenciaActual);
	}
	
	public int accelProp(int a) {
		if((potenciaActual + a)<=potencia) {
			return (potenciaActual+a);
		}else {
			potenciaActual= potencia;
			return potencia;
		}
	}
	public int frenaProp(int a) {
		if((potenciaActual - a >=0)) {
			return (potenciaActual-a);
		}else {
			potenciaActual=0;
			return potenciaActual;
		}
	}
}
