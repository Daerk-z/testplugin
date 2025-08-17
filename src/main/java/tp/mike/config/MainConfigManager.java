package tp.mike.config;

import tp.mike.TestPlugin;

public class MainConfigManager {

    private CustomConfig configFile;
    private TestPlugin plugin;

    public MainConfigManager(TestPlugin plugin){
        this.plugin = plugin;
        configFile = new CustomConfig("config.yml", null, plugin);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){

    }
}
