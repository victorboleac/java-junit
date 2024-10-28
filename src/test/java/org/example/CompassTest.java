package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @Test
    @DisplayName("Testing right direction for North point on Compass class")
    void compassFacingNorthCanRotateRight() {
        //Arrange
        Compass newCompass = new Compass();
        // Act
        newCompass.rotate(Compass.Point.NORTH, Compass.Direction.RIGHT);
        // Assert
        assertEquals(Compass.Point.EAST, newCompass.point);
    }
    @Test
    @DisplayName("Testing All points with assertAll for Right direction")
    void compassFourPointsRotatingRight(){
        // Arrange
        Compass northCompass = new Compass();
        Compass eastCompass = new Compass();
        Compass southCompass = new Compass();
        Compass westCompass = new Compass();
        // Act
        northCompass.rotate(Compass.Point.NORTH, Compass.Direction.RIGHT);
        eastCompass.rotate(Compass.Point.EAST, Compass.Direction.RIGHT);
        southCompass.rotate(Compass.Point.SOUTH, Compass.Direction.RIGHT);
        westCompass.rotate(Compass.Point.WEST, Compass.Direction.RIGHT);
        // Assert
        assertAll(
                () -> assertEquals(Compass.Point.EAST, northCompass.point),
                () -> assertEquals(Compass.Point.SOUTH, eastCompass.point),
                () -> assertEquals(Compass.Point.WEST, southCompass.point),
                () -> assertEquals(Compass.Point.NORTH, westCompass.point)
        );
    }
}