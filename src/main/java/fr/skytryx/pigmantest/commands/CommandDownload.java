package fr.skytryx.pigmantest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CommandDownload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        player.sendMessage("§c[Download] §bVotre demande est entrain d'être §6traiter§b! Restez patient");
        File wfolder = player.getWorld().getWorldFolder();
        try {
            FileOutputStream fos = new FileOutputStream(player.getWorld().getName()+".zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            FileInputStream fis = new FileInputStream(wfolder);
            ZipEntry zipEntry = new ZipEntry(wfolder.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();
        } catch(IOException e){
            player.sendMessage("§c[Download] §bIl y a eu une erreur...");
            return true;
        }
        return true;
    }
}
