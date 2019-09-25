package by.epam.task01.model.repository;

import by.epam.task01.model.entity.Tetrahedron;

import java.util.Comparator;
import java.util.List;

public interface TetraRepository {
    void addTetrahedron(Tetrahedron tetrahedron);

    void removeTetrahedron(Tetrahedron tetrahedron);

    Tetrahedron getTetrahedron(int index);

    List<Tetrahedron> sortTetrahedron(Comparator<Tetrahedron> comparator);

    List<Tetrahedron> query(TetraSpecification specification);

    List<Tetrahedron> getAllTetrahedrons();

}
