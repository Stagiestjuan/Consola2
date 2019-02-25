package com.jccm.Consola;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Comandos {
	
	String Ruta = "C:\\Prueba";
	String[] cmd;
	String Comando;
	private String[] rutaprocesada;
	private int indice;
	private Seguidor sg = new Seguidor();
	Scanner sc = new Scanner (System.in);
	
	void Crear (String rutas) {
		
		rutaprocesada = sg.Seguidor (Ruta, rutas);
		File files = new File (rutaprocesada[0]);
		
		if (files.exists()) {
			System.out.println("El directorio ya existe");
		}
		else {
			new File (rutaprocesada[0]).mkdirs();
			}
	}
	void Borrar(String rutas) {
		rutaprocesada = sg.Seguidor(Ruta, rutas );
		File files = new File(rutaprocesada[0]);
		Path nombreruta = Paths.get(rutaprocesada[0]);
		
		if (!files.isDirectory()) {
			try {
				Files.delete(nombreruta);
			}
			catch(Exception e) {
				System.out.println("ruta invalida");
			}	
		}
		else {
			System.out.println("no se puede borrar directorios con este comando");
		}
	}
	void Copiar (String fuente, String destino) {
		rutaprocesada = sg.Seguidor(Ruta, fuente, destino);
		indice = rutaprocesada[0].lastIndexOf("\\");
		rutaprocesada[1] = rutaprocesada[1] + "\\" + rutaprocesada[0].substring(indice);
		Path Filefuente = Paths.get(rutaprocesada[0]);
		Path Filedestino = Paths.get(rutaprocesada[1]);	
		
		try {
			Files.copy(Filefuente, Filedestino);	
		}
		catch (IOException e) {
			System.out.println("Ruta Invalida");
		}
	}
	
	void Lista() {
		File toPath = new File (Ruta);
		String [] directorios = toPath.list();
		
		if (directorios.length == 0) {
			System.out.println("El directorio esta vacio");
			return;
		}
		String formato = "%-8s%-22s%s%n";
		System.out.printf(formato, "tipo", "ultima modificacion", "nombre");
		
		for (String directorio : directorios) {
			 String nombreruta = Ruta + "\\" + directorio;
			 File files = new File(nombreruta);
			 
			 SimpleDateFormat sdf = new SimpleDateFormat ("dd\\MM\\yyyy HH:mm:ss");
			 File file = new File(nombreruta);
			 
			 if(files.isDirectory() && !files.isHidden()) {
				 System.out.printf(formato, "<DIR>", sdf.format(file.lastModified()), directorio);
				 }
			 else if (!files.isHidden()) {
				 System.out.printf(formato, "<FILE>", sdf.format(file.lastModified()), directorio);
			 }
		}
	}
	
	void Cambiar (String rutas) {
		
		rutaprocesada = sg.Seguidor(Ruta, rutas);
		Path rutaexistente = Paths.get(rutaprocesada[0]);
		
		if(Files.exists(rutaexistente)) {
			Ruta=rutaprocesada[0];
			if (Ruta.contains(":") && (Ruta.length() ==2)) {
				Ruta += "\\";
			}
		}
		else {
			System.out.print("'" + rutaprocesada[0] + "'Ruta no existe");
			
		}
	}
void Mover(String fuente, String destino) {
		
		rutaprocesada = sg.Seguidor(Ruta, fuente, destino);
		
		indice = rutaprocesada[0].lastIndexOf("\\");
		
		rutaprocesada[1] = rutaprocesada[1] + "\\" + rutaprocesada[0].substring(indice);
		
		Path Filefuente = Paths.get(rutaprocesada[0]); 
		Path Filedestino = Paths.get(rutaprocesada[1]);
		
		try {
			Files.move(Filefuente, Filedestino);
		}
		catch(IOException e){
			System.out.println("Ruta invalida");
		}
	}
	
		void CrearTxt(String[] rutas) {
	
	StringBuilder contenido = new StringBuilder();
	for(String st : rutas) {
		if(contenido.length() > 0) {
		   contenido.append(" ");
		}
		contenido.append(st);
	}
	
	if(contenido.toString().contains(">")){
		String[] contenidoruta = contenido.toString().split(">");
		contenidoruta[0] = contenidoruta[0].replace("echo","");
		contenidoruta[1] = contenidoruta[1].trim();
		rutaprocesada = sg.Seguidor(Ruta, contenidoruta[1]);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaprocesada[0], true))){
			bw.write(contenidoruta[0]);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	else {
		System.out.println(contenido.toString().replace("echo", ""));
	}
}
}
