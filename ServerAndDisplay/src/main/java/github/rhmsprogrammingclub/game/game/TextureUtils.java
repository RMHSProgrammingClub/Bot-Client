package github.rhmsprogrammingclub.game.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by will on 10/11/15 at 1:46 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class TextureUtils {
	
	public static BufferedImage readImage(String filePath) {
		
		try {
			return ImageIO.read(TextureUtils.class.getResource(filePath));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
