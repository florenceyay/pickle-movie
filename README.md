
# Pickle-Movie

Pickle-Movie is a distributed web application designed for discovering, rating, and collaboratively selecting movies. The platform combines AI-driven movie recommendations with a user-friendly interface, enabling real-time collaboration and personalized decision-making for movie enthusiasts.

---

## Features

- **AI-Powered Recommendations**: Get movie suggestions tailored to your taste using advanced recommendation algorithms.
- **Collaborative Movie Decision-Making**: Users can select, rate, and compare lists of movies, then collaboratively decide on the best options.
- **Real-Time Interactions**: Use WebSockets for live updates and synchronized actions between users.
- **Advanced Search Capabilities**: ElasticSearch ensures fast and accurate movie searches.
- **Scalable and Distributed Architecture**: Built with modern distributed systems principles for reliability and scalability.

---

## Tech Stack

- **Frontend**: [Angular](https://angular.io/)  
  A responsive, dynamic user interface for a seamless user experience.
  
- **Backend**: [Spring Boot](https://spring.io/projects/spring-boot)  
  A robust backend service written in Java, ensuring high performance and scalability.
  
- **Build Tool**: [Gradle](https://gradle.org/)  
  Used for efficient and flexible build management.
  
- **Database**: [MongoDB](https://www.mongodb.com/)  
  NoSQL database designed for storing and querying movie data efficiently.
  
- **Search Engine**: [ElasticSearch](https://www.elastic.co/elasticsearch/)  
  Provides fast and powerful search functionality across movie datasets.
  
- **Real-Time Features**: [WebSockets](https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API)  
  Enables real-time synchronization for collaborative features.
  
- **Future Explorations**: Incorporation of **Go** for specific distributed system components.

---

## Key Functionalities

1. **Movie Discovery**: Search for movies and get AI-generated suggestions.
2. **Rating and Voting**: Users rate movies and compare preferences.
3. **Collaborative Selection**: Two or more users can rate each other's lists to find a mutual favorite.
4. **Real-Time Updates**: Live updates for shared movie lists and interactions.

---

## Setup and Installation

1. **Frontend**:
   - Install [Node.js](https://nodejs.org/) and Angular CLI.
   - Clone the repository and navigate to the frontend directory.
   - Run `npm install` to install dependencies.
   - Start the server with `ng serve`.

2. **Backend**:
   - Ensure [Java](https://openjdk.org/) and Gradle are installed.
   - Clone the repository and navigate to the backend directory.
   - Run `./gradlew bootRun` to start the application.

3. **Database**:
   - Install and configure [MongoDB](https://www.mongodb.com/).
   - Set up the database schema for movies and user data.

4. **Search Engine**:
   - Install [ElasticSearch](https://www.elastic.co/elasticsearch/) and configure the indices for movie data.

---

## Future Enhancements

- Expand collaborative decision-making to allow more than two users.
- Introduce advanced analytics on movie preferences.
- Explore distributed implementation for database and search engine with **Go** microservices.
- Optimize scalability for larger user bases.

---

## Contribution

We welcome contributions! Feel free to fork the repository, submit issues, or create pull requests to improve the platform.

---
