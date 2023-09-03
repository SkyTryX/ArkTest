package fr.skytryx.pigmantest.commands;

import fr.skytryx.pigmantest.EmptyChunkGenerator;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

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
                commandSender.sendMessage("§c[Instance] §bL'Instance §6"+ strings[0] +" §ba été créé!");
            } else return false;
        } else return false;
        return true;
    }
}
