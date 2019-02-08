import com.twu.biblioteca.Library;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {

    private Library library = new Library();

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
        List<String> expectedListOfBooksAuthorsDates = Arrays.asList("Pride and Prejudice | Jane Austen | 1813",
                "A Tale of Two Cities | Charles Dickens | 1859", "Frankenstein | Mary Wollstonecraft Shelley | 1818");
        assertThat(actualListOfBooksAuthorsDates, is(expectedListOfBooksAuthorsDates));
    }

}
