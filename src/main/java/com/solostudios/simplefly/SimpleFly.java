package com.solostudios.simplefly;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;


public class SimpleFly extends JavaPlugin {
    @Override
    public void onEnable() {
        ToggleFlyCommand toggleFlyCommand = new ToggleFlyCommand();
        
        getCommand("togglefly").setExecutor(toggleFlyCommand);
        getCommand("togglefly").setTabCompleter(toggleFlyCommand);
    }
    
}
