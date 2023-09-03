package fr.skytryx.pigmantest.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.codehaus.plexus.util.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CommandDeleteinstance implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            if(!(Bukkit.getWorld(strings[0]) == null)){
                Objects.requireNonNull(Bukkit.getWorld(strings[0])).getPlayers().forEach(Player::kick);
                try {
                    FileUtils.deleteDirectory(new File(strings[0]));
                    commandSender.sendMessage("§c[Instance] §bVous avez supprimé l'instnace §6"+ strings[0]);
                } catch (IOException e) {
                    Bukkit.getLogger().warning("[Instance] Le fichier du monde n'éxiste pas");
                }
            }
        } else return false;
        return true;
    }
}
