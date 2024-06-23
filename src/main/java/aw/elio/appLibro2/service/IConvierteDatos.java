package aw.elio.appLibro2.service;

public interface IConvierteDatos {
    <T> T jsonToObject(String json, Class<T> clase);
}
