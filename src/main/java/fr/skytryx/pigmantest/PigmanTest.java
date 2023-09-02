package fr.skytryx.pigmantest;

import fr.skytryx.pigmantest.commands.CommandCreateinstance;
import fr.skytryx.pigmantest.commands.CommandDeleteinstance;
import fr.skytryx.pigmantest.commands.CommandListinstance;
import fr.skytryx.pigmantest.commands.CommandTpinstance;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PigmanTest extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("createinstance")).setExecutor(new CommandCreateinstance());
        Objects.requireNonNull(getCommand("deleteinstance")).setExecutor(new CommandDeleteinstance());
        Objects.requireNonNull(getCommand("listinstance")).setExecutor(new CommandListinstance());
        Objects.requireNonNull(getCommand("tpinstance")).setExecutor(new CommandTpinstance());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
