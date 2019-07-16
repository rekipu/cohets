
public class Propulsor extends Thread {
	int potencia;
	int potenciaActual;
	double secsOn;

	public Propulsor(int potencia) {
		this.potencia = potencia;
		this.potenciaActual = 0;
		run();

	}

	public void setSecs(double secs) {
		secsOn = secs;
	}

	@Override
	public void run() {
		System.out.println("Thread propulsor" + "Started");
		while (secsOn >= 1) {
			if (potenciaActual < potencia)
				potenciaActual += 10;
			System.out.println("propulsor " + " en funcionament a " + potenciaActual);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			secsOn--;
		}
			try {
				Thread.sleep((int) (secsOn * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			secsOn = 0;
			potenciaActual = 0;
			System.out.println("propulsor " + this + " Parat.");
		

	}

	@Override
	public String toString() {
		return ("la potencia maxima d'aquest propulsor es de " + potencia + " i actualment esta a una potencia de "
				+ potenciaActual);
	}

	public int accelProp(int a) {
		if ((potenciaActual + a) <= potencia) {
			potenciaActual += a;
			return (potenciaActual);
		} else {
			potenciaActual = potencia;
			return potencia;
		}
	}

	public int frenaProp(int a) {
		if ((potenciaActual - a >= -Math.abs(potencia))) {
			potenciaActual -= a;
			return (potenciaActual);
		} else {
			potenciaActual = -Math.abs(potencia);
			return potenciaActual;
		}
	}
}
