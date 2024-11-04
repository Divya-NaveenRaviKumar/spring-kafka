package org.pilot.springkafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }


    @MutationMapping
    public Book createBook(@Argument String id, @Argument String name, @Argument int pageCount, @Argument String authorId) {
        logger.info("Creating book with id: {}, name: {}, pageCount: {}, authorId: {}", id, name, pageCount, authorId);
        try {
            Book newBook = new Book(id, name, pageCount, authorId);
            Book.addBook(newBook);
            logger.info("Book created successfully: {}", newBook);
            return newBook;
        } catch (Exception e) {
            logger.error("Error creating book", e);
            throw e;
        }
    }
}
