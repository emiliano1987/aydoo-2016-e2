package ar.edu.untref.aydoo.salida;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiadoDeCarpeta {

	public void copiarArchivos(File directorioOrigen, File directorioDestino)
			throws IOException, NoExisteDirectorioException {
		if (directorioOrigen.exists()) {
			if (directorioOrigen.isDirectory()) {

				String archivos[] = directorioOrigen.list();

				if (!directorioDestino.exists()) {
					directorioDestino.mkdir();
				}

				for (String nombreArchivo : archivos) {

					File archivoOrigen = new File(directorioOrigen, nombreArchivo);
					File archivoDestino = new File(directorioDestino, nombreArchivo);

					copiarArchivos(archivoOrigen, archivoDestino);
				}
			} else {

				InputStream archivoEntrada = new FileInputStream(directorioOrigen);
				OutputStream archivoSalida = new FileOutputStream(directorioDestino);

				byte[] buffer = new byte[1024];

				int tamanoArchivo;

				while ((tamanoArchivo = archivoEntrada.read(buffer)) > 0) {
					archivoSalida.write(buffer, 0, tamanoArchivo);
				}

				archivoEntrada.close();
				archivoSalida.close();
			}
		} else {
			throw new NoExisteDirectorioException();

		}
	}

}
