package ar.edu.untref.aydoo;


import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class LectorDeArchivoTest {

	@Test
	public void LeeyGuardaElArchivoEnUnaListaCorrectamente() throws IOException{
		
		LectorDeArchivo lector = new LectorDeArchivo();
		lector.leerArchivo("/home/alejandro/aydoo-2016-e2/template/textoAProcesar.md");
		
		Assert.assertEquals("#esto es un titulo", lector.getContenido(0));
		Assert.assertEquals("##esto es un sub-titulo", lector.getContenido(1));
		Assert.assertEquals("i:estoEsUnaImagen.png", lector.getContenido(2));
		Assert.assertEquals("#esto es otro titulo", lector.getContenido(3));
	}

}