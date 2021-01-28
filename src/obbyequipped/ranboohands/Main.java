package obbyequipped.ranboohands;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener {
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Material material = e.getBlock().getType();

		if (material == Material.GRASS || material == Material.TALL_GRASS || material == Material.CHEST
				|| material == Material.TRAPPED_CHEST) {
			return;
		}

		if (e.getPlayer() != null && e.getPlayer().getGameMode() == GameMode.SURVIVAL
				&& e.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR) {
			e.setDropItems(false);
			e.getPlayer().getWorld().dropItem(e.getBlock().getLocation().add(new Vector(0.5, 0.5, 0.5)),
					new ItemStack(material));
		}
	}

	@Override
	public void onEnable() {
		super.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}
}
