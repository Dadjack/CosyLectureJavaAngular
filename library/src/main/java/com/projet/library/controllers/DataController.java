package com.projet.library.controllers;

import com.projet.library.entities.*;
import com.projet.library.repositories.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

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

    String[] roles = { "ADMIN", "USER" };

    String[] categories = { "Roman", "Science-fiction", "Policier", "BD", "Manga", "Jeunesse", "Cuisine", "Art",
            "Histoire", "Biographie", "Santé", "Voyage", "Sport", "Loisir", "Nature", "Religion", "Droit", "Economie",
            "Politique", "Sciences", "Informatique", "Dictionnaire", "Encyclopédie", "Littérature", "Poésie", "Théâtre",
            "Essai", "Autre" };

    String[] countries = { "France", "Allemagne", "Angleterre", "Espagne", "Italie", "Portugal", "Belgique", "Suisse",
            "Autriche", "Pays-Bas", "Luxembourg", "Danemark", "Suède", "Norvège", "Finlande", "Grèce", "Turquie",
            "Russie", "Pologne", "République Tchèque", "Slovaquie", "Hongrie", "Roumanie", "Bulgarie", "Croatie",
            "Serbie", "Bosnie-Herzégovine", "Monténégro", "Albanie", "Macédoine", "Ukraine", "Biélorussie", "Estonie",
            "Lettonie", "Lituanie", "Moldavie", "Slovénie", "Chypre", "Malte", "Islande", "Irlande", "Ecosse",
            "Pays de Galles", "Irlande du Nord", "Etats-Unis", "Canada", "Mexique", "Brésil", "Argentine", "Chili",
            "Colombie", "Venezuela", "Uruguay", "Paraguay", "Bolivie", "Pérou", "Equateur", "Afrique du Sud", "Egypte",
            "Maroc", "Algérie", "Tunisie", "Libye", "Sénégal", "Côte d'Ivoire", "Nigeria", "Kenya", "Ethiopie",
            "Tanzanie", "Ouganda", "Soudan", "Soudan du Sud", "Cameroun", "Angola", "Mozambique", "Madagascar",
            "Zimbabwe", "Zambie", "Namibie", "Botswana", "Mali", "Burkina Faso", "Niger", "Tchad",
            "République Centrafricaine", "Congo", "Gabon", "Congo RDC", "Guinée", "Guinée-Bissau", "Guinée Equatoriale",
            "Togo", "Benin", "Burundi", "Rwanda", "Somalie", "Erythrée", "Djibouti", "Comores", "Mauritanie", "Maurice",
            "Seychelles", "Bahamas", "Cuba", "Haïti", "République Dominicaine", "Jamaïque", "Trinité-et-Tobago",
            "Barbade", "Costa Rica", "Panama", "Nicaragua", "Honduras", "El Salvador", "Guatemala", "Belize", "Guyana",
            "Suriname", "Guyane", "Pérou", "Bolivie", "Equateur", "Venezuela", "Colombie", "Paraguay", "Uruguay",
            "Argentine", "Brésil", "Chili", "Mexique", "Etats-Unis", "Canada", "Groenland", "Islande", "Norvège",
            "Suède", "Finlande", "Russie", "Estonie", "Lettonie", "Lituanie", "Pologne", "Allemagne", "Danemark",
            "Pays-Bas", "Belgique", "Luxembourg", "Royaume-Uni", "Irlande", "France", "Espagne", "Portugal", "Suisse",
            "Autriche", "Italie", "Slovénie", "Croatie", "Bosnie-Herzégovine", "Serbie", "Monténégro", "Albanie",
            "Macédoine", "Grèce", "Bulgarie", "Roumanie", "Hongrie", "Slovaquie", "République Tchèque", "Ukraine",
            "Biélorussie", "Moldavie", "Turquie", "Chypre", "Malte", "Andorre", "Liechtenstein", "Monaco", "Vatican",
            "Saint-Marin", "Australie", "Nouvelle-Zélande", "Papouasie-Nouvelle-Guinée", "Fidji", "Salomon", "Vanuatu",
            "Micronésie", "Kiribati", "Samoa", "Tonga", "Tuvalu", "Nauru", "Iles Marshall", "Palau", "Indonésie",
            "Philippines", "Malaisie" };

    @GetMapping("/dataset")
    public String createData(Model model) {

         // Creation of nationalities
        for (int j = 0; j < countries.length; j++) {
            NationalityEntity country = new NationalityEntity();
            country.setName(countries[j]);
            nationalityRepository.save(country);
        }
        model.addAttribute("nationalities", nationalityRepository.findAll());

        // Creation of roles
        for (int i = 0; i < roles.length; i++) {
            RoleEntity role = new RoleEntity();
            role.setName(roles[i]);
            roleRepository.save(role);
        }
        model.addAttribute("roles", roleRepository.findAll());

        // Creation of categories
        for (int i = 0; i < categories.length; i++) {
            CategoryEntity category = new CategoryEntity();
            category.setLabel(categories[i]);
            category.setDefinition(faker.lorem().sentence());
            categoryRepository.save(category);
        }
        model.addAttribute("categories", categoryRepository.findAll());

        // Creation of users
        for (int u = 0; u < 100; u++) {
            LibraryUserEntity user = new LibraryUserEntity();
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setPhoneNumber(faker.phoneNumber().cellPhone());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setAddress(faker.address().fullAddress());
            user.setBirthday(faker.date().birthday().toLocalDateTime());
            user.setRole(roleRepository.findById(2).get());
            userRepository.save(user);
        }
        model.addAttribute("users", userRepository.findAll());       

        // Creation of authors
        for (int k = 0; k < 50; k++) {
            AuthorEntity author = new AuthorEntity();
            author.setFirstname(faker.name().firstName());
            author.setLastname(faker.name().lastName());
            author.setBio(faker.lorem().sentence());
            author.setBirthday(faker.date().birthday().toLocalDateTime());
            author.setDeathday(faker.date().birthday().toLocalDateTime());
            authorRepository.save(author);
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
            book.setPublicationYear(String.valueOf(faker.number().numberBetween(1900, 2019)));
            Iterable<AuthorEntity> authors = authorRepository.findAll();
            for (AuthorEntity author : authors) {
                book.setAuthor(author);
            }
            book.setCategory(categoryRepository.findById(faker.number().numberBetween(1, categories.length)).get());
            bookRepository.save(book);
        }
        model.addAttribute("books", bookRepository.findAll());

        // Creation of borrows
        for (int n = 0; n < 100; n++) {
            BorrowEntity borrow = new BorrowEntity();
            borrow.setUser(userRepository.findById(faker.number().numberBetween(1, 100)).get());
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
