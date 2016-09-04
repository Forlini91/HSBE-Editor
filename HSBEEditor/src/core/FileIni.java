package core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Manage the file loading/saving
 * @author MarcoForlini
 *
 */
public class FileIni {
	
	private static final FileNameExtensionFilter ffi = new FileNameExtensionFilter("Configuration file (*.ini)", "ini"); //new FileFilterImpl("Configuration file (*.ini)", "ini");
	private File file = null;

	/** File not selected exception */
	public static final IllegalStateException fns = new IllegalStateException("File non selezionato");
	/** File not existent exception */
	public static final IllegalStateException fne = new IllegalStateException("File non esistente");


	/**
	 * Ask the user to choose a file
	 * @param dialog	The text of the dialog button
	 * @param save		If true, it's a save dialog: user can choose a new file
	 * @return			The file choosen
	 * @throws IllegalStateException	If no file has been choosen
	 */
	public static File chooseFile(String dialog, boolean save) throws IllegalStateException {
		JFileChooser chooseFile = new JFileChooser(new File("."));
		chooseFile.setAcceptAllFileFilterUsed(false);
		chooseFile.setFileHidingEnabled(false);
		chooseFile.setFileFilter(ffi);
		chooseFile.resetChoosableFileFilters();
		chooseFile.addChoosableFileFilter(ffi);
		chooseFile.setVisible(true);
		chooseFile.setDialogType(save ? JFileChooser.SAVE_DIALOG : JFileChooser.OPEN_DIALOG);
		
		int response = chooseFile.showDialog(null, dialog);
		
		if (response == JFileChooser.APPROVE_OPTION) {
			File choosenFile = chooseFile.getSelectedFile();
			String path = choosenFile.getPath();
			if (path.endsWith(".")){
				choosenFile = new File(path + "ini");
			} else if (!path.endsWith(".ini")){
				choosenFile = new File(path + ".ini");
			}
			return choosenFile;
		}
		throw fns;
	}
	
	/**
	 * Create a new FileIni
	 * @param path		The file path
	 * @param dialog	The text of the dialog button
	 * @param save		If true, it's a save dialog: user can choose a new file
	 * @throws IllegalStateException	If no file has been choosen
	 */
	public FileIni (String path, String dialog, boolean save) throws IllegalStateException {
		this(new File (path), dialog, save);
	}

	/**
	 * Create a new FileIni
	 * @param file		The file
	 * @param dialog	The text of the dialog button
	 * @param save		If true, it's a save dialog: user can choose a new file
	 * @throws IllegalStateException	If no file has been choosen
	 */
	public FileIni (File file, String dialog, boolean save) throws IllegalStateException {
		if (file == null){
			this.file = chooseFile(dialog, save);
		} else {
			this.file = file;
		}
		if (!save && file != null && !file.exists()){
			throw fne;
		}
	}
	
	
	
	/**
	 * Get the choosen file
	 * @return	The choosen file
	 */
	public File getFile(){
		return file;
	}

	/**
	 * Save the given bars to file
	 * @param bars			The bars to save
	 * @throws IOException	If any IO error occurs
	 */
	public void save(TreeSet<Bar> bars) throws IOException {
		System.out.println("Save > " + file.getPath());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write("; " + file.getName() + "\n\n\n");
			for(Bar bar : bars){
				bw.write(bar.toCode() + "\n\n\n");
			}
		}
	}

	/**
	 * Save the given bar to file
	 * @param bar			The bar to save
	 * @throws IOException	If any IO error occurs
	 */
	public void save(Bar bar) throws IOException {
		System.out.println("Save > " + file.getPath());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write("; " + file.getName() + "\n\n");
			bw.write(bar.toCode());
		}
	}

	/**
	 * Load the bars from file
	 * @return				The bars loaded
	 * @throws IOException	If any IO error occurs
	 */
	public Set<Bar> load() throws IOException {
		System.out.println("Load < " + file.getPath());
		Set<Bar> bars = new HashSet<>();
		try (Scanner sc = new Scanner(file)){
			Bar bar;
			int nb = 0;
			while(sc.hasNextLine()){
				bar = new Bar("Bar " + nb, nb, sc);
				if (bar.numFields() > 0){
					bars.add(bar);
				}
				nb++;
			}
		}
		return bars;
	}

}
