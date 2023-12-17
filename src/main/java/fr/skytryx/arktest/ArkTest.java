package fr.skytryx.arktest;

import fr.skytryx.arktest.commands.*;
import fr.skytryx.arktest.events.LobbyProtection;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class ArkTest extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("createinstance")).setExecutor(new CommandCreateinstance());
        Objects.requireNonNull(getCommand("deleteinstance")).setExecutor(new CommandDeleteinstance());
        Objects.requireNonNull(getCommand("listinstance")).setExecutor(new CommandListinstance());
        Objects.requireNonNull(getCommand("tpinstance")).setExecutor(new CommandTpinstance());
        Objects.requireNonNull(getCommand("download")).setExecutor(new CommandDownload());

        getServer().getPluginManager().registerEvents(new LobbyProtection(), this);

        final File instancefile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("ArkTest")).getDataFolder(), "instances.yml");
        final YamlConfiguration instanceconfig = YamlConfiguration.loadConfiguration(instancefile);
        Objects.requireNonNull(instanceconfig.getConfigurationSection("")).getValues(false).forEach((path, pl) -> {
            Objects.requireNonNull(Bukkit.createWorld(new WorldCreator(path))).save();
            Bukkit.getLogger().info("[Instance] L'instance "+path+" a été chargé");
        });
        Bukkit.getLogger().info("[ArkTest] Plugin Enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[ArkTest] Plugin Disabled");
    }
}
