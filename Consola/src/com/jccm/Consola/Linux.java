package com.jccm.Consola;
import java.util.Scanner;
public class Linux extends Comandos{

	public void Linux() {
		Scanner sc = new Scanner (System.in);
		
		do {
			StringBuilder rutalinux = new StringBuilder (Ruta.replace("\\\\", "/")).replace(0, 2, "~");
			System.out.println(rutalinux + ">");
			
			Comando = sc.nextLine();
			cmd = Comando.split(" ");
			
			switch(cmd[0]) {
			case "cp":
				if(cmd.length == 3) {
					Copiar(cmd[1],cmd[2]);
				}
				else {
					System.out.println("Error");
				}break;
				
			case "rm": 
				if(cmd.length == 2 && !cmd[0].contains("-rf")) {
					Borrar(cmd[1]);
				}
				else {
					System.out.println("Error");
				}break;
				
			case "mkdir":
				if(cmd.length == 2) {
					Crear(cmd[1]);
				}
				else {
					System.out.println("Error");
				}break;
				
			case "cd":
				if(cmd.length == 2) {
					Cambiar(cmd[1]);
				}
				else {
					System.out.println("Error");
				}break;
				
			case "ls":
				if (cmd.length == 1) {
					System.out.println("Directorio de" + rutalinux + ":");
					Lista();
				}
				else {
					System.out.println("Error");
				}break;
			
			case "mv":
				if(cmd.length == 3) {
					Mover(cmd[1],cmd[2]);
				}
				else {
					System.out.println("Error");
				}break;
				
			case "echo":
				CrearTxt(cmd);
				break;
			
			case "salir":
				break;
			
			default:
				System.out.println(cmd[0] + " no es reconocido como un comando");
			}
			
		}while (!Comando.equals("salir"));
		System.exit(0);
	}
}
