# 2.3 JPA with MongoDB
Create a Spring Boot Application that connects with MongoDB.

### Codigo de honor:
Debes seguir el Código de honor del ingeniero de sistemas para defender el estándar de integridad académica de la ECI:

* Tus respuestas a tareas, cuestionarios y exámenes deben ser tu propio trabajo (excepto para las tareas que permiten explícitamente la colaboración).

* No puedes compartir tus soluciones de tareas, cuestionarios o exámenes con otra persona a menos que el instructor lo permita explícitamente. Esto incluye cualquier cosa escrita por ti, como también cualquier solución oficial proporcionada por el docente o el monitor del curso.

* No puedes participar en otras actividades que mejorarán de manera deshonesta tus resultados o que mejorarán de manera deshonesta o dañarán los resultados de otras personas.

## Prerrequisitos

### Git

```
> git --version

git version 2.21.0.windows.1
```

## Instalación

Para descargar localmente el repositorio se utiliza el comando como sigue:
```
git clone https://github.com/Diego23p/IETI_9.git
```

## Part 1: Basic Mongo DB configuration and Spring Boot Integration

- How many customers were created in the database?

5

- Where is the *findAll* method implemented?

Como ```CustomerRepository``` extiende ```MongoRepository```, ```MongoRepository``` es el que implementa este método

- Suppose you have more than 1000 products in your database. How would you implement a method for supporting pagination and return pages of 50 products to your frontend?

Como el método ```findByDescriptionContaining``` tiene como segundo argumento un objeto ```Pageable```, este permite definir los límites en la cantidad de objetos buscados, se definiría un método que hiciera esta búsqueda y que tuviese el límite inferior como argumento de entada (definido en la lógica de frontEnd) y al límite superior se le añadiría 50.

- How many products contain the "plus" word in their description?

4

- How many products are returned by the *findByDescriptionContaining* query? Why?

2, porque se está restringiendo la cantidad de filas retornadas con el método ```of(0, 2```) de ```PageRequest```

- Which are the collection names where the objects are stored? Where are those names assigned?

customer y product, se define en el primer parámetro del repositorio que es extendido.

#### Método findByResponsible en Todo que soporta paginación

- Líneas añadidas:

```
todoRepository.save(new Todo("travel to Galapagos",10,"Jan 10 - 1860","charles@natural.com","pending"));
todoRepository.save(new Todo("travel to Malvinas",4,"Jul 20 - 1864","charles@natural.com","pending"));
todoRepository.save(new Todo("go to Galapagos",7,"Agu 14 - 1865","christobal@natural.com","pending"));
todoRepository.save(new Todo("go to Malvinas",9,"Dec 25 - 1866","charles@natural.com","pending"));
todoRepository.save(new Todo("travel to Bermudas",3,"May 30 - 1868","charles@natural.com","pending"));
```

Usando el método ```findByResponsible``` por ```charles@natural.com``` con una paginación de 0 a 3

![](/img/1.jpg)

En MongoDB Atlas:

![](/img/1.jpg)
