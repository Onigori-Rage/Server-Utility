package com.onigori.api.confighelper;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Config {

	private FileConfiguration config;

	private File file;

	private String name;

	private String section;

	private final JavaPlugin plugin;

	public Config(String name, String section, JavaPlugin plugin) {
		this.name = name;

		this.section = section;

		this.file = new File(plugin.getDataFolder(), this.name);

		this.plugin = plugin;
	}

	public String getSection() {
		return this.section;
	}

	public void reloadConfig() {
		this.config = YamlConfiguration.loadConfiguration(this.file);
		InputStream inputStream = this.plugin.getResource(this.name);

		if (inputStream != null) {
			this.config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
		}
	}

	public FileConfiguration getConfig() {
		if (this.config == null) {
			this.reloadConfig();
		}

		return this.config;
	}

	public void saveConfig() {
		if (this.config != null) {
			try {
				this.getConfig().save(this.file);
			}

			catch (Exception exception) {
				this.plugin.getLogger().severe("Cannot save the configuration.");
			}
		}
	}

	public void set(String path, Object data) {
		this.getConfig().set(this.getSection() + "." + path, data);

		this.saveConfig();
	}

	public Object get(String path) {
		return this.getConfig().get(this.getSection() + "." + path);
	}

	public Object get(String path, Object defaultObject) {
		Object result = this.get(path);

		if (result == null) {
			result = defaultObject;
		}

		return result;
	}

	public ConfigurationSection getConfigSection(String path) {
		return this.getConfig().getConfigurationSection(this.getSection() + path);
	}

	public byte[] serializeObject(Serializable serializable) {
		byte[] bytes = null;

		try {
			final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(serializable);

			bytes = byteArrayOutputStream.toByteArray();

			byteArrayOutputStream.close();
			objectOutputStream.close();
		}

		catch (Exception exception) {
			this.plugin.getLogger().severe("Cannot serialize the object.");
		}

		return bytes;
	}

	public Serializable deserializeObject(byte[] bytes) {
		Serializable serializable = null;

		try {
			final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

			final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

			serializable = (Serializable) objectInputStream.readObject();

			byteArrayInputStream.close();
			objectInputStream.close();
		}

		catch (Exception exception) {
			this.plugin.getLogger().severe("Cannot deserialize the object.");
		}

		return serializable;
	}

	public Serializable deserializeObject(byte[] bytes, Serializable defaultObject) {
		Serializable serializable = this.deserializeObject(bytes);

		if (serializable == null) {
			serializable = defaultObject;
		}

		return serializable;
	}

}
