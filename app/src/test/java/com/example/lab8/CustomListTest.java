package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return list
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * test empty list, should return false
     * increase the list by adding a new city
     * test list with city, should return true
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * increase the list by adding a new city
     * get the size of the list
     * decrease size by removing city
     * check if our current size matches the initial size minus
     one
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        int listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.getCount(),listSize -1);
    }

    /**
     * check if our current size is 0
     * increase the list by adding  2 a new city
     * check if our current size is 2
     */
    @Test
    public void countCityTest() {
        list = MockCityList();
        assertEquals(list.countCities(), 0);
        City city = new City("Estevan", "SK");
        City city2 = new City("St.Albert", "AB");
        list.addCity(city);
        list.addCity(city2);
        assertEquals(list.countCities(), 2);
    }

}
