<h2  align="center">Gependecy</h2>
<p  align="center">A easy util class for handling plugin dependencies</p>

<br/>

## Instructions:

1. Copy and paste the util class from ```src/me/tokyojack/bukkit``` to your project into a class called ```Gependecy```
2. Change the package at the top to your needed one, and you're good to go!

## To use:

Here's a quick example of it with Vault.
```
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
```

##

Now you've just obtained the plugin! You show now be able to finally manager your dependencies  ```ლ,ᔑ•ﺪ͟͠•ᔐ.ლ```
