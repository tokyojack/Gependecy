package packagename;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Test extends JavaPlugin {

	private Economy economy;

	// Plugin name, does disable the plugin if not found, and the JavaPlugin
	// instance.
	Gependecy vaultDependecy = new Gependecy("Vault", true, this) {

		// Code that runs if "Vault" is found
		@Override
		public void ifFound() {
			setupEconomy();
		}

		// Code that runs if "Vault" is NOT found
		@Override
		public void ifNotFound() {
			// Nothing happens.
		}
	};

	public void onEnable() {
		// Checks if the plugin when the plugin is enabled
		vaultDependecy.check();
	}

	public double getBalance(Player player) {
		if (!this.vaultDependecy.isFound()) {
			player.sendMessage("Cannot get your balance as 'Vault' is not available.");
			return -1.0; // -1 Means nothing, as 0 can be a players balance.
		}

		return this.economy.getBalance(player); // Returns the player's balance
	}

	// From Vault's WIKI if I'm correct
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null)
			economy = economyProvider.getProvider();

		return (economy != null);
	}

}