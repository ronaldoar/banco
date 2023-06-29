package br.com.banco.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;







/**
 * Classe <code>FileUtils</code>.<br/>
 * 
 * Define classe de utiliarios de arquivos.
 * 
 * @author ronaldo alves rios
 * @since 2016-06-20
 * @version 1.0.0
 *
 */
public class FileUtils {
	
	/**
	 * Efetua a busca em cada linha de cada arquivo de texto obtendo a linha caso constar ums dos parametros
	 * de busca informado.
	 * @param origem    - diretorio de origem
	 * @param destino   - diretorio de destino
	 * @param params    - valores a serem encontrados 
	 * @param fileNames - nomes dos arquivos de texto onde as buscas serao efetuadas
	 * @throws Exception
	 * @throws Exception
	 */
	public static void searchAndBuilder(String origem, String destino, List<String>params, List<String>fileNames) throws Exception {
		
		StringBuffer buffer =  new StringBuffer();
		File[]array         =  FileUtils.loadAllfiles(origem);
		
		for(int i=0; i<array.length; i++){
			buffer.append(FileUtils.readFile(origem +"/", array[i].getName(), new String[]{params.get(i)}));
		}
		FileUtils.createTextFile(destino, buffer.toString());
	}
	
	
	
	/**
	 * Obtem os bytes do arquivo
	 * @param fileName - local e nome do arquivo
	 * @return
	 * @throws IOException
	 */
//	public static byte[] getByteArray(String fileName) throws IOException {
//		FileInputStream stream = new FileInputStream(new File(fileName));
//	    return IOUtils.toByteArray(stream);
//	}
	
	
	/**
	 * Obtem um File de um array de bytes;
	 * @param bytes
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static File toFile(byte[]bytes, String path) throws IOException {
		Path p = Files.write(new File(path).toPath(), bytes);
		return p.toFile();
	}
	
	/**
	 * Obtem os bytes do arquivo
	 * @param file - arquivo
	 * @return
	 * @throws IOException
	 */
//	public static byte[] getByteArray(File file) throws IOException {
//		FileInputStream stream = new FileInputStream(file);
//		return IOUtils.toByteArray(stream);
//	}
	
	/**
	 * Obtem o inputStream do arquivo
	 * @param fileName - caminho absoluto do arquivo.
	 * @return
	 * @throws FileNotFoundException
	 */
	public static FileInputStream getInputStream(String fileName) throws FileNotFoundException{
		return new FileInputStream(new File(fileName));
	}
	

	/**
	 * Efetua a leitura de todos os arquivos
	 * @param directory - path e nome do diretorio
	 * @return File[]
	 */
	public static File[] loadAllfiles(String directory){
		File file = new File(directory);
		return file.listFiles();
	}
	
	/**
	 * Obtem o arquivo 
	 * @param fileName - caminho absoluto do arquivo
	 * @return
	 * @throws FileNotFoundException
	 */
	public static File getFile(String fileName) throws FileNotFoundException {
		return new File(fileName);
	}
	
	
	/**
	 * Move o arquivo de um local para o outro com um novo nome.
	 * @param origem       - caminho completo do arquivo
	 * @param destino      - diretorio de destino
	 * @param newFileName  - novo nome do arquivo
	 * @throws IOException
	 */
	public static void move(String origem, String destino, String newFileName) throws IOException {
		File oldFile = new File(origem);
		File newFile = new File(destino, newFileName);
		Files.move(oldFile.toPath(), newFile.toPath());
	}

	/**
	 * Move o arquivo de um local para o outro.
	 * @param origem       - caminho completo do arquivo
	 * @param destino      - diretorio de destino
	 * @throws IOException
	 */
	public static void move(String origem, String destino) throws IOException {
		File oldFile = new File(origem);
		File newFile = new File(destino);
		Files.move(oldFile.toPath(), newFile.toPath());
	}

	/**
	 * Copia o arquivo de um local para o outro.
	 * @param origem       - caminho completo do arquivo
	 * @param destino      - caminho completo do arquivo
	 * @throws IOException
	 */
	public static void copy(String origem, String destino) throws IOException {
		File oldFile = new File(origem);
		File newFile = new File(destino);
		Files.copy(oldFile.toPath(), newFile.toPath());
	}
	
