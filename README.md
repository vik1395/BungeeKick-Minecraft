BungeeKick works kind of like [MoveMeNow](http://www.spigotmc.org/resources/movemenow.17/). When players are kicked from a proxied server, they are pushed to the lobby instead of quitting the session, and are given the kick reason as a message. BungeeKick doesnt have the Blacklist/Whitelist compatibility like MoveMeNow. You can try my Bukkit plugin [WhitelistPerm](http://www.spigotmc.org/resources/whitelistperm.1309/) for this.

Please report any issues with this plugin [HERE](https://github.com/vik1395/BungeeKick-Minecraft/issues)

If you like my work, please consider donating, I would greatly appreciate it. [![Image](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=vik1395lp%40gmail%2ecom&lc=US&item_name=Spigot%20Plugins&item_number=LegitPlay%2enet%20Plugin%20Dev&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

**Config.yml**
-------------
This can be found under /plugins/BungeeKick folder.

Kick Message supports color. Just use minecraft color codes. you can use the '&' symbol instead of '§' as well.

    ServerName: 'lobby'
    
    # This is where the player is kicked to. This is usually the lobby/hub server
    
    KickMessage: '&6You have been kicked! Reason: &2'
    
    # Message to be sent to the player who has been kicked. This message is followed by the kick reason
    
    ShowKickMessage: True
    
    # Set this to True if you want the kicked player to be able to see the kick reason.

This plugin is licensed under [CC Attribution-ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US). 

In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.
