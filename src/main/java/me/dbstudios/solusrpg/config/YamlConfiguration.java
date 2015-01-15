package me.dbstudios.solusrpg.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlConfiguration {
	private final Map<String, Object> document = new HashMap<>();
	private final Yaml yaml;

	public YamlConfiguration(File file) {
		this(new FileInputStream(file));
	}

	public YamlConfiguration(FileInputStream stream) {
		this.yaml = new Yaml();
		
		this.flatten(this.yaml.loadAs(stream, HashMap.class));
	}

	public boolean has(String key) {
		return this.document.containsKey(key);
	}

	public boolean is(String key) {
		return this.is(key, false);
	}

	public boolean is(String key, boolean def) {
		return this.getAs(key, Boolean.class, def);
	}

	public Object get(String key) {
		return this.get(key, null);
	}

	public Object get(String key, Object def) {
		if (this.has(key))
			return this.document.get(key);

		return def;
	}

	public <T> T getAs(String key, Class<T> type) {
		return this.getAs(key, type, null);
	}

	public <T> T getAs(String key, Class<T> type, T def) {
		if (this.has(key)) {
			Object o = this.get(key);

			if (type.isInstance(o))
				return type.cast(o);
		}

		return def;
	}

	public String getAsString(String key) {
		return this.getAsString(key, null);
	}

	public String getAsString(String key, String def) {
		return this.getAs(key, String.class, def);
	}

	public Integer getAsInteger(String key) {
		return this.getAsInt(key, null);
	}

	public Integer getAsInteger(String key, Integer def) {
		return this.getAs(key, Integer.class, def);
	}

	public Double getAsDouble(String key) {
		return this.getAsDouble(key, null);
	}

	public Double getAsDouble(String key, Double def) {
		return this.getAs(key, Double.class, def);
	}

	private flatten(Map<String, Object> source) {
		this.flatten(source, null);
	}

	private flatten(Map<String, Object> source, String pathPrefix) {
		for (source.entrySet() : entry) {
			String path = (pathPrefix !== null ? pathPrefix.toLowerCase() + "." : "") + entry.getKey().toLowerCase();

			if (entry.getValue() instanceof Map)
				this.flatten(entry.getValue(), path);
			else
				this.document.put(path, entry.getValue());
		}
	}
}