	/**
	 * Copia o arquivo de um local para o outro, com um novo nome.
	 * @param origem
	 * @param destino
	 * @param newFileName
	 * @throws IOException
	 */
	public static void copy(String origem, String destino, String newFileName) throws IOException {
		File oldFile = new File(origem);
		File newFile = new File(destino, newFileName);
		Files.copy(oldFile.toPath(), newFile.toPath());
	}
	
	/**
	 * Efetua a leitura de um arquivo.
	 * @param filePath - caminho do arquivo
	 * @param fileName - nome do arquivo
	 * @return <code>StringBuffer.</code> objeto de manipulacao de grande quantidade de texto
	 * @throws Exception
	 */
	public static StringBuffer readFile(String fileName) throws Exception {
		
		StringBuffer texto = null;
		
		try {
			
			File file 					= new File(fileName);
			FileReader fileReader 		= new FileReader(file);
			BufferedReader reader		= new BufferedReader(fileReader);
			String linha 				= null;
			texto						= new StringBuffer();
			
			while((linha = reader.readLine()) != null){
				texto.append(" "+linha.trim()+"\n");
			}
			
			fileReader.close();  
			reader.close();
			
		}catch(FileNotFoundException ex){
			throw new Exception(ex.getMessage());
		}catch(IOException ex){
			throw new Exception(ex.getMessage());
		}
		return texto;
	}
	
	/**
	 * Efetua a leitura de um arquivo.
	 * @param filePath - caminho do arquivo
	 * @param fileName - nome do arquivo
	 * @return <code>StringBuffer.</code> objeto de manipulacao de grande quantidade de texto
	 * @throws Exception
	 */
	public static StringBuffer readFile(String filePath, String fileName) throws Exception {
		
		StringBuffer texto = null;
		
		try {
			
			File file 					= new File(filePath+fileName);
			FileReader fileReader 		= new FileReader(file);
			BufferedReader reader		= new BufferedReader(fileReader);
			String linha 				= null;
			texto						= new StringBuffer();
			
			while((linha = reader.readLine()) != null){
				texto.append(" "+linha.trim()+"\n");
			}
			
			fileReader.close();  
			reader.close();
			
		}catch(FileNotFoundException ex){
			throw new Exception(ex.getMessage());
		}catch(IOException ex){
			throw new Exception(ex.getMessage());
		}
		return texto;
	}
	
	/**
	 * Efetua a leitura de um arquivo e retorna texto customizado com
	 * base no parametros informados
	 * @param filePath
	 * @param fileName
	 * @param paramFind
	 * @return
	 * @throws Exception
	 */
	public static StringBuffer readFile(String filePath, String fileName, String[] paramsFind) throws Exception {
		
		StringBuffer texto = null;
		
		try {
			
			File file 					= new File(filePath+fileName);
			FileReader fileReader 		= new FileReader(file);
			BufferedReader reader		= new BufferedReader(fileReader);
			String linha 				= null;
			texto						= new StringBuffer();
			
			while((linha = reader.readLine()) != null){
				
				for(String param : paramsFind){
					
					if(linha.contains(param)){
						texto.append(" "+linha.trim()+"\n");
					}
				}
			}
			
			fileReader.close();  
			reader.close();
			
		}catch(FileNotFoundException ex){
			throw new Exception(ex.getMessage());
		}catch(IOException ex){
			throw new Exception(ex.getMessage());
		}
		return texto;
	}
	
