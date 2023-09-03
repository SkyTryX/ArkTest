package fr.skytryx.pigmantest.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandTpinstance implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)) return false;
        if(strings.length == 1){
            if(Bukkit.getWorld(strings[0]) != null){
                ((Player) commandSender).teleport(new Location(Bukkit.getWorld(strings[0]), 0, 64, 0));
                commandSender.sendMessage("§c[Instance] §b Tu as été téléporté à l'instance §6"+strings[0]);
                return true;
            }
        }
        return false;
    }
}
