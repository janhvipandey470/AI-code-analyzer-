# 🤖 AI Code Analyzer

AI Code Analyzer is a Spring Boot application that uses **Spring AI + Ollama** to analyze source code and provide structured code-review feedback.

The application sends submitted code to a locally running Ollama model and asks it to evaluate the code for its language, time complexity, space complexity, bugs, purpose, and concrete improvement suggestions.

## ✨ Features

- 🤖 **AI-powered code review**
- ⏱️ **Time complexity analysis**
- 💾 **Space complexity analysis**
- 🐛 **Logical bug detection**
- 💡 **Code-specific improvement suggestions**
- 📖 **Code purpose explanation**
- 🚫 Designed to avoid giving corrected code or direct code hints
- 🏠 Uses **Ollama locally**, so the AI model can run on your own machine

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Application development |
| Spring Boot 3.5.4 | Backend framework |
| Spring Web | REST API |
| Spring AI 1.0.1 | AI integration |
| Ollama | Local LLM runtime |
| Llama 3.2 | Default AI model |
| Maven | Dependency management |
| Lombok | Java boilerplate reduction |

## 🏗️ Architecture

```text
                ┌──────────────────┐
                │      Client      │
                │  Source Code     │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ codeController   │
                │   GET /analyze   │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ AnalysisService  │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │  promptService   │
                │ Builds Review    │
                │     Prompt       │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │  OllamaService   │
                │  Spring AI       │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ Ollama / Llama   │
                │      3.2         │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ AI Review Result │
                └──────────────────┘
```

## 📁 Project Structure

```text
AICodeAnalyzer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/aicodeanalyzer/
│   │   │       ├── ai/
│   │   │       │   └── OllamaService.java
│   │   │       ├── config/
│   │   │       │   └── AIConfig.java
│   │   │       ├── controller/
│   │   │       │   └── codeController.java
│   │   │       ├── service/
│   │   │       │   ├── AnalysisService.java
│   │   │       │   └── promptService.java
│   │   │       └── AiCodeAnalyzerApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## ⚙️ Prerequisites

Before running the project, install:

- **Java 21**
- **Maven** (optional because Maven Wrapper is included)
- **Ollama**

The project is configured to connect to:

```text
http://localhost:11434
```

## 🧠 Set Up Ollama

Install Ollama from the official Ollama website:

https://ollama.com/

After installation, download the configured model:

```bash
ollama pull llama3.2
```

Start Ollama if it is not already running:

```bash
ollama serve
```

You can verify that the model is available with:

```bash
ollama list
```

## 🚀 Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/janhvipandey470/AI-code-analyzer-.git
cd AI-code-analyzer-
```

### 2. Make sure Ollama is running

```bash
ollama serve
```

Make sure the `llama3.2` model has been downloaded:

```bash
ollama pull llama3.2
```

### 3. Start the Spring Boot application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

On Linux/macOS:

```bash
./mvnw spring-boot:run
```

Alternatively, if Maven is installed:

```bash
mvn spring-boot:run
```

The Spring Boot application will start on the default port:

```text
http://localhost:8080
```

## 🔌 API

### Analyze Code

**Endpoint**

```http
GET /analyze
```

The endpoint accepts the source code as the request body and passes it through the analysis pipeline.

### Example Request

```bash
curl -X GET http://localhost:8080/analyze \
  -H "Content-Type: text/plain" \
  --data 'public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}'
```

### Example Response Format

The AI is instructed to return analysis in the following structure:

```text
Language:
Java

Time Complexity:
Explain why.

Space Complexity:
Explain why.

Bugs:
List logical bugs.

Suggestions:
Concrete code-specific improvements without code.

Purpose:
Explain what the code does.
```

> The exact response depends on the Llama 3.2 model's analysis of the submitted code.

## 🔄 How It Works

1. The client sends source code to `/analyze`.
2. `codeController` receives the request.
3. `AnalysisService` passes the code to `promptService`.
4. `promptService` creates a structured code-review prompt.
5. `OllamaService` sends the prompt through Spring AI.
6. Ollama runs the **Llama 3.2** model locally.
7. The generated analysis is returned to the client.

## 🧩 Core Components

### `codeController`

Exposes the `/analyze` API endpoint and forwards submitted source code to the analysis service.

### `AnalysisService`

Coordinates the analysis workflow between prompt creation and the AI service.

### `promptService`

Builds the code-review prompt. The prompt instructs the AI to:

- Determine the programming language
- Calculate time complexity
- Calculate space complexity
- Identify actual logical bugs
- Verify optimization claims
- Explain the purpose of the code
- Provide concrete improvements
- Avoid providing corrected code or code hints

### `OllamaService`

Uses Spring AI's `ChatClient` to communicate with the configured Ollama model.

### `AIConfig`

Creates the Spring AI `ChatClient` bean used by the application.

## ⚙️ Configuration

The current configuration is stored in:

```text
src/main/resources/application.properties
```

```properties
spring.application.name=AICodeAnalyzer
spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.options.model=llama3.2
```

To use another Ollama model, change:

```properties
spring.ai.ollama.chat.options.model=your-model-name
```

and make sure the model is installed:

```bash
ollama pull your-model-name
```

## 🎯 Use Cases

This project can be useful for:

- Students learning programming
- Understanding unfamiliar source code
- Checking algorithm complexity
- Finding logical bugs
- Preparing code for technical interviews
- Learning how AI can assist with code reviews
- Experimenting with local LLMs and Spring AI

## 🔮 Future Improvements

- [ ] Support file uploads
- [ ] Support multiple programming languages
- [ ] Add a web-based UI
- [ ] Add syntax highlighting
- [ ] Add code quality scoring
- [ ] Add authentication
- [ ] Store analysis history
- [ ] Support multiple AI models
- [ ] Add static-analysis tools alongside the LLM
- [ ] Add GitHub repository/codebase analysis
- [ ] Add automated test-case suggestions
- [ ] Add Docker support
- [ ] Add deployment configuration

## ⚠️ Limitations

- The application currently relies on a locally running Ollama instance.
- AI-generated analysis may not always be correct and should be reviewed by a developer.
- The current API accepts code directly in the request body rather than providing a dedicated file-upload workflow.
- The default model is Llama 3.2, so output quality depends on the installed model and available system resources.

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a feature branch:

```bash
git checkout -b feature/your-feature
```

3. Make your changes.
4. Commit your changes:

```bash
git commit -m "Add your feature"
```

5. Push your branch:

```bash
git push origin feature/your-feature
```

6. Open a Pull Request.

## 👩‍💻 Author

**Janhvi Pandey**


Built with **Java, Spring Boot, Spring AI, Ollama, and Llama 3.2**.
