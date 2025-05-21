# 😂 Jokes Book

**Jokes Book** is a full-stack web application where users can explore, add, and manage jokes by category. The project features a vibrant UI, categorized joke filtering, and persistent storage via a backend API and database.

---

## 🌐 Live App

Try the app live with no setup required:

🔗 **[https://jokes-book.netlify.app](https://jokes-book.netlify.app)**

---

## 📦 Frontend Repository

This backend is paired with the frontend available at:

🔗 [jokes-book-frontend](https://github.com/Lolisolera/jokes-book-frontend)

---

## 💡 Features

### 🖥️ Frontend
- **Joke of the Day**: Automatically shows a daily joke.
- **Category Filtering**: Browse jokes by `Futuristic`, `Geek`, or `Dark`.
- **Joke Management**:
    - Add a new joke via form (category, author, tag)
    - Delete jokes by entering their ID
- **Responsive Design** with custom SCSS styling

### 🔧 Backend
- Built with **Spring Boot**
- REST API for full CRUD operations
- MySQL database integration
- Graceful fallback if "joke of the day" is missing

---

## 🛠️ Tech Stack

### Frontend
- [TypeScript](https://www.typescriptlang.org/)
- [Vite](https://vitejs.dev/)
- [SCSS](https://sass-lang.com/)
- [Netlify](https://www.netlify.com/) (for deployment)

### Backend
- [Java 17+](https://adoptium.net/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [JPA (Hibernate)](https://hibernate.org/)
- [Railway](https://railway.app/) (for hosting backend and DB)

---

## 🚀 Getting Started

> These instructions are for developers who want to run the project locally or contribute.

### 🔧 Prerequisites
- Node.js (v18+ recommended)
- Java 17 or higher
- MySQL Server (if running backend locally)

---

### 🖥️ Frontend Setup

```bash
git clone https://github.com/Lolisolera/jokes-book-frontend 
cd jokes-book-frontend
npm install
npm run dev
```

Then visit: [http://localhost:5173](http://localhost:5173)

---

### 🔙 Backend Setup

```bash
git clone https://github.com/Lolisolera/jokes-book
cd jokes-book
./mvnw spring-boot:run
```

---

### 📂 Project Structure

```
jokes-book/
├── jokes-book-frontend/      # Vite + TypeScript + SCSS
└── jokes-book/               # Spring Boot + MySQL
```

---

### 📄 License

This project is licensed under the **MIT License**.

```
MIT License

Copyright (c) 2025 The Jokes Book Contributors

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

### 🙌 Contributing

Pull requests are welcome! If you spot any bugs, have suggestions, or want to add features, feel free to fork the repo and submit a PR.

---

### 👥 Contributors

Meet the team behind Jokes Book:  
📄 [View CONTRIBUTORS.md](https://github.com/Lolisolera/jokes-book-frontend/blob/main/CONTRIBUTORS.md)
