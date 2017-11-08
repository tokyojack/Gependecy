package packagename;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin {

	//Plugin name, does disable the plugin if not found, and the JavaPlugin instance.
	Gependecy vaultDependecy = new Gependecy("Vault", true, this) {

		@Override
		public void ifFound() {
			// Code that runs if found
		}

		@Override
		public void ifNotFound() {
			// Code that runs if NOT found
		}
	};

	public void onEnable() {
		//Checks if the plugin when the plugin is enabled
		vaultDependecy.check();
	}

	public void takeMoney(Player player) {
		if (this.vaultDependecy.isFound()) {
			// Take money
		} else {
			player.sendMessage("That plugin is not found :(");
		}
	}

}