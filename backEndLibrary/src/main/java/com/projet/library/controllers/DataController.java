package com.projet.library.controllers;

import com.projet.library.datacreation.DataTables;
import com.projet.library.entities.*;
import com.projet.library.repositories.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

@Controller
public class DataController {

    Faker faker = new Faker(new Locale("fr"));

    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;
    public final BorrowRepository borrowRepository;
    public final CategoryRepository categoryRepository;
    public final LibraryUserRepository userRepository;
    public final NationalityRepository nationalityRepository;
    public final PictureRepository pictureRepository;
    public final RoleRepository roleRepository;

    @Autowired
    public DataController(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            BorrowRepository borrowRepository,
            CategoryRepository categoryRepository,
            LibraryUserRepository userRepository,
            NationalityRepository nationalityRepository,
            PictureRepository pictureRepository,
            RoleRepository roleRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.nationalityRepository = nationalityRepository;
        this.pictureRepository = pictureRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/dataset")
    public String createData(Model model) {
        // Creation of countries
        for (int co = 0; co < DataTables.countries.length; co++) {
            NationalityEntity country = new NationalityEntity();
            country.setName(DataTables.countries[co]);
            nationalityRepository.save(country);
        }
        model.addAttribute("countries", nationalityRepository.findAll());

        // Creation of roles
        for (int r = 0; r < DataTables.roles.length; r++) {
            RoleEntity role = new RoleEntity();
            role.setName(DataTables.roles[r]);
            roleRepository.save(role);
        }
        model.addAttribute("roles", roleRepository.findAll());

        // Creation of categories
        for (int ca = 0; ca < DataTables.categories.length; ca++) {
            CategoryEntity category = new CategoryEntity();
            category.setLabel(DataTables.categories[ca]);
            category.setDefinition(faker.lorem().sentence());
            categoryRepository.save(category);
        }
        model.addAttribute("categories", categoryRepository.findAll());

        // Creation of admins
        for (int a = 0; a < DataTables.firstnames.length; a++) {
            LibraryUserEntity admin = new LibraryUserEntity();
            admin.setFirstName(DataTables.firstnames[a]);
            admin.setLastName(DataTables.lastnames[a]);
            admin.setPhoneNumber(faker.phoneNumber().cellPhone());
            admin.setEmail(admin.getFirstName().toLowerCase() + "." + admin.getLastName().toLowerCase()
                    + "@library-les-loubards.fr");
            admin.setPassword(faker.internet().password());
            admin.setAddress(faker.address().fullAddress());
            admin.setBirthday(faker.date().birthday().toLocalDateTime());
            admin.setRole(roleRepository.findById(1).get());
            userRepository.save(admin);
            PictureEntity picture = new PictureEntity();
            picture.setUrl(faker.internet().image());
            picture.setName(admin.getFirstName() + "_" + admin.getLastName());
            picture.setDescription("Photo de " + admin.getFirstName() + " " + admin.getLastName());
            picture.setUser(admin);
            pictureRepository.save(picture);
        }

        // Creation of users
        for (int u = 0; u < 100; u++) {
            LibraryUserEntity user = new LibraryUserEntity();
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setPhoneNumber(faker.phoneNumber().cellPhone());
            user.setEmail(user.getFirstName().toLowerCase() + "." + user.getLastName().toLowerCase() + "@gmail.com");
            user.setPassword(faker.internet().password());
            user.setAddress(faker.address().fullAddress());
            user.setBirthday(faker.date().birthday().toLocalDateTime());
            user.setRole(roleRepository.findById(2).get());
            userRepository.save(user);
            PictureEntity picture = new PictureEntity();
            picture.setUrl(faker.internet().image());
            picture.setName(user.getFirstName() + "_" + user.getLastName());
            picture.setDescription("Photo de " + user.getFirstName() + " " + user.getLastName());
            picture.setUser(user);
            pictureRepository.save(picture);
        }
        model.addAttribute("users", userRepository.findAll());

        // Creation of authors
        for (int k = 0; k < 50; k++) {
            AuthorEntity author = new AuthorEntity();
            author.setFirstname(faker.name().firstName());
            author.setLastname(faker.name().lastName());
            author.setBio(faker.lorem().sentence());
            author.setBirthday(faker.date().past(36500, TimeUnit.DAYS).toLocalDateTime());
            author.setDeathday(faker.date().birthday().toLocalDateTime());
            authorRepository.save(author);
            int randomAP = faker.number().numberBetween(1, 5);
            for (int j = 0; j < randomAP; j++) {
                PictureEntity picture = new PictureEntity();
                picture.setUrl(faker.internet().image());
                picture.setName(author.getFirstname() + "_" + author.getLastname() + "_" + j);
                picture.setDescription("Photo de " + author.getFirstname() + " " + author.getLastname() + " " + j);
                picture.setAuthor(author);
                pictureRepository.save(picture);
            }
            int randomAN = faker.number().numberBetween(1, 3);
            for (int an = 0; an < randomAN; an++) {
                author.setNationalityCollection(nationalityRepository.findAllById(Collections.singleton(faker.number().numberBetween(1, DataTables.countries.length))));
            }
        }
        model.addAttribute("authors", authorRepository.findAll());

        // Creation of books
        for (int b = 0; b < 100; b++) {
            BookEntity book = new BookEntity();
            book.setTitle(faker.book().title());
            book.setSummary(faker.lorem().paragraph());
            book.setQuantity(faker.number().numberBetween(1, 10));
            book.setEditor(faker.book().publisher());
            book.setAvailable(true);
            book.setVersion("Français");
            book.setCreatedAt(faker.date().birthday().toLocalDateTime());
            book.setPublicationYear(String.valueOf(faker.number().numberBetween(1250, 2019)));
            book.setAuthor(authorRepository.findById(faker.number().numberBetween(1, 50)).get());
            book.setCategory(
                    categoryRepository.findById(faker.number().numberBetween(1, DataTables.categories.length)).get());
            bookRepository.save(book);
            int randomBP = faker.number().numberBetween(1, 5);
            for (int j = 0; j < randomBP; j++) {
                PictureEntity picture = new PictureEntity();
                picture.setUrl(faker.internet().image());
                picture.setName(book.getTitle());
                picture.setDescription("Photo du livre : " + book.getTitle());
                picture.setBook(book);
                pictureRepository.save(picture);
            }

        }
        model.addAttribute("books", bookRepository.findAll());

        Iterable<BookEntity> books = bookRepository.findAll();
        Iterable<AuthorEntity> authors = authorRepository.findAll();

        Iterator<AuthorEntity> authorIterator = authors.iterator();

        for (BookEntity book : books) {
            if (authorIterator.hasNext()) {
                AuthorEntity author = authorIterator.next();
                book.setAuthor(author);
                bookRepository.save(book); 
            }
        }

        // Creation of borrows
        for (int n = 0; n < 100; n++) {
            BorrowEntity borrow = new BorrowEntity();
            borrow.setUser(userRepository.findById(faker.number().numberBetween(4, 104)).get());
            borrow.setBook(bookRepository.findById(faker.number().numberBetween(1, 100)).get());
            borrow.setStartDate(faker.date().past(10, TimeUnit.DAYS).toLocalDateTime());
            borrow.setEndDate(faker.date().future(1, TimeUnit.DAYS).toLocalDateTime());
            borrow.setPenalty(Float.valueOf(faker.number().numberBetween(0, 10)));
            borrowRepository.save(borrow);
        }
        model.addAttribute("borrows", borrowRepository.findAll());

        return "redirect:data";
    }

}
