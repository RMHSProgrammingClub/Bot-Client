package github.rmhsprogrammingclub.botapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by will on 10/6/15 at 6:10 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BotTicker {
	
	String teamName() default "Enter your team name!";
	
}
