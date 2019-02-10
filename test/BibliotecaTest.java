import com.twu.biblioteca.Library;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {

    public Library library = new Library();

    @Test
    public void shouldReturnWelcomeMessage(){
        String message = library.returnWelcomeMessage();
        assertThat(message, is("Welcome to Biblioteca. Your one-stop-shop " +
                "for great book titles in Bangalore!\n"));
    }

    @Test
    public void shouldReturnListOfBooks(){
        List<String> actualListOfBooks = library.returnListOfBooks();
        List<String> expectedListOfBooks = new LinkedList<String>(Arrays.asList("Pride and Prejudice",
                "A Tale of Two Cities", "Frankenstein"));
        assertThat(actualListOfBooks, is(expectedListOfBooks));
    }

    @Test
    public void shouldReturnListOfBooksWithAuthorsAndDates(){
        List<String> actualListOfBooksAuthorsDates = library.returnListOfBooksAuthorsDates();
        List<String> expectedListOfBooksAuthorsDates = new LinkedList<String>(Arrays.asList(
                "Pride and Prejudice | Jane Austen | 1813", "A Tale of Two Cities | Charles Dickens | 1859",
                "Frankenstein | Mary Wollstonecraft Shelley | 1818"));
        assertThat(actualListOfBooksAuthorsDates, is(expectedListOfBooksAuthorsDates));
    }

    @Test
    public void shouldCheckoutBook(){
        List<String> actualListOfBooks = library.returnListOfBooksAuthorsDates();
        library.checkoutBook("Pride and Prejudice");
        List<String> expectedListOfBooksAfterCheckout = new LinkedList<String>(Arrays.asList(
                "A Tale of Two Cities | Charles Dickens | 1859",
                "Frankenstein | Mary Wollstonecraft Shelley | 1818"));
        assertThat(actualListOfBooks, is(expectedListOfBooksAfterCheckout));
    }

    @Test
    public void shouldCheckinBook(){
        library.returnAvailableBooks().clear();
        library.returnAvailableBooks().add(2);
        library.returnAvailableBooks().add(3);

        library.returnCheckedoutBooks().clear();
        library.returnCheckedoutBooks().add(1);

        library.updateBooks();
        List<String> actualListOfBooks = library.returnListOfBooksAuthorsDates();
        library.checkinBook("Pride and Prejudice");
        List<String> expectedListOfBooksAfterCheckin = new LinkedList<String>(Arrays.asList(
                "Pride and Prejudice | Jane Austen | 1813", "A Tale of Two Cities | Charles Dickens | 1859",
                "Frankenstein | Mary Wollstonecraft Shelley | 1818"));
        assertThat(actualListOfBooks, is(expectedListOfBooksAfterCheckin));
    }

    @Test
    public void shouldReturnMovies(){
        List<String> actualListOfMovies = library.returnListOfMovies();
        List<String> expectedListOfMovies = new LinkedList<String>(Arrays.asList("Invictus | 2009 | Clint Eastwood | 7",
                "The Dark Knight | 2008 | Christopher Nolan | 9", "Bumblebee | 2018 | Travis Knight | 7"));
        assertThat(actualListOfMovies, is(expectedListOfMovies));
    }

    @Test
    public void shouldCheckoutMovie(){
        List<String> actualListOfMovies = library.returnListOfMovies();
        library.checkoutMovie("Invictus");
        List<String> expectedListOfMovies = new LinkedList<String>(Arrays.asList(
                "The Dark Knight | 2008 | Christopher Nolan | 9", "Bumblebee | 2018 | Travis Knight | 7"));
        assertThat(actualListOfMovies, is(expectedListOfMovies));
    }

    @Test
    public void shouldCheckinMovies(){
        library.returnAvailableMovies().clear();
        library.returnAvailableMovies().add(2);
        library.returnAvailableMovies().add(3);

        library.returnCheckedoutMovies().clear();
        library.returnCheckedoutMovies().add(1);

        library.updateMovies();
        List<String> actualListOfMovies = library.returnListOfMovies();
        library.checkinMovie("Invictus");
        List<String> expectedListOfMoviesAfterCheckin = new LinkedList<String>(Arrays.asList(
                "Invictus | 2009 | Clint Eastwood | 7", "The Dark Knight | 2008 | Christopher Nolan | 9",
                "Bumblebee | 2018 | Travis Knight | 7"));
        assertThat(actualListOfMovies, is(expectedListOfMoviesAfterCheckin));
    }

}
