package link.hayhay.PhoenixPlugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DinnerboneVillager implements Listener {
    @EventHandler
    public void onVillagerTrade(PlayerInteractEntityEvent e) {

        // Reverses trades for villagers
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            Entity entity = e.getRightClicked();
            Merchant villager = (Merchant) e.getRightClicked();
            if (!entity.getName().equals("Dinnerbone")) {
                return;
            }

            AtomicInteger index = new AtomicInteger();

            villager.getRecipes().forEach((r) -> {
                List<ItemStack> newIngredients = new ArrayList<>();

                newIngredients.add(r.getResult());

                MerchantRecipe reverse = new MerchantRecipe(r.getIngredients().get(0), 2);
                reverse.setIngredients(newIngredients);
                villager.setRecipe(index.getAndIncrement(), reverse);
            });
        }
    }
}
