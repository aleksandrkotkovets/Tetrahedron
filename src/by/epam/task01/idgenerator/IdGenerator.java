package by.epam.task01.idgenerator;

public class IdGenerator {
    private static long id = 431;

    public static long nextId() { return ++id; }
}
