package fr.skytryx.pigmantest.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandListinstance implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage("§b--------§fLISTE INSTANCE§b--------");
        Bukkit.getWorlds().forEach(w -> commandSender.sendMessage("§6"+w.getName()));
        commandSender.sendMessage("§b------------------------------");
        return true;
    }
}
