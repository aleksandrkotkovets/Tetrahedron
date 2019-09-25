package by.epam.task01.model.entity;

import java.util.Objects;

/**
 * The class describes the entity point.
 *
 * @author Kotkovets Aleksandr Sergeevich
 * @version 1.0 11.09.2019
 * @since JDK1.0
 */

public class Point {

    private double x;
    private double y;
    private double z;

    public Point() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y &&
                z == point.z;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append('}');
        return sb.toString();
    }

    public Point(Builder builder) {
        x = builder.x;
        y = builder.y;
        z = builder.z;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private double x;
        private double y;
        private double z;


        private Builder() {
        }


        public Builder x(double val) {
            x = val;
            return this;
        }

        public Builder y(double val) {
            y = val;
            return this;
        }

        public Builder z(double val) {
            z = val;
            return this;
        }

        public Point build() {
            return new Point(this);
        }
    }

}
