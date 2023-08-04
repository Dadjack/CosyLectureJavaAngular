    package com.projet.library.controllers;

    import com.projet.library.entities.AuthorEntity;
    import com.projet.library.entities.CategoryEntity;
    import com.projet.library.entities.NationalityEntity;
    import com.projet.library.repositories.AuthorRepository;
    import com.projet.library.repositories.CategoryRepository;
    import com.projet.library.repositories.NationalityRepository;
    import net.datafaker.Faker;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;

    import java.util.Locale;

    @Controller
    public class DataController {

        Faker faker = new Faker(new Locale("fr"));

        public final AuthorRepository authorRepository;
        public final CategoryRepository categoryRepository;
        public final NationalityRepository nationalityRepository;


        @Autowired
        public DataController(
         AuthorRepository authorRepository,
          CategoryRepository categoryRepository,
          NationalityRepository nationalityRepository) {
            this.categoryRepository = categoryRepository;
            this.authorRepository = authorRepository;
            this.nationalityRepository = nationalityRepository;
        }
        public String[] categories = {"Roman", "Science-fiction", "Policier", "BD", "Manga", "Jeunesse", "Cuisine", "Art", "Histoire", "Biographie", "Santé", "Voyage", "Sport", "Loisir", "Nature", "Religion", "Droit", "Economie", "Politique", "Sciences", "Informatique", "Dictionnaire", "Encyclopédie", "Littérature", "Poésie", "Théâtre", "Essai", "Autre"};
        @GetMapping("/")
        public String createData() {
            // Creation of categories
            for (int i = 0; i < categories.length; i++) {
                CategoryEntity category = new CategoryEntity();
                category.setLabel(categories[i]);
                category.setDefinition(faker.lorem().sentence());
                categoryRepository.save(category);
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
                authorRepository.save(author);
            }
            return "redirect:/";
        }

            /*
               @GetMapping("/")
        public String createCategory() {
            for (int i = 0; i < categories.length; i++) {
                CategoryEntity category = new CategoryEntity();
                category.setLabel(categories[i]);
                category.setDefinition(faker.lorem().sentence());
                categoryRepository.save(category);
            }
            return "redirect:/";
        }

            @GetMapping("/")
        public String createCountries() {
            String[] countries = {"France", "Allemagne", "Angleterre", "Espagne", "Italie", "Portugal", "Belgique", "Suisse", "Autriche", "Pays-Bas", "Luxembourg", "Danemark", "Suède", "Norvège", "Finlande", "Grèce", "Turquie", "Russie", "Pologne", "République Tchèque", "Slovaquie", "Hongrie", "Roumanie", "Bulgarie", "Croatie", "Serbie", "Bosnie-Herzégovine", "Monténégro", "Albanie", "Macédoine", "Ukraine", "Biélorussie", "Estonie", "Lettonie", "Lituanie", "Moldavie", "Slovénie", "Chypre", "Malte", "Islande", "Irlande", "Ecosse", "Pays de Galles", "Irlande du Nord", "Etats-Unis", "Canada", "Mexique", "Brésil", "Argentine", "Chili", "Colombie", "Venezuela", "Uruguay", "Paraguay", "Bolivie", "Pérou", "Equateur", "Afrique du Sud", "Egypte", "Maroc", "Algérie", "Tunisie", "Libye", "Sénégal", "Côte d'Ivoire", "Nigeria", "Kenya", "Ethiopie", "Tanzanie", "Ouganda", "Soudan", "Soudan du Sud", "Cameroun", "Angola", "Mozambique", "Madagascar", "Zimbabwe", "Zambie", "Namibie", "Botswana", "Mali", "Burkina Faso", "Niger", "Tchad", "République Centrafricaine", "Congo", "Gabon", "Congo RDC", "Guinée", "Guinée-Bissau", "Guinée Equatoriale", "Togo", "Benin", "Burundi", "Rwanda", "Somalie", "Erythrée", "Djibouti", "Comores", "Mauritanie", "Maurice", "Seychelles", "Bahamas", "Cuba", "Haïti", "République Dominicaine", "Jamaïque", "Trinité-et-Tobago", "Barbade", "Costa Rica", "Panama", "Nicaragua", "Honduras", "El Salvador", "Guatemala", "Belize", "Guyana", "Suriname", "Guyane", "Pérou", "Bolivie", "Equateur", "Venezuela", "Colombie", "Paraguay", "Uruguay", "Argentine", "Brésil", "Chili", "Mexique", "Etats-Unis", "Canada", "Groenland", "Islande", "Norvège", "Suède", "Finlande", "Russie", "Estonie", "Lettonie", "Lituanie", "Pologne", "Allemagne", "Danemark", "Pays-Bas", "Belgique", "Luxembourg", "Royaume-Uni", "Irlande", "France", "Espagne", "Portugal", "Suisse", "Autriche", "Italie", "Slovénie", "Croatie", "Bosnie-Herzégovine", "Serbie", "Monténégro", "Albanie", "Macédoine", "Grèce", "Bulgarie", "Roumanie", "Hongrie", "Slovaquie", "République Tchèque", "Ukraine", "Biélorussie", "Moldavie", "Turquie", "Chypre", "Malte", "Andorre", "Liechtenstein", "Monaco", "Vatican", "Saint-Marin", "Australie", "Nouvelle-Zélande", "Papouasie-Nouvelle-Guinée", "Fidji", "Salomon", "Vanuatu", "Micronésie", "Kiribati", "Samoa", "Tonga", "Tuvalu", "Nauru", "Iles Marshall", "Palau", "Indonésie", "Philippines", "Malaisie"};
       for (int i = 0; i < countries.length; i++) {
           NationalityEntity country = new NationalityEntity();
           country.setName(countries[i]);
           nationalityRepository.save(country);
       }
        return "redirect:/";
        }

            @GetMapping("/")
    public String createAuthor() {
            for (int i = 0; i < 50; i++) {
                AuthorEntity author = new AuthorEntity();
                author.setFirstName(faker.name().firstName());
                author.setLastName(faker.name().lastName());
                author.setBiography(faker.lorem().sentence());
                author.setNationality(faker.address().country());
                author.setBirthDate(faker.date().birthday());
                author.setDeathDate(faker.date().birthday());
                authorRepository.save(author);
            }
            return "redirect:/";
        }
             */
    }
