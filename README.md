# 🤖 AI Code Analyzer

An AI-powered code analysis tool built using **Spring Boot, Spring AI, Ollama, and Llama 3.2**.

The application analyzes source code and provides feedback about its **logic, time complexity, space complexity, potential bugs, and possible improvements** without directly giving the corrected code.

---

## 🚀 Features

- 🔍 Analyze source code using AI
- 🧠 AI-powered code review
- ⏱️ Time complexity analysis
- 💾 Space complexity analysis
- 🐛 Identify potential logical issues
- 💡 Suggest improvements
- 🚫 Does not directly provide corrected code
- 🖥️ Web-based UI using Thymeleaf
- 🎨 Responsive frontend using HTML & CSS
- ⚡ JavaScript-based frontend interactions
- 🔒 Runs locally using Ollama
- 🌐 REST-based Spring Boot backend

---

## 🛠️ Tech Stack

### Backend

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Web**
- **Spring AI 1.0.1**
- **Maven**
- **Lombok**

### AI

- **Ollama**
- **Llama 3.2**

### Frontend

- **Thymeleaf**
- **HTML5**
- **CSS3**
- **JavaScript**

---

## 🏗️ Architecture

```text
                    ┌───────────────────┐
                    │      Browser      │
                    │  Thymeleaf UI     │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │  CodeController   │
                    │   POST /analyze    │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │ AnalysisService   │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │   PromptService   │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │  OllamaService    │
                    │   Spring AI       │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │      Ollama       │
                    │     Llama 3.2     │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │ Analysis Result   │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │ Thymeleaf UI      │
                    └───────────────────┘
```

---

## 📁 Project Structure

```text
AICodeAnalyzer/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── aicodeanalyzer/
│   │   │               │
│   │   │               ├── ai/
│   │   │               │   └── OllamaService.java
│   │   │               │
│   │   │               ├── config/
│   │   │               │   └── AIConfig.java
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   └── CodeController.java
│   │   │               │
│   │   │               └── service/
│   │   │                   ├── AnalysisService.java
│   │   │                   └── PromptService.java
│   │   │
│   │   └── resources/
│   │       │
│   │       ├── templates/
│   │       │   └── index.html
│   │       │
│   │       ├── static/
│   │       │   ├── css/
│   │       │   │   └── style.css
│   │       │   │
│   │       │   └── js/
│   │       │       └── script.js
│   │       │
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

## ⚙️ How It Works

The application follows this flow:

```text
User enters code
       ↓
Thymeleaf Web Interface
       ↓
POST /analyze
       ↓
CodeController
       ↓
AnalysisService
       ↓
PromptService
       ↓
OllamaService
       ↓
Spring AI ChatClient
       ↓
Ollama
       ↓
Llama 3.2
       ↓
AI Analysis
       ↓
Thymeleaf displays result
```

---

## 🧠 AI Analysis

The analyzer focuses on several aspects of the submitted code.

### 1. Code Logic

The AI examines the code and explains how the logic works and whether there are potential logical problems.

### 2. Time Complexity

The analyzer identifies the expected time complexity of the algorithm.

Example:

```text
Time Complexity: O(n log n)
```

### 3. Space Complexity

The analyzer evaluates the additional memory used by the algorithm.

Example:

```text
Space Complexity: O(n)
```

### 4. Potential Bugs

The AI attempts to identify:

- Logical errors
- Incorrect conditions
- Possible edge cases
- Unnecessary operations
- Potential runtime problems

### 5. Improvements

The analyzer provides suggestions for improving:

- Code efficiency
- Readability
- Algorithmic approach
- Memory usage
- Overall implementation

The goal is to help the developer **understand and improve their own code rather than simply receiving a corrected solution**.

---

# 🖥️ Web Interface

The application provides a web interface where users can paste their code and request an analysis.

The frontend is implemented using:

- Thymeleaf
- HTML
- CSS
- JavaScript

---

# 🚀 Future Improvements

Planned improvements include:

- 📁 File upload support
- 🎨 Syntax highlighting
- 📝 Support for multiple programming languages
- ⚡ Streaming AI responses
- 📊 Better complexity visualization
- 🔐 User authentication
- 💾 Store previous analyses
- 📜 Analysis history
- 🌐 Deploy the application
- 🤖 Support for additional AI models
- 🧪 Automated code testing
- 📈 Improved analysis reports
- 🎯 Better UI/UX

---

# 🤝 Contributing

Contributions are welcome.

To contribute:

```bash
git clone https://github.com/janhvipandey470/AI-code-analyzer-.git
```

Create a new branch:

```bash
git checkout -b feature/new-feature
```

Make your changes and commit:

```bash
git add .
git commit -m "Add new feature"
```

Push the branch:

```bash
git push origin feature/new-feature
```

Then create a Pull Request.


---

# 👩‍💻 Author

**Janhvi Pandey**

