package model.creator;

import by.epam.task01.creator.Creator;
import by.epam.task01.entity.Point;
import by.epam.task01.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreatorTest {

    @Test
    public void testCreateTetrahedrons() {

        Creator creator = Creator.getInstance();
        List<Tetrahedron> actual = creator.createListOfTetrahedronsFromFile("resource/shortData");
        List<Long> IDs = new ArrayList<>();
        for (Tetrahedron tetra : actual) {
            IDs.add(tetra.getId());
        }

        List<Tetrahedron> expected = new ArrayList<>();
        Tetrahedron tetrahedronOne = new Tetrahedron(IDs.get(0),
                new Point().newBuilder().x(0.577).y(0).z(1.634).build(),
                new Point().newBuilder().x(0).y(-1).z(0).build(),
                new Point().newBuilder().x(1.732).y(0).z(0).build(),
                new Point().newBuilder().x(0).y(1).z(0).build());
        expected.add(tetrahedronOne);

        Tetrahedron tetrahedronTwo = new Tetrahedron(IDs.get(1),
                new Point().newBuilder().x(0.577).y(0).z(1.634).build(),
                new Point().newBuilder().x(0).y(-1).z(0).build(),
                new Point().newBuilder().x(1.732).y(0).z(0).build(),
                new Point().newBuilder().x(0).y(1).z(0).build());
        expected.add(tetrahedronTwo);

        Assert.assertEquals(expected, actual);
    }

}
