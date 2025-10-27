# Spring Framework Documentation (Without Spring Boot)

---

## 🌱 SPRING CORE — Inversion de Contrôle & Injection de Dépendances

### Qu’est-ce que Spring Core et à quoi sert-il ?

Spring Core est le module central du framework Spring. Il fournit le conteneur **IoC (Inversion of Control)** permettant de gérer les objets (beans), leur cycle de vie et leurs dépendances.

### Qu’est-ce que le principe d’Inversion de Contrôle (IoC) ?

Le contrôle de la création et de la gestion des objets est inversé : c’est le conteneur Spring qui gère les instances.

### Différence entre IoC et DI ?

* **IoC** : concept général de délégation du contrôle.
* **DI (Dependency Injection)** : mécanisme concret pour réaliser l’IoC.

### Qu’est-ce qu’un bean dans Spring ?

Un **bean** est un objet géré par le conteneur Spring, déclaré via XML, JavaConfig ou détection automatique.

### Rôle du conteneur IoC

Créer, configurer, injecter les dépendances, et gérer le cycle de vie des beans.

### Différence entre ApplicationContext et BeanFactory

* **BeanFactory** : conteneur de base.
* **ApplicationContext** : superset ajoutant la gestion d’événements, internationalisation, AOP, etc.

### Trois approches de configuration

1. XML
2. Annotations (`@Component`, `@Autowired`, etc.)
3. Java Config (`@Configuration`, `@Bean`)

### Annotations importantes

* `@Configuration` : définit une classe de configuration.
* `@ComponentScan` : active la détection des composants.
* `@Bean` : définit un bean manuellement.
* `@Component`, `@Service`, `@Repository`, `@Controller` : stéréotypes.
* `@Autowired`, `@Qualifier` : injection automatique et sélective.

### Détection automatique des composants

Spring scanne les packages définis dans `@ComponentScan` et instancie les classes annotées.

### Cycle de vie d’un bean

1. Instanciation
2. Injection des dépendances
3. Initialisation (`@PostConstruct`)
4. Utilisation
5. Destruction (`@PreDestroy`)

### Scopes des beans

* **singleton** (par défaut)
* **prototype**
* **request**, **session**, **application** (Web)

### Pourquoi comprendre la configuration manuelle ?

Pour savoir comment Spring fonctionne sans automatisation de Spring Boot.

---

## 🗃️ SPRING DATA JPA — Persistance & Transactions

### Qu’est-ce que Spring Data JPA ?

Module facilitant l’accès aux bases de données via JPA, supprimant la nécessité d’implémenter manuellement les DAO.

### Différence entre JPA et Hibernate

* **JPA** : spécification (API standard).
* **Hibernate** : implémentation de JPA.

### Qu’est-ce qu’une entité JPA ?

Classe Java mappée sur une table via `@Entity` et `@Table`.

### Rôle du DataSource

Fournit la connexion physique à la base de données.

### Rôle de l’EntityManager

Gère les opérations CRUD sur les entités et le contexte de persistance.

### Rôle du TransactionManager

Coordonne les transactions (commit/rollback).

### @EnableJpaRepositories

Active la détection et la création automatique des repositories JPA.

### Repository Spring Data

Interface qui étend `JpaRepository` pour accéder aux données sans implémentation explicite.

### Méthodes génériques JpaRepository

`save()`, `findById()`, `findAll()`, `deleteById()`, `count()`.

### Gestion des transactions

`@Transactional` sur méthodes ou classes.

* **Propagation** : `REQUIRED`, `REQUIRES_NEW`, etc.
* **Rollback** : automatique sur exception non contrôlée.

### Connexion manuelle avant Spring Boot

Déclaration manuelle de `DataSource`, `EntityManagerFactory`, `TransactionManager`.

### Configuration de persistance typique

Inclut :

* `DataSource`
* `LocalContainerEntityManagerFactoryBean`
* `JpaTransactionManager`
* `@EnableJpaRepositories`

### Validation de contrainte

Annotations JSR-303 : `@NotNull`, `@Size`, `@Email`, etc.

### Suppression logique vs physique

* **Physique** : suppression réelle.
* **Logique** : flag `deleted=true`, conserve l’historique.

---

## 🌐 SPRING MVC — Contrôleurs & Couche Web

### MVC (Model-View-Controller)

Sépare la logique métier (Model), la présentation (View), et le contrôle (Controller).

### Rôle du DispatcherServlet

Cœur de Spring MVC : reçoit les requêtes HTTP, délègue aux contrôleurs, et renvoie la réponse.

### Différence entre Controller et RestController

* **@Controller** : renvoie une vue.
* **@RestController** : renvoie directement une réponse JSON/XML.

### Annotations Web importantes

* `@RequestMapping` : mapping d’URL.
* `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` : spécifiques aux méthodes HTTP.
* `@Valid` : active la validation.
* `@RequestBody` : lie le corps JSON.
* `@PathVariable` : extrait un paramètre d’URL.

### Cycle de traitement d’une requête

1. Requête → `DispatcherServlet`
2. Mapping vers le bon `Controller`
3. Appel du service
4. Retour d’un `ModelAndView` ou JSON
5. Rendu de la vue / réponse

### WebConfig

Classe `@Configuration` + `@EnableWebMvc`, configure vues, CORS, interceptors.

### Initialisation manuelle du DispatcherServlet

Avant Spring Boot : déclaration manuelle dans `web.xml` ou via `WebAppInitializer`.

### WebAppInitializer

Implémente `WebApplicationInitializer`. Remplace `web.xml`, enregistre le `DispatcherServlet`.

### Traitement d’une requête REST

1. HTTP Request
2. `DispatcherServlet`
3. `RestController`
4. Service/Repository
5. JSON Response

### Sérialisation JSON

Assurée automatiquement par **Jackson**.

### @RestControllerAdvice

Gère les exceptions et validations globalement.

### Bonnes pratiques d’organisation des packages

```
com.example.project
 ├── config
 ├── controller
 ├── service
 ├── repository
 ├── model
 └── exception
```

---

## ✅ Résumé

* **Spring Core** : gestion des beans et DI
* **Spring Data JPA** : persistance et transactions
* **Spring MVC** : couche web et contrôleurs

---

### 🔊 Prochaines étapes

* Ajouter des **exemples de code complets** (Core, Data, MVC).
* Générer une **configuration XML et JavaConfig** de référence.
* Créer un mini-projet d’exemple (sans Spring Boot).
