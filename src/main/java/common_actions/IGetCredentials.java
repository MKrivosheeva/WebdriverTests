package common_actions;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credentials.properties"})
public interface IGetCredentials extends Config {
 String login();
 String password();

}
