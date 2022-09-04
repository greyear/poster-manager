package ru.netology.manager;

import ru.netology.domain.Film;

public class FilmManager {
    private Film[] films = new Film[0];
    private int length = 10;

    public FilmManager() {

    }
    public FilmManager(int length) {
        this.length = length;
    }

    public void save(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        tmp[length - 1] = film;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength = length;
        if (films.length < length) {
            resultLength = films.length;
        }
        Film[] tmp = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            tmp[i] = films[films.length - i - 1];
        }
        return tmp;
    }
}
