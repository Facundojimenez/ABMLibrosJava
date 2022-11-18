package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.LibroDao;
import model.Libro;

/**
 * Capa de servicio de libro.
 * Realiza la comunicacion de la interfaz
 */
public class LibroService {

	private LibroDao libroDao;
	private static LibroService instancia;

	private LibroService() {
		libroDao = LibroDao.obtenerSingletonInstance();
	}

	public static LibroService obtenerSingletonInstance() {
		if(instancia == null) {
			instancia = new LibroService();
		}
		return instancia;
	}

	public Libro obtenerLibro(String isbn) {
		return libroDao.obtenerLibro(isbn);
	}

	public boolean guardar(Libro libro) {
		return libroDao.guardar(libro);
	}

	public List<Libro> ordenar() {
		return libroDao.ordenar();
	}

	public List<Libro> eliminar(String isbn) {
		return libroDao.eliminar(isbn);
	}
	
	public List<Libro> obtenerLibros() {
		return libroDao.obtenerLibros();
	}

	public List<Libro> obtenerLibroConFiltro(String isbn, String titulo, String autor, String editorial, String edicion, String anioPublicacion) {
		List<Libro> libros = this.obtenerLibros(), resultado = new ArrayList<>();
		for (Libro libro : libros) {
			if (libroEsValido(libro, isbn, titulo, autor, editorial, edicion, anioPublicacion)) {
				resultado.add(libro);
			}
		}
		
		return resultado;
	}

	private boolean libroEsValido(Libro libro, String isbn, String titulo, String autor, String editorial, String edicion, String anioPublicacion) {

		boolean coincidencia = false;
		
		if ( !coincidencia && libro.obtenerISBN().equals(isbn)) { 
			coincidencia = true;
		}
		
		if ( !coincidencia && libro.obtenerTitulo().equals(titulo)) { 
			coincidencia = true;
		}
		
		if ( !coincidencia && libro.obtenerAutor().equals(autor)) { 
			coincidencia = true;
		}
		
		if ( !coincidencia && libro.obtenerEditorial().equals(editorial)) {
			coincidencia = true;
		}
		
		if ( !coincidencia && libro.obtenerEdicion().toString().equals(edicion)) {
			coincidencia = true;
		}
		
		if ( !coincidencia && libro.obtenerAnioPublicacion().toString().equals(anioPublicacion)) {
			coincidencia = true;
		}
		
		return coincidencia;
	}


//	private Libro agregar() throws Exception{
//
//		String isbn = txfISBN.getText();
//		String titulo = txfTitulo.getText();
//		String autor = txfAutor.getText();
//		String editorial = txfEditorial.getText();
//		String edicion = txfEdicion.getText();
//		String anioPublicacion = txfAnioPublicacion.getText();
//
//		if(hayCamposVacios(isbn, titulo, autor, editorial, edicion,anioPublicacion)){
//			throw new Exception("Hay campos vacios");
//		}
//
//		if( isbn.length() != 10 && isbn.length() != 13 )
//			throw new Exception("Longitud incorrecta del ISBN");
//
//		if( !esNumerico(isbn) )
//			throw new Exception("ISBN es un campo numérico");
//
//		if( titulo.length() == 0 )
//			throw new Exception("Campo Título vacío");
//
//		if( !esAlfanumerico(titulo) )
//			throw new Exception("Título es un campo alfanumérico");
//
//		if( autor.length() == 0 )
//			throw new Exception("Campo Autor vacío");
//
//		if( !esAlfabetico(autor) )
//			throw new Exception("Autor es un campo alfabético");
//
//		if( editorial.length() == 0 )
//			throw new Exception("Campo Editorial vacío");
//
//		if( !esAlfabetico(editorial) )
//			throw new Exception("Editorial es un campo alfabético");
//
//		if( !esNumerico(edicion) )
//			throw new Exception("Edición es un campo numérico");
//
//		if( !verificarRango(edicion, 1, 99))
//			throw new Exception("Edicion fuera del rango 1-99");
//
//		if( edicion.length() > 2 )
//			throw new Exception("Longitud incorrecta del numero de Edicion");
//
//		if( !esNumerico(anioPublicacion) )
//			throw new Exception("Año de publicación es un campo numérico");
//
//		if( !verificarRango(anioPublicacion, 1900, 2022) )
//			throw new Exception("Año de publicacion fuera del rango 1900-2022");
//
//		return new Libro(isbn, titulo, autor, editorial, edicion, anioPublicacion);
//	}


//	private boolean atributoEsIgualAValor(String atributo, String valor) {
//		if (!valor.isEmpty() && !atributo.equalsIgnoreCase(valor)) {
//			return true;
//		}
//		return false;
//	}
//
//	private boolean atributoContieneValor(String atributo, String valor) {
//		if (!valor.isEmpty() && !atributo.toUpperCase().contains(valor.toUpperCase())) {
//			return true;
//		}
//		return false;
//	}
//
//	private boolean atributoComienzaConValor(Integer atributo, String valor) {
//		if (!valor.isEmpty() && !String.valueOf(atributo).startsWith(valor)) {
//			return true;
//		}
//		return false;
//	}
}
