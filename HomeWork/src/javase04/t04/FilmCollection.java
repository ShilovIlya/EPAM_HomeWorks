package javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;


public class FilmCollection implements Serializable {

    private ArrayList<Film> films = new ArrayList<>();

    public void addFilm(String filmName, String[] actors) {
        films.add(new Film(filmName));
        for (String actor : actors){
            films.get(films.size() - 1).addActor(actor);
        }
    }

    public boolean removeFilm(String filmName) {
        int index = 0;
        for (Film film : films) {
            if (film.getFilmName().equals(filmName)) {
                films.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    public void printFilms() {
        for (Film film : films) {
            film.printFilm();
        }
    }

    public class Film implements Serializable {

        private String filmName;

        private ArrayList<String> actors = new ArrayList<>();

        public Film(String name){
            filmName = name;
        }

        public void addActor(String actorName) {
            actors.add(actorName);
        }

        public void printFilm() {
            System.out.println("Film name - " + filmName);
            System.out.println("Actors: ");
            for (int i = 0; i < actors.size(); i++) {
                System.out.println(actors.get(i));
            }
            System.out.println();
        }

        public String getFilmName() {
            return filmName;
        }
    }

}
