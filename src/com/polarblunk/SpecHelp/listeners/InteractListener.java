package com.polarblunk.SpecHelp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author PolarBlunk
 */
public class InteractListener implements Listener {
    private final Random rand = new Random();

    @EventHandler
    private void on(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        if (player.getGameMode != GameMode.SPECTATOR) {
            return;
        }
        
        Action action = event.getAction();
        
        if (!action.equals(Action.LEFT_CLICK_AIR) && !action.equals(Action.LEFT_CLICK_BLOCK) {
            return;
        }

        List<Player> players = Lists.newArrayList(Bukkit.getOnlinePlayers());
        players.remove(player); // we don't want the player to teleport to themselves.
        
        if (players.isEmpty()) {
            player.sendMessage(ChatColor.RED +  "Could not find anyone to teleport to.");
            return;
        }
        
        Player target = players.get(rand.nextInt(players.size()));
        
        player.teleport(target);
        player.sendMessage(ChatColor.AQUA + "Telporting you to " + ChatColor.GOLD + target.getName() + ChatColor.AQUA + ".");
    }
}
