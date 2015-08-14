package com.vengea.modtool.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.vengea.modtool.Main;

public class ToggleMute implements CommandExecutor {
	public Main main;
	public ToggleMute(Main main){
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, 
			String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("modtool.mute")){
			if (main.mute == true){
				main.mute = false;
				p.sendMessage(ChatColor.RED + "The chat are now in Global mode.");
				return true;
			} else{
				main.mute = true;
				p.sendMessage(ChatColor.AQUA + "The chat are now in Premium mode.");
				return true;
			}
		}

		return false;
	}
	
	

}
