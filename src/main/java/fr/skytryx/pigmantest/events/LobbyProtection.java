package fr.skytryx.pigmantest.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class LobbyProtection implements Listener {

    @EventHandler
    public void AntiGrief1(BlockBreakEvent event){
        if(event.getPlayer().getWorld().getName().equals("world")){
            event.setCancelled(true);
            event.getPlayer().sendMessage("§cVous ne pouvez pas modifier le lobby mais uniquement les autres instances du serveur de test");
        }
    }

    @EventHandler
    public void AntiGrief2(BlockPlaceEvent event){
        if(event.getPlayer().getWorld().getName().equals("world")){
            event.setCancelled(true);
            event.getPlayer().sendMessage("§cVous ne pouvez pas modifier le lobby mais uniquement les autres instances du serveur de test");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 0, 64, 0));
        event.getPlayer().sendMessage("§bBienvenue dans le serveur de §6Test\n" +
                "§bC'est ici que sont testés les §6plugins §bet\n" +
                "§bque les maps sont §6construites!");
    }
}
