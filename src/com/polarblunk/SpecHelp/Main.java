package com.polarblunk.SpecHelp;

import com.polarblunk.SpecHelp.listeners.InteractListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Author: PolarBlunk
 */

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InteractListener(), this);
    }
    @Override
    public void onDisable(){
    }
}
