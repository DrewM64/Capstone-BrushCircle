# Capstone-BrushCircle

[![LinkedIn][linkedin-shield]][linkedin-url-andrew]
[![LinkedIn][linkedin-shield]][linkedin-url-derrian]
[![LinkedIn][linkedin-shield]][linkedin-url-ulises]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="images/logo.png" alt="Logo" width="100" height="80">
  </a>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#external tools">External Tools</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![Product Name Screen Shot][product-screenshot]


### Built With

* [Spring](https://spring.io/projects/spring-boot)
* [H2 Database](https://www.h2database.com/html/main.html)
* [Maria DB](https://mariadb.org/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* java 8
  ```sh
  https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
  ```
* maven
  ```sh
  https://maven.apache.org/install.html
  ```
* npm
  ```sh
  npm install npm@latest -g
  ```

### Install Repository

1. Clone the repo
   ```sh
   git clone https://github.com/DrewM64/Capstone-BrushCircle.git
   ```
2. Install Maven packages
   ```sh
   Download sources and documentation
   mvn clean install
   ```
4. Install NPM packages
   ```sh
   npm install
   npm audit fix
   npm run build
   ``` 
   
### External Tools
The intent for this is to walkthrough the setup but the steps have been previously done so check in advance.

H2 provides a web-based console that can be used to explore a database and execute SQL
statements. 
1. To enable the console, we have to add the following lines to the
application. properties file. 
2. The first setting enables the H2 console and the second
setting defines the endpoint that we can use to access the console:
```sh
spring.h2.console.enabled=-true
spring.h2.console.path=/h2-console
```
3. You can access the H2 console by navigating to localhost: 8080/h2-console with the
web browser. 
4. Use jdbc:h2 : mem : artdb as the JDBC URL and leave the Password field
empty in the Login window. Press the Connect button to log in to the console.

Maria Database tables are created automatically by JPA. But, before we run our application, we have to create a database for it. The database can be created by using HeidiSQL. Open HeidiSQL, and follow these steps
1. Right-click your mouse inside the database list.
2. Then, select Create new | Database:
3. Let's name our database artdb. After you click OK, you should see the new
   artdb  database in the database list:
4. In the application, we add a MariaDB dependency to the pom. xm1 file and we could 
   remove the H2 dependency injection that we don't need anymore:
   ```sh
   <dependency>
   <groupId›org.mariadb.jdbc</groupId>
   <artifactId›mariadb-java-client</artifactId›
   </dependency>
   ```
5. In the application.properties file, you will now define the database
   connection. First, you will define the database's ur1, username, password, and
   database driver class. The spring. jpa. generate-ddl setting defines whether
   JPA should initialize the database (true/false).
   The spring.jpa.hibernate.ddl-auto setting defines the behavior of the
   database initialization. The possible values are none, validate, update,
   create, and create-drop. create-drop means that the database is created
   when an application starts and it is dropped when the application is stopped.
   create-drop is also the default value if you don't define any. The create value
   only creates the database when the application is started. The update value
   creates the database and updates the schema if it is changed:
   ```sh
   spring.datasource.url=jdbc:mariadb://localhost:3306/cardb
   spring.datasource.username=root
   spring.datasource.password=YOUR_PASSWORD
   spring.datasource.driver-class-name-org.mariadb.jdbc.Driver
   spring.jpa. generate-ddl=true
   spring.jpa.hibernate.ddl-auto=create-drop
   ```

After running the application, you should see the tables in MariaDB.
   
<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Andrew Montgomery - andrew.montgomery001@mymdc.net
Derrian Willson - leander316@gmail.com
Ulises Medina - umedina.tech@gmail.com

Project Link: [https://github.com/DrewM64/Capstone-BrushCircle](https://github.com/DrewM64/Capstone-BrushCircle)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url-ulises]: https://linkedin.com/in/uli-medina
[linkedin-url-andrew]: https://www.linkedin.com/in/andrew-montgomery-b90136218/
[linkedin-url-derrian]: https://www.linkedin.com/in/derrianwilson/
[product-screenshot]: images/screenshot.png
