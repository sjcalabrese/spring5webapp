package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRrepository publisherRrepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRrepository publisherRrepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRrepository = publisherRrepository;

    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drivern Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("j2ee Development without EJB", "39321323412");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher guruPublishing = new Publisher("guruPublishing", "123 mySteet", "nowhere", "virginia", "12321");

        publisherRrepository.save(guruPublishing);


        System.out.println("Sarted in Bootstrap");
        System.out.println("number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRrepository.count());
    }
}
