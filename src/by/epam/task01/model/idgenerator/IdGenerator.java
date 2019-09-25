package by.epam.task01.model.idgenerator;

public class IdGenerator {
    private static long id = 431;

    public static long nextId() { return ++id; }
}
