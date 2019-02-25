package com.jccm.Consola;

import java.util.Scanner;
import java.lang.*;
import java.io.*;
import java.nio.file.*;

public class Windows extends Comandos{
	
	String RutaFuente, Comando, RutaDestino;
	
	public void Win() {
		
		Scanner sc = new Scanner (System.in);
		do {
			System.out.print(Ruta + ">");
			Comando = sc.nextLine();
			cmd = Comando.split(" ");
			
			switch(cmd[0]) {
			
			case "mkdir":
				if(cmd.length == 2) {
					Crear(cmd[1]);
				}
				else {
					System.out.println("error");
				}
				break;
				
			case "copy":
				if (cmd.length == 3) {
					Copiar (cmd[1], cmd[2]);
				}
				else {
					System.out.println("error");
				}
				break;
				
			case "cd":
				if(cmd.length == 2) {
					Cambiar(cmd[1]);
				}
				else {
					System.out.println("error");
				}
				break;
				
			case "move":
			if(cmd.length == 3) {
				Mover(cmd[1], cmd[2]);
			}
			else {
				System.out.println("error");
			}
			break;
			
			case "echo":
				CrearTxt(cmd);
				break;
				
			case "del":
				if(cmd.length == 2) {
					Borrar(cmd[1]);
				}
				else {
					System.out.println("error");
				}
				break;
				
			case "dir":
				if(cmd.length == 1) {
					System.out.println("Directorio de " + Ruta + ":");
					Lista();
					}
				else {
					System.out.println("error");
				}
				break;
				
			case "salir":
				break;
				
				default:
					System.out.println(cmd[0]+ "No es reconocido como un comando");
				}
		}while (!Comando.equals("Salir"));
		System.exit(0);
	}

}
