    package com.projet.library.controllers;

    import com.projet.library.entities.*;
    import com.projet.library.repositories.*;
//    import com.projet.library.repositories.CategoryRepository;
//    import com.projet.library.repositories.LibraryUserRepository;
//    import com.projet.library.repositories.NationalityRepository;
//    import com.projet.library.repositories.RoleRepository;
    import net.datafaker.Faker;
    //import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;

    import java.util.Locale;

    @Controller
    public class DataController {

        Faker faker = new Faker(new Locale("fr"));

        public final AuthorRepository authorRepository;
        public final BookRepository bookRepository;
        public final CategoryRepository categoryRepository;
        public final LibrayUserRepository userRepository;
        public final NationalityRepository nationalityRepository;
        public final RoleRepository roleRepository;


        public DataController(
                AuthorRepository authorRepository,
                BookRepository bookRepository,
                CategoryRepository categoryRepository,
                LibrayUserRepository userRepository,
                NationalityRepository nationalityRepository,
                RoleRepository roleRepository
        ) {
            this.authorRepository = authorRepository;
            this.bookRepository = bookRepository;
            this.categoryRepository = categoryRepository;
            this.userRepository = userRepository;
            this.nationalityRepository = nationalityRepository;
            this.roleRepository = roleRepository;
        }
        public String[] categories = {"Roman", "Science-fiction", "Policier", "BD", "Manga", "Jeunesse", "Cuisine", "Art", "Histoire", "Biographie", "Santé", "Voyage", "Sport", "Loisir", "Nature", "Religion", "Droit", "Economie", "Politique", "Sciences", "Informatique", "Dictionnaire", "Encyclopédie", "Littérature", "Poésie", "Théâtre", "Essai", "Autre"};
        @GetMapping("/")
        public String createData() {

            // Creation of roles
            ERole[] roles = {ERole.ADMIN, ERole.USER};
            for (int i = 0; i < roles.length; i++) {
                RoleEntity role = new RoleEntity();
                role.setName(roles[i]);
                roleRepository.save(role);
            }

            // Creation of categories
            for (int i = 0; i < categories.length; i++) {
                CategoryEntity category = new CategoryEntity();
                category.setLabel(categories[i]);
                category.setDefinition(faker.lorem().sentence());
                categoryRepository.save(category);
                    }

            // Creation of users
            for (int u =0; u < 100; u++) {
                LibraryUserEntity user = new LibraryUserEntity();
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());
                // TO DO : correction
                user.setPhoneNumber(3892 +u);
                //user.setPhoneNumber(Integer.valueOf(faker.phoneNumber().cellPhone()));
                user.setEmail(faker.internet().emailAddress());
                user.setPassword(faker.internet().password());
                //user.setAddress(faker.address().fullAddress());
                user.setBirthday(faker.date().birthday().toLocalDateTime());
                user.setRole(roleRepository.findById(2).get());
                userRepository.save(user);
            }


            // Creation of nationalities
                String[] countries = {"France", "Allemagne", "Angleterre", "Espagne", "Italie", "Portugal", "Belgique", "Suisse", "Autriche", "Pays-Bas", "Luxembourg", "Danemark", "Suède", "Norvège", "Finlande", "Grèce", "Turquie", "Russie", "Pologne", "République Tchèque", "Slovaquie", "Hongrie", "Roumanie", "Bulgarie", "Croatie", "Serbie", "Bosnie-Herzégovine", "Monténégro", "Albanie", "Macédoine", "Ukraine", "Biélorussie", "Estonie", "Lettonie", "Lituanie", "Moldavie", "Slovénie", "Chypre", "Malte", "Islande", "Irlande", "Ecosse", "Pays de Galles", "Irlande du Nord", "Etats-Unis", "Canada", "Mexique", "Brésil", "Argentine", "Chili", "Colombie", "Venezuela", "Uruguay", "Paraguay", "Bolivie", "Pérou", "Equateur", "Afrique du Sud", "Egypte", "Maroc", "Algérie", "Tunisie", "Libye", "Sénégal", "Côte d'Ivoire", "Nigeria", "Kenya", "Ethiopie", "Tanzanie", "Ouganda", "Soudan", "Soudan du Sud", "Cameroun", "Angola", "Mozambique", "Madagascar", "Zimbabwe", "Zambie", "Namibie", "Botswana", "Mali", "Burkina Faso", "Niger", "Tchad", "République Centrafricaine", "Congo", "Gabon", "Congo RDC", "Guinée", "Guinée-Bissau", "Guinée Equatoriale", "Togo", "Benin", "Burundi", "Rwanda", "Somalie", "Erythrée", "Djibouti", "Comores", "Mauritanie", "Maurice", "Seychelles", "Bahamas", "Cuba", "Haïti", "République Dominicaine", "Jamaïque", "Trinité-et-Tobago", "Barbade", "Costa Rica", "Panama", "Nicaragua", "Honduras", "El Salvador", "Guatemala", "Belize", "Guyana", "Suriname", "Guyane", "Pérou", "Bolivie", "Equateur", "Venezuela", "Colombie", "Paraguay", "Uruguay", "Argentine", "Brésil", "Chili", "Mexique", "Etats-Unis", "Canada", "Groenland", "Islande", "Norvège", "Suède", "Finlande", "Russie", "Estonie", "Lettonie", "Lituanie", "Pologne", "Allemagne", "Danemark", "Pays-Bas", "Belgique", "Luxembourg", "Royaume-Uni", "Irlande", "France", "Espagne", "Portugal", "Suisse", "Autriche", "Italie", "Slovénie", "Croatie", "Bosnie-Herzégovine", "Serbie", "Monténégro", "Albanie", "Macédoine", "Grèce", "Bulgarie", "Roumanie", "Hongrie", "Slovaquie", "République Tchèque", "Ukraine", "Biélorussie", "Moldavie", "Turquie", "Chypre", "Malte", "Andorre", "Liechtenstein", "Monaco", "Vatican", "Saint-Marin", "Australie", "Nouvelle-Zélande", "Papouasie-Nouvelle-Guinée", "Fidji", "Salomon", "Vanuatu", "Micronésie", "Kiribati", "Samoa", "Tonga", "Tuvalu", "Nauru", "Iles Marshall", "Palau", "Indonésie", "Philippines", "Malaisie"};
                for (int j = 0; j < countries.length; j++) {
                    NationalityEntity country = new NationalityEntity();
                    country.setName(countries[j]);
                    nationalityRepository.save(country);
            }

            // Creation of authors
            for (int k = 0; k < 50; k++) {
                AuthorEntity author = new AuthorEntity();
                author.setFirstname(faker.name().firstName());
                author.setLastname(faker.name().lastName());
                author.setBio(faker.lorem().sentence());
                author.setBirthday(faker.date().birthday().toLocalDateTime());
                author.setDeathday(faker.date().birthday().toLocalDateTime());
                //TODO : correction
                //author.setNationalityCollection(NationalityEntity.randomNationalities(nationalityRepository));
                authorRepository.save(author);

                // Creation of books
                for (int l = 0; l < 100; l++) {
                    BookEntity book = new BookEntity();
                    book.setTitle(faker.book().title());
                    book.setSummary(faker.lorem().paragraph());
                    book.setQuantity(faker.number().numberBetween(1, 10));
                    book.setEditor(faker.book().publisher());
                    book.setAvailable(true);
                    book.setCreatedAt(faker.date().birthday().toLocalDateTime());
                    book.setPublicationYear(String.valueOf(faker.number().numberBetween(1900, 2019)));
                    book.setAuthor(author);
                    book.setCategory(categoryRepository.findById(1).get());
                    bookRepository.save(book);
                }
            }
            return "redirect:/";
        }

    }
