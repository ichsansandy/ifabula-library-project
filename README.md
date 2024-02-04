<a name="readme-top"></a>

<div align="center">

  <h1><b>Ifabula Library</b></h1>

</div>

<!-- TABLE OF CONTENTS -->

## 📗 Table of Contents

- [📖 Ifabula Library ](#-ifabula-library-)
  - [🛠 Built With ](#-built-with-)
    - [Tech Stack ](#tech-stack-)
    - [Key Features ](#key-features-)
  - [💻 Getting Started ](#-getting-started-)
    - [Prerequisites](#prerequisites)
    - [Setup](#setup)
  - [👥 Author ](#-author-)
  - [🔭 Future Features ](#-future-features-)
  - [🤝 Contributing ](#-contributing-)
  - [⭐️ Show your support ](#️-show-your-support-)
  - [📝 License ](#-license-)

<!-- PROJECT DESCRIPTION -->

# 📖 Ifabula Library <a name="about-project"></a>

**Ifabula Library** is an app for library management

## 🛠 Built With <a name="built-with"></a>

### Tech Stack <a name="tech-stack"></a>

<details>
  <summary>Server</summary>
    <li><a href="https://www.ruby-lang.org/en/">Java</a></li>
    <li><a href="https://rubyonrails.org/">Springboot</a></li>
</details>
<details>
  <summary>Database</summary>
    <li><a href="https://www.postgresql.org/">Postgres</a></li>
</details>

<!-- Features -->

### Key Features <a name="key-features"></a>

- **Built using Java Springboot**

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- GETTING STARTED -->

## 💻 Getting Started <a name="getting-started"></a>

To get a local copy up and running, follow these steps.

### Prerequisites

In order to run this project you need:

```
    java >= 11
    postgres >- 15.3
```

### Setup

Clone this repository to your desired folder:

```bash
  git clone https://github.com/ichsansandy/ifabula-library-project.git
```

You need to setup database for these project

```
  ifabula_library
 
```

or you can use your own database and change the ```src/main/resources/application.properties```

```yml
  spring.datasource.url=jdbc:postgresql://localhost:5432/[your_database]
  spring.datasource.username=[your_username]
  spring.datasource.password=[your_password]
```

if you use intelij idea it don't forget to set the SDK to java 11
than don't forget clean and build

it will run the server on ```localhost:8080```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## 👥 Author <a name="author"></a>

👤 **Ichsan Sandy**

- GitHub: [@ichsansandy](https://github.com/ichsansandy)
- Twitter: [@1chsansandy](https://twitter.com/1chsansandy)
- LinkedIn: [Ichsan Sandy](https://linkedin.com/in/ichsans)


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- FUTURE FEATURES -->

## 🔭 Future Features <a name="future-features"></a>

- **Add UI System**


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## 🤝 Contributing <a name="contributing"></a>

Contributions, issues, and feature requests are welcome!

Feel free to check the [issues page](https://github.com/ichsansandy/ifabula-library-project/issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- SUPPORT -->

## ⭐️ Show your support <a name="support"></a>

If you like this project you can share this project to your friend

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->

## 📝 License <a name="license"></a>

This project is [MIT](./LICENSE) licensed.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
