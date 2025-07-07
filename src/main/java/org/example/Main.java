package org.example;
import org.example.domain.Book;
import org.example.domain.LibraryException;
import org.example.filter.AuthorFilter;
import org.example.filter.AvailableFilter;
import org.example.filter.YearFilter;
import org.example.repository.ArrayListBookRepository;
import org.example.repository.BookRepository;
import org.example.service.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookRepository repository = new ArrayListBookRepository();
        LoanManager loanManager = new LoanManager(repository);
        BookFilterService filterService = new BookFilterService(repository);
        LibraryReportGenerator reportGenerator = new LibraryReportGenerator(repository);

        while (true) {
            System.out.println("\nSISTEMA DE GESTIÓN DE BIBLIOTECA");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Listar todos los libros");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Filtrar por autor");
            System.out.println("7. Filtrar por año");
            System.out.println("8. Ver solo libros disponibles");
            System.out.println("9. Ver reporte completo");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1":
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Titulo: ");
                        String title = scanner.nextLine();
                        System.out.print("Autor: ");
                        String author = scanner.nextLine();
                        System.out.print("Año: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        repository.addBook(new Book(isbn, title, author, year));
                        System.out.println("Libro agregado.");
                        break;
                    case "2":
                        System.out.print("ISBN del libro a eliminar: ");
                        repository.removeBook(scanner.nextLine());
                        System.out.println("Libro eliminado.");
                        break;
                    case "3":
                        reportGenerator.printAllBooks();
                        break;
                    case "4":
                        System.out.print("ISBN del libro a prestar: ");
                        loanManager.lendBook(scanner.nextLine());
                        System.out.println("Libro prestado.");
                        break;
                    case "5":
                        System.out.print("ISBN del libro a devolver: ");
                        loanManager.returnBook(scanner.nextLine());
                        System.out.println("Libro devuelto.");
                        break;
                    case "6":
                        System.out.print("Autor: ");
                        String authorFilter = scanner.nextLine();
                        List<Book> booksByAuthor = filterService.filterBooks(new AuthorFilter(authorFilter));
                        booksByAuthor.forEach(System.out::println);
                        break;
                    case "7":
                        System.out.print("Año: ");
                        int yearFilter = Integer.parseInt(scanner.nextLine());
                        List<Book> booksByYear = filterService.filterBooks(new YearFilter(yearFilter));
                        booksByYear.forEach(System.out::println);
                        break;
                    case "8":
                        List<Book> avaiblesBooks = filterService.filterBooks(new AvailableFilter());
                        avaiblesBooks.forEach(System.out::println);
                        break;
                    case "9":
                        reportGenerator.printBooksGroupedByAuthor();
                        reportGenerator.printTotalCount();
                        break;
                    case "0":
                        System.out.println("Hasta luego!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (LibraryException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ingreso de opcion invalido.");
            }
        }
    }
}
