package me.christallinqq.tablistplus;

import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class Tablist implements Runnable {
    TablistPlus tablistPlus;

    public Tablist(TablistPlus tablistPlus) {
        this.tablistPlus = tablistPlus;
    }

    public void run() {
        try {
            if (Bukkit.getOnlinePlayers().size() == 0) {
                return;
            }

            for (Player player : Bukkit.getOnlinePlayers()) {
                StringBuilder head = new StringBuilder();
                StringBuilder footer = new StringBuilder();
                List<String> headerlist = tablistPlus.getConfig().getStringList("tablist.header");
                List<String> footerlist = tablistPlus.getConfig().getStringList("tablist.footer");

                for (int i = 0; i < headerlist.size(); i++) {
                    if (i == (headerlist.size() - 1)) {
                        head.append(headerlist.get(i));
                    } else {
                        head.append(headerlist.get(i)).append("\n");
                    }
                }

                for (int i = 0; i < footerlist.size(); i++) {
                    if (i == (footerlist.size() - 1)) {
                        footer.append(footerlist.get(i));
                    } else {
                        footer.append(footerlist.get(i)).append("\n");
                    }
                }

                player.setPlayerListHeaderFooter(new ComponentBuilder(TablistPlus.parseText(player, head.toString())).create(), new ComponentBuilder(TablistPlus.parseText(player, footer.toString())).create());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
