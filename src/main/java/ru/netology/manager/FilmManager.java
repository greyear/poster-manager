package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private int length = 10;
    private FilmRepository repo;

    public FilmManager(FilmRepository repo) {
        this.repo = repo;
    }
    public FilmManager(FilmRepository repo, int length) {
        this.repo = repo;
        this.length = length;
    }

    public void save(Film film) {
        repo.save(film);
    }

    public Film[] findAll() {
        return repo.findAll();
    }

    public Film[] findLast() {
        int resultLength = length;
        Film[] films = repo.findAll();
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
