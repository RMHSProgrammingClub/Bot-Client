package github.rmhsprogrammingclub.game.clientlauncher;

import com.n9mtq4.reflection.ReflectionHelper;
import github.rmhsprogrammingclub.botapi.MyBotCode;
import github.rmhsprogrammingclub.game.clientlauncher.classloader.JarLoader;
import github.rmhsprogrammingclub.game.clientlauncher.classloader.LibLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by will on 10/7/15 at 8:27 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 * @deprecated wont be used for now.
 */
@Deprecated
public final class ClientLauncher {
	
	private static final int BOT_CODE_PARAM_COUNT = 3;
	
	public static void main(String[] args) {
		
		LibLoader.loadLibs();
		
		File botFile = new File(args[0]);
		System.out.println("Adding bot jar: " + botFile.getAbsolutePath());
		try {
			JarLoader.addFile(botFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Method botMethod = findBotAi();
		System.out.println(botMethod);
		ReflectionHelper.callStaticObjectMethod(botMethod, null, 1, 2);
		
	}
	
	/**
	 * scans through every class file looking for the bot ai method
	 * */
	private static Method findBotAi() {
		
		Package[] packages = Package.getPackages(); // TODO: doesn't work!
		for (Package p : packages) {
			
			try {
				
				ArrayList<Class<?>> classesInPackage = ReflectionHelper.getClassesForPackage(p.getName());
				for (Class clazz : classesInPackage) {
					
					Method[] methodsOfClass = clazz.getDeclaredMethods();
					for (Method method : methodsOfClass) {
						
						// should remove the majority of methods
//						if (method.getParameterCount() != BOT_CODE_PARAM_COUNT) continue;
//						if (method.getReturnType() != null) continue;
						System.out.println(method.getName());
						if (method.isAnnotationPresent(MyBotCode.class)) {
//							this is a bot code method
							return method;
						}
						
					}
					
				}
				
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("No bot ai code found.");
		return null;
		
	}
	
	private ClientLauncher() {}
	
}
