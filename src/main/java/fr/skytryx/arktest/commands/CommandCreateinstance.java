package fr.skytryx.arktest.commands;

import fr.skytryx.arktest.EmptyChunkGenerator;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CommandCreateinstance implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            if(Bukkit.getWorld(strings[0]) == null){
                WorldCreator wc = new WorldCreator(strings[0]);
                wc.generator(new EmptyChunkGenerator());
                World world = wc.createWorld();
                assert world != null;
                world.setGameRule(GameRule.DO_MOB_SPAWNING, Boolean.FALSE);
                world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, Boolean.FALSE);
                world.setGameRule(GameRule.DO_WEATHER_CYCLE, Boolean.FALSE);
                world.save();
                final File instancefile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("ArkTest")).getDataFolder(), "instances.yml");
                final YamlConfiguration instanceconfig = YamlConfiguration.loadConfiguration(instancefile);
                instanceconfig.set(strings[0], strings[0]);
                try {
                    instanceconfig.save(instancefile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                commandSender.sendMessage("§c[Instance] §bL'Instance §6"+ strings[0] +" §ba été créé!");
            } else return false;
        } else return false;
        return true;
    }
}
