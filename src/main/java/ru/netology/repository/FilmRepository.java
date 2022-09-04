package ru.netology.repository;

import ru.netology.domain.Film;

public class FilmRepository {
    private Film[] films = new Film[0];

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

    public Film findById(int id) {
        for (Film film:films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Film[] tmp = new Film[films.length - 1];
        int i = 0;
        for (Film film:films) {
            if (film.getId() != id) {
                tmp[i] = film;
                i++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new Film[0];
    }
}