	/**
	 * Cria arquivos em disco.
	 * @param filePath - caminho e nome do arquivo sem extensao
	 * @param text     - conteudo do arquivo.
	 * @throws Exception
	 */
	public static void createTextFile(String filePath, String text) throws Exception {
		
		try {
			File file = new File(filePath+".txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        output.write(text);
	        output.close();
	        
		}catch (IOException ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	/**
	 * Salva arquivos em disco.
	 * @param inputStream
	 * @param absolutePath
	 * @throws IOException
	 */
//	public static void saveFile(InputStream inputStream, String absolutePath) throws IOException {
//		OutputStream out = new FileOutputStream(new File(absolutePath));
//		out.write(IOUtils.toByteArray(inputStream));
//		out.close();
//	}
	
	
	/**
	 * Salva arquivos no diretorio
	 * @param files
	 * @param directory
	 * @throws IOException
	 */
//	public static void saveFile(List<File>files, String directory) throws IOException {
//		
//		for(File f : files){
//			byte[]file = getByteArray(f);
//			saveFile(file, directory);
//		}
//	}
	
	/**
	 * Salva um array de bytes que representa um arquivo.
	 * @param content  - array de bytes
	 * @param filename - caminho absoluto do arquivo.
	 * @throws IOException
	 */
	public static void saveFile(byte[]content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);
		fop.write(content);
		fop.flush();
		fop.close();
	}
	
	/**
	 * Atualiza o arquivo de text com uma linha de texto.
	 * @param absolutePath - caminho completo do arquivo
	 * @param lineText     - linha de texto a ser adicionada no final do conteudo do arquivo.
	 * @throws IOException
	 */
	public static void updateFile(String absolutePath, String lineText) throws IOException {
		
		File file 			   = new File(absolutePath);
		FileWriter fileWritter = new FileWriter(file,true);

        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(lineText);
        bufferWritter.newLine();
        bufferWritter.close();
	}
	
	/**
	 * Atualiza o arquivo de text com uma linha de texto.
	 * @param file
	 * @param lineText
	 * @throws IOException
	 */
	public static void updateFile(File file, String lineText) throws IOException {
		
		FileWriter fileWritter = new FileWriter(file,true);
		
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		bufferWritter.write(lineText);
		bufferWritter.newLine();
		bufferWritter.close();
	}
	
	/**
	 * Obtem o nome do arquivo
	 * @param absolutePath - caminha absoluto do arquivo
	 * @return
	 */
	public static String getFileName(String absolutePath){
		int index = absolutePath.lastIndexOf("\\");
		return absolutePath.substring(index + 1);
	}
	
	/**
	 * Obtem apenas o caminho do arquivo
	 * @param absolutePath
	 * @return
	 */
	public static String getFilePath(String absolutePath){
		int index    = absolutePath.lastIndexOf("\\");
		return absolutePath.substring(0, index + 1);
	}
	
	/**
	 * Formata o nome do arquivo de acordo 
	 * com a identificacao correspondente no banco de dados.
	 * @param absolutePath - caminho e nome completo do arquivo
	 * @param id - key do registro no banco
	 * @return id_fileName
	 */
	public static String formatFileName(String absolutePath, Long id){
		String name = FileUtils.getFileName(absolutePath);
		return id+"_"+name;
	}
	
	
	/**
	 * Excluir o arquivo do disco
	 * @param filePath - caminho completo do arquivo
	 * @throws Exception
	 */
//	public static void deleteFile(String filePath) throws Exception {
//		File file = new File(filePath);
//		org.apache.commons.io.FileUtils.forceDelete(file);
//	}
	
	/**
	 * Exclui odiretorio e seu conteudo.
	 * @param directory
	 * @throws IOException
	 */
//	public static void deleteAll(String directory) throws IOException {
//		org.apache.commons.io.FileUtils.deleteDirectory(new File(directory));
//	}
	
	/**
	 * Retorna uma lista arquivos.
	 * @param pathDirectory - path dos arquivos
	 * @return List
	 * @throws Exception
	 */
	public static List<File> loadAll(String pathDirectory) throws Exception {
		File directory = new File(pathDirectory);
		if(!directory.exists())throw new Exception("[FILE-ERROR]: O diretorio nao existe.");
		if(!directory.isDirectory())throw new Exception("[FILE-ERROR]: A string nao representa um diretorio.");
		return Arrays.asList( directory.listFiles() );
	}
	
	/**
	 * Obtem a lista de nomes dos arquivos.
	 * @param pathDirectory - paht do arquivo.
	 * @return
	 * @throws Exception
	 */
	public static List<String> loadAllNameFiles(String pathDirectory) throws Exception {
		List<File>files   = loadAll(pathDirectory);
		List<String>names = new ArrayList<String>();
		
		for(File f : files){
			names.add(f.getName());
		}
		return names;
	}
	
	/**
	 * Pesquisa nomes de arquivos.
	 * @param names - lista de nomes de arquivos.
	 * @param word  - nome ou parte do nome de um arquivo.
	 * @return List
	 */
	public static List<String> searchFileName(List<String>names, String word){
		List<String>results    = new ArrayList<String>();
		
		for(String name : names){
			if(name.contains(word)){
				results.add(name);
			}
		}
		return results;
	}

}
