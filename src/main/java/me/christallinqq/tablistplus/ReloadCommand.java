package me.christallinqq.tablistplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    TablistPlus tablistPlus;
    public ReloadCommand(TablistPlus tablistPlus) {
        this.tablistPlus = tablistPlus;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            tablistPlus.reloadConfig();
            sender.sendMessage("Reloaded Config");
        }

        if (sender instanceof Player && sender.isOp()) {
            tablistPlus.reloadConfig();
            sender.sendMessage("Reloaded Config");
        }

        return true;
    }
}
