package org.jacek;

import org.tenzo.dev.entity.Movie;
import org.tenzo.dev.entity.dao.MovieDAO;
import org.tenzo.dev.util.HibernateUtil;

import java.sql.Date;

public class MovieApp {

    public static void main(String[] args) {
        MovieDAO movieDAO = new MovieDAO();
        Movie matrix = new Movie();
        matrix.setTitle("Matrix");
        matrix.setDuration(120);
        matrix.setYear(Date.valueOf("1990-01-01"));
        matrix.setDirector("Wachowsky Brothers");

        Integer movieID = movieDAO.addMovie(matrix);

        Movie dbMovie = movieDAO.getMovie(movieID);
        System.out.println(dbMovie);

        movieDAO.deleteMove(dbMovie);

        HibernateUtil.getSessionFactory().close();
    }
}
