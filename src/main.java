import java.util.ArrayList;
import java.util.Arrays;

public class main {
	
	public static void main(String[] args) {
		Propulsor p1 = new Propulsor(10);
		Propulsor p2 = new Propulsor(30);
		Propulsor p3 = new Propulsor(80);
		ArrayList<Propulsor> propulsorsCoet1 = new ArrayList<Propulsor>(Arrays.asList(p1,p2,p3));
		Propulsor p4 = new Propulsor(30);
		Propulsor p5 = new Propulsor(40);
		Propulsor p6 = new Propulsor(50);
		Propulsor p7 = new Propulsor(50);
		Propulsor p8 = new Propulsor(30);
		Propulsor p9 = new Propulsor(10);
		ArrayList<Propulsor> propulsorsCoet2 = new ArrayList<Propulsor>(Arrays.asList(p4,p5,p6,p7,p8,p9));
		
		Coet coet1 = new Coet("32WESSDS", propulsorsCoet1);
		Coet coet2 = new Coet("LDSFJA32", propulsorsCoet2);
		System.out.println(coet1);
		System.out.println(coet2);
	}

}
