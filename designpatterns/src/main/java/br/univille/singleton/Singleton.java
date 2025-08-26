package br.univille.singleton;

public class Singleton {
    // varivel global
    private static Singleton instance;

    private Singleton() {
        // construtor privado
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
