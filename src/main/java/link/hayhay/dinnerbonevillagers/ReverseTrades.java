package link.hayhay.dinnerbonevillagers;

import org.bukkit.Material;
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

public class ReverseTrades implements Listener {
    @EventHandler
    public void onVillagerTrade(PlayerInteractEntityEvent e) {

        // Reverses trades for villagers
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            Entity entity = e.getRightClicked();

            Material getClick = e.getPlayer().getInventory().getItemInMainHand().getType();

            if (!entity.getName().equals("Dinnerbone") && getClick != Material.NAME_TAG) {
                return;
            } else if (getClick == Material.NAME_TAG && !e.getRightClicked().getName().equals("Dinnerbone")) {
                ((Merchant) e.getRightClicked()).getRecipes().forEach((r) -> {
                    System.out.println("Dropped item");
                    e.getPlayer().getWorld().dropItemNaturally(e.getRightClicked().getLocation(), r.getIngredients().get(0));
                });
            }

            Merchant villager = (Merchant) e.getRightClicked();

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
