package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {

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
    public void saveAndFindAllTest() {
        FilmRepository repo = new FilmRepository();
        repo.save(testFilms[0]);
        repo.save(testFilms[1]);

        Film[] actual = repo.findAll();
        Film[] expected = {testFilms[0], testFilms[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdSuccessTest() {
        FilmRepository repo = new FilmRepository();
        for (Film testFilm : testFilms) {
            repo.save(testFilm);
        }
        Film actual = repo.findById(10);
        Film expected = testFilms[9];
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdNullTest() {
        FilmRepository repo = new FilmRepository();
        for (Film testFilm : testFilms) {
            repo.save(testFilm);
        }
        Film actual = repo.findById(13);
        assertNull(actual);
    }

    @Test
    public void removeByIdTest() {
        FilmRepository repo = new FilmRepository();
        for (Film testFilm : testFilms) {
            repo.save(testFilm);
        }
        repo.removeById(10);
        Film[] actual = repo.findAll();
        Film[] expected = {testFilms[0], testFilms[1], testFilms[2],
                           testFilms[3], testFilms[4], testFilms[5],
                           testFilms[6], testFilms[7], testFilms[8],
                           testFilms[10], testFilms[11]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAllTest() {
        FilmRepository repo = new FilmRepository();
        for (Film testFilm : testFilms) {
            repo.save(testFilm);
        }
        repo.removeAll();
        Film[] actual = repo.findAll();
        Film[] expected = {};
        assertArrayEquals(expected, actual);
    }
}