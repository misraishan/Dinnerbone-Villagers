package link.hayhay.dinnerbonevillagers;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class DinnerboneVillagers extends JavaPlugin {

    Logger log = getLogger();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ReverseTrades(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
