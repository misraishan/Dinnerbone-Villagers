package link.hayhay.PhoenixPlugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class PhoenixPlugin extends JavaPlugin {

    Logger log = getLogger();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DinnerboneVillager(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
