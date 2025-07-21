class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

class Library {
    String name;
    List<Book> books;

    Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
}
