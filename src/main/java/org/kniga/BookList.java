package org.kniga;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {
    private final List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Книга успешно добавлена.");
    }

    public void searchBookList(String title){
        int count = 0;
        if (books.isEmpty()) {
            System.out.println("Список книг: (пусто)");
        } else {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getTitle().contains(title)){
                    System.out.println("Книга " + (i + 1) + ":");
                    System.out.println(books.get(i));
                } else {
                    count++;
                }

            }
            if (books.size() == count) {
                System.out.println("Не удалось найти книгу по названию");
            }
        }

    }

    public void viewBookList() {
        if (books.isEmpty()) {
            System.out.println("Список книг: (пусто)");
        } else {
            System.out.println("Список книг:\n");
            for (int i = 0; i < books.size(); i++) {
                System.out.println("Книга " + (i + 1) + ":");
                System.out.println(books.get(i));
            }
        }
    }

    public void deleteBook(int index) {
        if (books.isEmpty()) {
            System.out.println("Список книг пустой, нечего удалять.");
            return;
        }

        if (index >= 1 && index <= books.size()) {
            System.out.println("Книга" + " '" +books.get(index - 1).getTitle() + "' " +  "успешно удалена.");
            books.remove(index - 1);
        } else {
            System.out.println("Неверный номер книги.");
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Добро пожаловать в приложение \"Учет книг в библиотеке\"!");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Просмотреть список книг");
            System.out.println("3. Найти книгу по названию");
            System.out.println("4. Удалить книгу");
            System.out.println("5. Выйти");


            int choice = 0;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Не выбрано числовое ззначение :"
                        + scanner.next());
            }
            System.out.println();

            scanner.nextLine();  // Очистка буфера после считывания числа.

            switch (choice) {
                case 1:
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    bookList.addBook(title, author);
                    break;
                case 2:
                    bookList.viewBookList();
                    break;
                case 3:
                    System.out.println("Введите название книги для поиска:");
                    String bookTitle = scanner.nextLine().toLowerCase();
                    bookList.searchBookList(bookTitle);
                    break;
                case 4:
                    System.out.print("Введите номер книги для удаления: ");
                    int index = scanner.nextInt();
                    bookList.deleteBook(index);
                    break;
                case 5:
                    System.out.print("До свидания!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, повторите.");
            }
        }
    }
}