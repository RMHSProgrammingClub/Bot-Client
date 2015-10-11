package github.rmhsprogrammingclub.game.serverlauncher.classpath;

import java.io.File;
import java.io.IOException;

/**
 * Created by will on 8/19/15 at 2:38 PM.
 */
public final class LibLoader {
	
	/**
	 * no instances here
	 * */
	private LibLoader() {}
	
	private static final String DEFAULT_LIB_DIRECTORY = "libs/";
	
	public static void loadLibs() {
		loadLibs(DEFAULT_LIB_DIRECTORY);
	}
	
	/**
	 * Adds every thing in libs/ to the classpath
	 * */
	public static void loadLibs(String directory) {
		
		File libDir = new File(directory);
		File[] libs = libDir.listFiles();
		if (libs == null) return;
		for (File file : libs) {
			
//			checks to make sure its loadable
			if (!file.isDirectory() && (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")) && !file.getName().startsWith(".")) {
				try {
					JarLoader.addFile(file);
					System.out.println("Succeeded in adding " + file.getAbsolutePath() + " as a library!");
				}catch (IOException e) {
					System.out.println("Failed to add " + file.getAbsolutePath() + " as a library!");
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
