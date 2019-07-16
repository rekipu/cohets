
public class Propulsor  extends Thread{
	int potencia;
	int potenciaActual;
	
	
	
	
	public Propulsor(int potencia) {
		this.potencia = potencia;
		this.potenciaActual = 0;
		run();
		
	}
	@Override
	public void run() {
		System.out.println("Thread propulsor" + this);
	}
	@Override
	  public String toString() {
		return ("la potencia maxima d'aquest propulsor es de " + potencia + " i actualment esta a una potencia de " + potenciaActual);
	}
	
	public int accelProp(int a) {
		if((potenciaActual + a)<=potencia) {
			potenciaActual +=a;
			return (potenciaActual);
		}else {
			potenciaActual= potencia;
			return potencia;
		}
	}
	public int frenaProp(int a) {
		if((potenciaActual - a >=-Math.abs(potencia))) {
			potenciaActual -=a;
			return (potenciaActual);
		}else {
			potenciaActual=-Math.abs(potencia);
			return potenciaActual;
		}
	}
}
