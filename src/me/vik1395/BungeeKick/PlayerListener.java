package me.vik1395.BungeeKick;

import net.md_5.bungee.api.AbstractReconnectHandler;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/*

Author: Vik1395
Project: BungeeKick

Copyright 2014

Licensed under Creative CommonsAttribution-ShareAlike 4.0 International Public License (the "License");
You may not use this file except in compliance with the License.

You may obtain a copy of the License at http://creativecommons.org/licenses/by-sa/4.0/legalcode

You may find an abridged version of the License at http://creativecommons.org/licenses/by-sa/4.0/
 */

public class PlayerListener implements Listener {

    BungeeKick plugin;

    public PlayerListener(BungeeKick plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onServerKickEvent(ServerKickEvent ev) 
    {
        ServerInfo kickedFrom = null;

        if (ev.getPlayer().getServer() != null) 
        {
            kickedFrom = ev.getPlayer().getServer().getInfo();
        } 
        
        else if (this.plugin.getProxy().getReconnectHandler() != null) 
        {
            kickedFrom = this.plugin.getProxy().getReconnectHandler().getServer(ev.getPlayer());
        } 
        
        else 
        {
            kickedFrom = AbstractReconnectHandler.getForcedHost(ev.getPlayer().getPendingConnection());
            if (kickedFrom == null)
            {
                kickedFrom = ProxyServer.getInstance().getServerInfo(ev.getPlayer().getPendingConnection().getListener().getDefaultServer());
            }
        }

        ServerInfo kickTo = this.plugin.getProxy().getServerInfo(BungeeKick.config.getString("ServerName"));
        
        if (kickedFrom != null && kickedFrom.equals(kickTo)) {
            return;
        }
        
        ev.setCancelled(true);
        ev.setCancelServer(kickTo);
        if(BungeeKick.config.getBoolean("ShowKickMessage"))
        {
	        String msg = BungeeKick.config.getString("KickMessage");
	        msg = ChatColor.translateAlternateColorCodes('&', msg);
	        String kmsg = ChatColor.stripColor(BaseComponent.toLegacyText(ev.getKickReasonComponent()));
	        msg = msg + kmsg;
	        ev.getPlayer().sendMessage(new TextComponent(msg));
        }
    }
}
