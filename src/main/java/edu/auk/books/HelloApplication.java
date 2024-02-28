package edu.auk.books;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane root = new BorderPane();

        // List views for books and related books
        ListView<Book> bookListView = new ListView<>();
        ListView<Book> relatedBooksView = new ListView<>();

        // Sample data (this would be replaced with your actual book data)
        Book book1 = new Book("Book 1");
        Book book2 = new Book("Book 2");
        book1.setRelatedBooks(List.of(new Book("Related to Book 1 - 1"), new Book("Related to Book 1 - 2")));
        book2.setRelatedBooks(List.of(new Book("Related to Book 2 - 1")));

        bookListView.getItems().addAll(book1, book2);

        // Event handler for selecting a book
        bookListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            relatedBooksView.getItems().clear();
            if (newValue != null) {
                relatedBooksView.getItems().addAll(newValue.getRelatedBooks());
            }
        });

        root.setLeft(bookListView);
        root.setCenter(relatedBooksView);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Book List Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
