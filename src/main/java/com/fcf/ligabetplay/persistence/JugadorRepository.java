package com.fcf.ligabetplay.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.fcf.ligabetplay.models.Jugador;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JugadorRepository implements Repository<Jugador> {
    private static final String FILE_PATH = "jugadores.json";
    //private static final String FILE_PATH = "src/main/java/com/fcf/ligabetplay/data/jugadores.json";
  
    private Gson gson;
    private List<Jugador> jugadores;


    public JugadorRepository() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.jugadores = load();
    }

    @Override
    public Jugador findById(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;  // Retornar null si no se encuentra el jugador
    }

    @Override
    public List<Jugador> findAll() {
        return new ArrayList<>(jugadores);
    }

    @Override
    public void save(Jugador jugador) {
        jugador.setId(generateId());  // Asigna un ID único
        jugadores.add(jugador);
        saveToJsonFile();
    }

    @Override
    public void update(Jugador jugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId() == jugador.getId()) {
                jugadores.set(i, jugador);
                saveToJsonFile();
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        jugadores.removeIf(jugador -> jugador.getId() == id);
        saveToJsonFile();
    }


    private List<Jugador> load() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Jugador>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();  // Si el archivo no existe, retornar una lista vacía
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveToJsonFile() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(jugadores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int generateId() {
        if (jugadores.isEmpty()) {
            return 1;
        } else {
            return jugadores.get(jugadores.size() - 1).getId() + 1;
        }
    }
}