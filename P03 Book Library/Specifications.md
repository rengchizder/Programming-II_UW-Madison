# P03 Library Book Management System
## Objective
Develop a library book management system in Java to manage a collection of books, including checking out and returning books.

## Book Class
Implement a `Book` class to represent individual books. Each book should have attributes for title, author, and ISBN.
```{java}
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isCheckedOut;

    // Constructor, getters, setters, and other methods
}
```

## Library Class
Implement a `Library` class to manage the collection of books and handle operations such as adding, removing, checking out, and returning books.
```{java}
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        // Implementation to add a book
    }

    public void removeBook(String isbn) {
        // Implementation to remove a book by ISBN
    }

    public Book checkoutBook(String isbn) {
        // Implementation to checkout a book by ISBN
    }

    public void returnBook(String isbn) {
        // Implementation to return a book by ISBN
    }

    public List<Book> searchBooksByTitle(String title) {
        // Implementation to search books by title
    }

    public List<Book> searchBooksByAuthor(String author) {
        // Implementation to search books by author
    }

    public void displayBookDetails(String isbn) {
        // Implementation to display details of a book by ISBN
    }
}
```

## Functional Requirements
Implement the following methods in the Library class:
- Add Book
    - Add a new book to the library's collection.
- Remove Book
    - Remove a book from the library's collection based on its ISBN.
- Checkout Book
    - Checkout a book from the library's collection based on its ISBN.
- Return Book
    - Return a book to the library's collection based on its ISBN.
- Search Books by Title
    - Search for books in the library's collection by title.
- Search Books by Author
    - Search for books in the library's collection by author.
- Display Book Details
    - Display the details of a book based on its ISBN.

## Testing and Validation
Implement test-driven development (TDD) to ensure code reliability and maintainability. Write unit tests for each method to verify its functionality and handle edge cases.

### testBookConstructorGetters()
testBookConstructorGetters() method checks whether the constructor of Book class initializes correctly the new Book instance fields: title, author, borrowerCardBarCode, ID, and increments nextID static field. In particular, make sure that the different identifiers (ID fields) of at least two created books are set correctly and that the book is initially available. It checks also checks whether all implemented getter methods defined within Book class work correctly.

### testBookReturnBook()
testBookReturnBook() checks whether returnBook() method defined within Book class sets correctly the instance field borrowerCardBarCode. A Book must be available after this instance method is called.

For more information, refer to the [original assignment page](https://web.archive.org/web/20190212055306/http://cs300-www.cs.wisc.edu/wp/2019/01/29/p03-library-book/).