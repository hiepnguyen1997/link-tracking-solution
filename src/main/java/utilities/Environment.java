package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends Config{
	@Key("App.Url")
	String getAppURL();
	
	@Key("App.User")
	String getAppUserName();
	
	@Key("App.Pass")
	String getUserPasswork();
	
	@Key("DB.User")
	String getDBUserName();
	
	@Key("DB.Pass")
	String getDBPasswork();
	
}
 