package me.tokyojack.mcmarket.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Gependecy {

	private String pluginName;
	private JavaPlugin javaPlugin;

	public Gependecy(String pluginName, JavaPlugin javaPlugin) {
		this.pluginName = pluginName;
		this.javaPlugin = javaPlugin;
	}

	public abstract void ifFound();
	// public abstract void ifNotFound();

	//Making a "check" function as it's much more easier to understand.
	//As oppose to adding it in the constructor
	public void check() {
		if (Bukkit.getPluginManager().getPlugin(this.pluginName) == null
				|| !Bukkit.getPluginManager().getPlugin(this.pluginName).isEnabled()) {
			logToConsole(ChatColor.RED + "The plugin '" + this.pluginName + "' is not found. Plugin is disabeling.");
			Bukkit.getPluginManager().disablePlugin(javaPlugin);
			// ifNotFound();
		} else {
			logToConsole(ChatColor.GREEN + "The plugin '" + this.pluginName + "' has been found.");
			ifFound();
		}
	}

	public String getPluginName() {
		return this.pluginName;
	}

	public JavaPlugin getJavaPlugin() {
		return this.javaPlugin;
	}

	private void logToConsole(String message) {
		final String PREFIX = ChatColor.AQUA + "[Gependecy]";
		Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + " " + message);
	}
}
