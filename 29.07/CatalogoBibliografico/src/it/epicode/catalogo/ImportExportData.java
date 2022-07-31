package it.epicode.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

// DEFINIAMO UN'INTERFACCIA CHE DETTA QUALI METODI DOVRà AVERE LA CLASSE CHE ANDRà AD IMPLEMENTARLA
public interface ImportExportData {

//	I METODI IN QUESTIONE SONO readToExternalFile() CHE DEVE RESTITUIRE UNA LISTA E DEVE LANCIARE UN'ECCEZIONE
	public Map<String, Catalog> readToExternalFile() throws IOException;

//	E IL METODO writeToExternalFile() CHE ANCH'ESSO LANCIA UN'ECCEZIONE MA NON RESTITUISCE NULLA
	public void writeToExternalFile() throws IOException;
}
