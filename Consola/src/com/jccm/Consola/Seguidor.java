package com.jccm.Consola;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Seguidor {

	protected int indice;
	protected String rutafuente;
	protected String rutadestino;
	protected String[] cmd = new String[2];
	
	public String[] Seguidor (String actual, String fuente, String destino) {
		if (fuente.contains("\\")) {
			if (fuente.contains("\\")) {
				rutafuente = fuente;
			}
			else {
				rutafuente = actual + "\\" + fuente;
				}
			}
			else {
				rutafuente = actual + "\\" + fuente;
			}
		if(destino.contains(":\\")) {
			rutadestino = destino;
		}
		else {
			rutadestino = actual + "\\" + destino;
		}
		if (rutafuente.contains("..")) {
			List<String> listafuente = new LinkedList<>(Arrays.asList(rutafuente.split("\\\\")));
			while (listafuente.contains("..")) {
				indice = listafuente.indexOf("..");
				listafuente.remove(indice);
				listafuente.remove(indice - 1);
				}
			String[] arrayfuente = new String[listafuente.size()];
			arrayfuente = listafuente.toArray(arrayfuente);
			StringBuilder sbfuente = new StringBuilder();
			
			for(String l : arrayfuente) {
				sbfuente.append(l).append("\\");
			}
			sbfuente.deleteCharAt (sbfuente.length() - 1);
			rutafuente = sbfuente.toString();
		}
		if(rutadestino.contains("..")) {
			List<String> listadestino = new LinkedList <> (Arrays.asList(rutadestino.split("\\\\")));
			
			while (listadestino.contains("..")) {
				indice = listadestino.indexOf("..");
				listadestino.remove(indice);
				listadestino.remove(indice -1);
			}
			String[] arraydestino = new String [listadestino.size()];
			arraydestino = listadestino.toArray(arraydestino);
			
			StringBuilder sbdestino = new StringBuilder();
			for(String l : arraydestino) {
				sbdestino.append(l).append("\\");
			}
			sbdestino.deleteCharAt(sbdestino.length() -1);
			rutadestino= sbdestino.toString();
		}
		cmd[0] = rutafuente;
		cmd[1] = rutadestino;
		
		return cmd;
	}
	public String[] Seguidor (String actual, String rutaunica) {
		if (rutaunica.contains(":\\")) {
			rutadestino = rutaunica;
		}
		else {
			rutadestino = actual + "\\" + rutaunica;
		}
		if (rutadestino.contains("..")) {
			List <String> listadestino = new LinkedList <> (Arrays.asList(rutadestino.split("\\\\")));
			
			while(listadestino.contains("..")) {
			indice = listadestino.indexOf("..");
			listadestino.remove(indice);
			listadestino.remove(indice -1);
		}
		String[] arraydestino = new String [listadestino.size()];
		arraydestino = listadestino.toArray(arraydestino);
		
		StringBuilder sbdestino = new StringBuilder();
		
		for (String l : arraydestino) {
			sbdestino.append(l).append("\\");
		}
		sbdestino.deleteCharAt(sbdestino.length() -1);
		rutadestino = sbdestino.toString();
		}
		
		if (rutadestino.contains("\\\\")) {
			rutadestino = rutadestino.replaceAll("\\\\+", "\\\\");
		}
		cmd [0] = rutadestino;
		return cmd;
	}
}
