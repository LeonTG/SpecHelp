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
 * Author: PolarBlunk
 */

public class InteractListener implements Listener {


    @EventHandler
    private void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.SPECTATOR) {

            Action action = event.getAction();

            if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {

                Random r = new Random();
                ArrayList<Player> players = new ArrayList<>();
                for (Player online : Bukkit.getServer().getOnlinePlayers()) {
                    if (online == player) {
                    } else
                        players.add(online);
                }
                if (players.isEmpty()) {
                    player.sendMessage(ChatColor.RED +  "Could not find anyone to teleport to.");
                    return;
                }
                int index = r.nextInt(players.size());
                Player target = players.get(index);
                player.teleport(target);
                player.sendMessage("§bTelporting you to " + ChatColor.GOLD + target.getName() + "§7.");






            }





        }
    }



}


