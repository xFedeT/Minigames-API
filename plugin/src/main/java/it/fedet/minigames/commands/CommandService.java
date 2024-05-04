package it.fedet.minigames.commands;

import it.fedet.minigames.MinigamesCore;
import it.fedet.minigames.api.services.Service;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class CommandService implements Service {

    private final MinigamesCore plugin;
    private final BukkitCommandHandler handler;

    public CommandService(MinigamesCore plugin) {
        this.plugin = plugin;
        this.handler = BukkitCommandHandler.create(plugin);
        this.handler.enableAdventure();
    }


    public void initCommands() {
        plugin.getCommands().forEach((clazz, command) -> handler.register(command));
    }

    @Override
    public void start() {
        initCommands();
    }

    @Override
    public void stop() {
        handler.unregisterAllCommands();
    }

}
