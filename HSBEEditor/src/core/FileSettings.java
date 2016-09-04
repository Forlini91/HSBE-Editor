package core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ui_frames.IniEditor;


/**
 * Manage the application configuration file
 * @author MarcoForlini
 */
public class FileSettings {

	private static String jarLocation = FileSettings.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "HSBE Editor.ini";
	private static File file = new File(jarLocation);
	
	static{
		System.out.println("Settings file (" + (file.exists() ? "exists" : "doesn't exist")+ "):" + jarLocation);
	}

	/**
	 * Load the settings
	 */
	public static void load() {
		try (DataInputStream  dis = new DataInputStream(new FileInputStream(file))){
			System.out.println("Loading settings < " + file.getPath());
			IniEditor.defaultUIEditor = dis.readBoolean();
			IniEditor.UIeditorLeft = dis.readBoolean();
			IniEditor.minGroup = dis.readInt();
			IniEditor.maxGroup = dis.readInt();
			IniEditor.tabSize = dis.readInt();
			System.out.println("Loaded settings: " + IniEditor.defaultUIEditor + ", " + IniEditor.UIeditorLeft + ", " + IniEditor.minGroup + ", " + IniEditor.maxGroup + ", " + IniEditor.tabSize);
		} catch (FileNotFoundException e) {
			//Nothing to do
		} catch (IOException e) {
			System.out.println("An error occurred while loading the configuration file");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Save the settings
	 */
	public static void save() {
		try (DataOutputStream  dos = new DataOutputStream (new FileOutputStream (file))){
			System.out.println("Save settings > " + file.getPath());
			dos.writeBoolean(IniEditor.defaultUIEditor);
			dos.writeBoolean(IniEditor.UIeditorLeft);
			dos.writeInt(IniEditor.minGroup);
			dos.writeInt(IniEditor.maxGroup);
			dos.writeInt(IniEditor.tabSize);
			System.out.println("Saved settings: " + IniEditor.defaultUIEditor + ", " + IniEditor.UIeditorLeft + ", " + IniEditor.minGroup + ", " + IniEditor.maxGroup + ", " + IniEditor.tabSize);
		} catch (IOException e) {
			System.out.println("An error occurred while saving the configuration file");
			System.out.println(e.getMessage());
		}
	}

}
