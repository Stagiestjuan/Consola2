package com.jccm.Consola;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int o = 0;
		do {
			System.out.println("windows");
			System.out.println("Linux");
			System.out.println("Salir");
			
			try {
				 o = sc.nextInt();
			}
			catch(Exception e){
				System.out.println("error");
			}
			switch (o) {
			
			case 1:
				Windows Wind = new Windows();
				Wind.Win();
				break;
				
			case 2:
				Linux Uni = new Linux();
				Uni.Linux();
				break;
				
			case 3:
				System.exit(0);
				
				default:
					System.out.println("debe escoger una opcion");
			}
		}while(o!=0);
	}
}
			