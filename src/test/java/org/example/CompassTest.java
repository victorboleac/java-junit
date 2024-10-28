package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    @Test
    @DisplayName("Testing All points with assertAll for Left direction")
    void compassFourPointsRotatingLeft(){
        // Arrange
        Compass northCompass = new Compass();
        Compass westCompass = new Compass();
        Compass southCompass = new Compass();
        Compass eastCompass = new Compass();
        // Act
        northCompass.rotate(Compass.Point.NORTH, Compass.Direction.LEFT);
        westCompass.rotate(Compass.Point.WEST, Compass.Direction.LEFT);
        southCompass.rotate(Compass.Point.SOUTH, Compass.Direction.LEFT);
        eastCompass.rotate(Compass.Point.EAST, Compass.Direction.LEFT);
        // Assert
        assertAll(
                () -> assertEquals(Compass.Point.WEST, northCompass.point),
                () -> assertEquals(Compass.Point.NORTH, eastCompass.point),
                () -> assertEquals(Compass.Point.EAST, southCompass.point),
                () -> assertEquals(Compass.Point.SOUTH, westCompass.point)
        );
    }
    @Test
    @DisplayName("Testing if reverseString is working")
    void testReverseString(){
        //Arrange
        String sampleString = "Sample text for testing purposes.";
        StringManipulator manipulator = new StringManipulator();
        //Act
        String sampleStringReversed = manipulator.reverseString(sampleString);
        // Assert
        assertEquals(".sesoprup gnitset rof txet elpmaS", sampleStringReversed);
    }
    @Test
    @DisplayName("Testing if a string is palindrome")
    void testIfItIsPalindrome(){
        //Arrange
        String noPalindrome = "Sample text for testing purposes.";
        String palindrome = "racecar";
        StringManipulator manipulator = new StringManipulator();
        //Act
        boolean checkNoPalindrome = manipulator.isPalindrome(noPalindrome);
        boolean checkPalindrome = manipulator.isPalindrome(palindrome);
        // Assert
        assertFalse(checkNoPalindrome);
        assertTrue(checkPalindrome);
    }

    @Test
    @DisplayName("Testing findLongestWords method from WordAnalyser class")
    void checkTheLongestWords(){
        // Arrange
        var analyser = new WordAnalyser();
        String input = "This is a fairly boring sentence.";
        String secondInput = "This is a fairly boring thing";
        String[] expectedOne = new String[]{"sentence"};
        String[] expectedTwo = new String[]{"fairly", "boring"};
        // Act
        String [] longestWordsInput = analyser.findLongestWords(input);
        String [] longestWordsForSecondInput = analyser.findLongestWords(secondInput);
        // Assert
        assertEquals(Arrays.toString(expectedOne), Arrays.toString(longestWordsInput));
        assertEquals(Arrays.toString(expectedTwo), Arrays.toString(longestWordsForSecondInput));

    }
    @Test
    @DisplayName("Checks how calculateFrequency method works")
    void testCalculateLetterFrequency_withTwoLetters(){
        //Arrange
        String input = "This is a fairly boring thing.";
        WordAnalyser wordAnalyser = new WordAnalyser();
        //Act
        Integer lCounter = wordAnalyser.calculateLetterFrequency(input).get('l');
        Integer zCounter = wordAnalyser.calculateLetterFrequency(input).get('z');
        if(zCounter==null){
            zCounter = 0;
        }
        // Assert
        assertEquals(1,lCounter);
        assertEquals(0, zCounter);
    }

    @Test
    @DisplayName("Checks how addItem works")
    void testCheckAddItem_withAddingTwoNewItems(){
        // Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        // Act
        shoppingCart.addItem("Bread", 1.12);
        // Assert
        assertEquals(1.12, shoppingCart.getItems().get("Bread"));
        // Act
        shoppingCart.addItem("Milk", 2.12);
        // Assert
        assertEquals(2, shoppingCart.getItems().size());
    }
    @Test
    @DisplayName("Checks how totalPrice works")
    void testCheckTotalPrice_withAddingTwoNewItems(){
        // Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        // Act
        shoppingCart.addItem("Bread", 1.12);
        shoppingCart.addItem("Milk", 2.12);
        shoppingCart.totalPrice();
        Double result = shoppingCart.getTotalPrice();
        // Assert
        assertEquals(3.24, result);
    }
    @Test
    @DisplayName("Checks how applyDiscount works")
    void testApplyDiscount_withAddingTwoNewItems(){
        // Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        // Act
        shoppingCart.addItem("Bread", 1.12);
        shoppingCart.addItem("Milk", 2.12);
        shoppingCart.totalPrice();
        Double result = shoppingCart.getTotalPrice();
        shoppingCart.applyDiscount(0.1);
        Double resultWithTenPercentsDiscount = shoppingCart.getTotalPrice();
        // Assert

        assertEquals(3.24, result);
        assertEquals(2.916, Math.round(resultWithTenPercentsDiscount*1000.0)/1000.0);

    }
    @Test
    @DisplayName("Checks how totalPrice works")
    void testCheckTotalPrice_withAddingItemWithNegativePrice(){
        // Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        // Act
        shoppingCart.addItem("Bread", -1.12);
        shoppingCart.addItem("Milk", 2.12);
        shoppingCart.totalPrice();
        Double result = shoppingCart.getTotalPrice();
        // Assert
        assertEquals(2.12, result);
    }
}