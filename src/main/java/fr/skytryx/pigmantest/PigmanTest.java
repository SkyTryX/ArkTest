package fr.skytryx.pigmantest;

import fr.skytryx.pigmantest.commands.*;
import fr.skytryx.pigmantest.events.LobbyProtection;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class PigmanTest extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("createinstance")).setExecutor(new CommandCreateinstance());
        Objects.requireNonNull(getCommand("deleteinstance")).setExecutor(new CommandDeleteinstance());
        Objects.requireNonNull(getCommand("listinstance")).setExecutor(new CommandListinstance());
        Objects.requireNonNull(getCommand("tpinstance")).setExecutor(new CommandTpinstance());
        Objects.requireNonNull(getCommand("download")).setExecutor(new CommandDownload());

        getServer().getPluginManager().registerEvents(new LobbyProtection(), this);

        final File instancefile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("PigmanTest")).getDataFolder(), "skills.yml");
        final YamlConfiguration instanceconfig = YamlConfiguration.loadConfiguration(instancefile);
        Objects.requireNonNull(instanceconfig.getConfigurationSection("")).getValues(false).forEach((path, pl) -> Objects.requireNonNull(Bukkit.createWorld(new WorldCreator(path))).save());
        Bukkit.getLogger().info("[PigmanTest] Le plugin a été activé");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[PigmanTest] Le plugin a été desactivé");
    }
}
