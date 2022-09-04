package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {
    Film[] testFilms = {
            new Film(1, "Home alone", 1990, "Columbus"),
            new Film(2, "Titanic", 1997, "Cameron"),
            new Film(3, "2001: A Space Odyssey", 1968, "Kubrick"),
            new Film(4, "The Godfather", 1972, "Coppola"),
            new Film(5, "North by Northwest", 1959, "Hitchcock"),
            new Film(6, "Mulholland Drive", 2001, "Lynch"),
            new Film(7, "The Dark Knight ", 2008, "Nolan"),
            new Film(8, "Pulp Fiction", 1994, "Tarantino"),
            new Film(9, "The Truman Show", 1998, "Weir"),
            new Film(10, "Psycho", 1960, "Hitchcock"),
            new Film(11, "Andrei Rublev", 1966, "Tarkovsky"),
            new Film(12, "Taxi Driver", 1976, "Scorsese")
    };

    @Test
    public void saveAndFindAll() {
        FilmManager manager = new FilmManager();
        manager.save(testFilms[0]);
        manager.save(testFilms[1]);

        Film[] actual = manager.findAll();
        Film[] expected = {testFilms[0], testFilms[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfLessAndDefined() {
        FilmManager manager = new FilmManager(4);
        manager.save(testFilms[0]);
        manager.save(testFilms[1]);
        manager.save(testFilms[2]);
        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[2], testFilms[1], testFilms[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfMoreAndDefined() {
        FilmManager manager = new FilmManager(11);
        for (Film testFilm : testFilms) {
            manager.save(testFilm);
        }
        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[11], testFilms[10], testFilms[9],
                testFilms[8], testFilms[7], testFilms[6],
                testFilms[5], testFilms[4], testFilms[3],
                testFilms[2], testFilms[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfLessAndTen() {
        FilmManager manager = new FilmManager();
        manager.save(testFilms[0]);
        manager.save(testFilms[1]);
        manager.save(testFilms[2]);
        manager.save(testFilms[3]);

        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[3], testFilms[2], testFilms[1], testFilms[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfMoreAndTen() {
        FilmManager manager = new FilmManager();
        for (Film testFilm : testFilms) {
            manager.save(testFilm);
        }
        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[11], testFilms[10], testFilms[9],
                testFilms[8], testFilms[7], testFilms[6],
                testFilms[5], testFilms[4], testFilms[3],
                testFilms[2]};
        assertArrayEquals(expected, actual);
    }
}