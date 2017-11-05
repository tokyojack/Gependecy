package me.tokyojack.mcmarket.util;

import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin {

	private PluginApi pluginApi;

	public void onEnable() {
		
		new Gependecy("PluginApi", this) {

			@Override
			public void ifFound() {
				//Example
				this.pluginAPI = PluginAPI.getInstance();
			}
		}.check();

	}
}