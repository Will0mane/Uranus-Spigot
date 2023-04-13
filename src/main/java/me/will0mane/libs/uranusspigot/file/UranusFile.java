package me.will0mane.libs.uranusspigot.file;

import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.FileUtil;

import java.io.File;

@SuppressWarnings("unused")
public class UranusFile {

    private File file;
    private FileConfiguration configuration;

    @SneakyThrows
    public UranusFile(File f){
        if(!f.exists()){
            f.createNewFile();
        }

        this.file = f;
        load();
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }

    public UranusFile load(){
        this.configuration = YamlConfiguration.loadConfiguration(file);
        return this;
    }

    public UranusFile setFile(File file) {
        this.file = file;
        load();
        return this;
    }

    public UranusFile copyTo(File destination){
        FileUtil.copy(file, destination);
        return this;
    }

    public UranusFile copyFrom(File source){
        FileUtil.copy(source, file);
        load();
        return this;
    }

    public File getFile() {
        return file;
    }
}
