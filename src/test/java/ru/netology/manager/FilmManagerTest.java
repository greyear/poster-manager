package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class FilmManagerTest {
    private FilmRepository repo = Mockito.mock(FilmRepository.class);
    private Film[] testFilms = {
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
    public void findLastIfLessAndDefined() {
        FilmManager manager = new FilmManager(repo,4);
        Film[] returned = {testFilms[0], testFilms[1], testFilms[2]};
        doReturn(returned).when(repo).findAll();
        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[2], testFilms[1], testFilms[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfMoreAndDefined() {
        FilmManager manager = new FilmManager(repo,11);
        Film[] returned = {testFilms[0], testFilms[1], testFilms[2],
                           testFilms[3], testFilms[4], testFilms[5],
                           testFilms[6], testFilms[7], testFilms[8],
                           testFilms[9], testFilms[10], testFilms[11]};
        doReturn(returned).when(repo).findAll();
        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[11], testFilms[10], testFilms[9],
                testFilms[8], testFilms[7], testFilms[6],
                testFilms[5], testFilms[4], testFilms[3],
                testFilms[2], testFilms[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfLessAndTen() {
        FilmManager manager = new FilmManager(repo);
        Film[] returned = {testFilms[0], testFilms[1], testFilms[2], testFilms[3]};
        doReturn(returned).when(repo).findAll();
        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[3], testFilms[2], testFilms[1], testFilms[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfMoreAndTen() {
        FilmManager manager = new FilmManager(repo);
        Film[] returned = {testFilms[0], testFilms[1], testFilms[2],
                testFilms[3], testFilms[4], testFilms[5],
                testFilms[6], testFilms[7], testFilms[8],
                testFilms[9], testFilms[10], testFilms[11]};
        doReturn(returned).when(repo).findAll();
        Film[] actual = manager.findLast();
        Film[] expected = {testFilms[11], testFilms[10], testFilms[9],
                testFilms[8], testFilms[7], testFilms[6],
                testFilms[5], testFilms[4], testFilms[3],
                testFilms[2]};
        assertArrayEquals(expected, actual);
    }
}