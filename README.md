# Multithreaded Chat Application

## Task 3 — Java Internship Project

A Java-based **client-server chat application** that uses socket programming and multithreading to allow multiple clients to communicate with each other through a central server.

## Features

- Client-server communication
- Multiple clients can connect to the server
- Real-time message broadcasting
- Multithreading using Java `Thread`
- Socket programming
- Clients can disconnect using `exit`
- Server handles multiple connected clients
- Exception handling

## Technologies Used

- Java
- Socket Programming
- TCP/IP
- Multithreading
- `ServerSocket`
- `Socket`
- `Thread`
- `BufferedReader`
- `PrintWriter`
- `Scanner`

## Project Structure

```text
Multithreaded-Chat-Application/
├── src/
│   ├── ChatServer.java
│   ├── ChatClient.java
│   └── ClientHandler.java
├── screenshots/
│   ├── server-output.png
│   ├── client1.png
│   └── client2.png
└── README.md
```

## How the Application Works

The application follows a client-server architecture.

```text
             Chat Server
            /     |     \
           /      |      \
      Client 1  Client 2  Client 3
```

### Chat Server

`ChatServer.java` creates a server using `ServerSocket` on port `5000`.

It waits for clients to connect.

When a client connects, the server creates a separate `ClientHandler` thread for that client.

### Client Handler

`ClientHandler.java` handles communication with an individual client.

Each connected client gets its own thread, allowing multiple clients to communicate at the same time.

### Chat Client

`ChatClient.java` connects to the server using a socket.

It has a separate thread for receiving messages while the main thread handles messages entered by the user.

## How Messages Are Broadcast

When a client sends a message:

```text
Client
   ↓
Chat Server
   ↓
ClientHandler
   ↓
Other Connected Clients
```

The server broadcasts the message to the other connected clients.

## How to Run

### Step 1: Open the project

Open the `Multithreaded-Chat-Application` folder in VS Code.

### Step 2: Open a terminal

Go to the project folder:

```bash
cd D:\Multithreaded-Chat-Application
```

### Step 3: Compile the program

```bash
javac -d bin src\ChatServer.java src\ClientHandler.java src\ChatClient.java
```

### Step 4: Start the server

```bash
java -cp bin ChatServer
```

The server displays:

```text
Chat Server Started...
Waiting for clients...
```

### Step 5: Start Client 1

Open another terminal and run:

```bash
cd D:\Multithreaded-Chat-Application
java -cp bin ChatClient
```

### Step 6: Start Client 2

Open a third terminal and run:

```bash
cd D:\Multithreaded-Chat-Application
java -cp bin ChatClient
```

Both clients can now communicate through the server.

## Sample Output

### Server

```text
Chat Server Started...
Waiting for clients...
Client connected!
Client: Haiii
Client connected!
Client: Hai everyone!
```

### Client 1

```text
Connected to Chat Server!
You: Haiii

Hai everyone!
You:
```

### Client 2

```text
Connected to Chat Server!
You: Hai everyone!
You:
```

## Disconnecting a Client

To leave the chat, enter:

```text
exit
```

The client disconnects from the server while other clients can continue communicating.

## Learning Outcomes

Through this project, I practiced:

- Java socket programming
- Client-server communication
- TCP/IP communication
- Multithreading
- Creating and managing threads
- Broadcasting messages
- Handling multiple clients
- Exception handling
- Using Java I/O streams

## Internship Task

**Task:** Multithreaded Chat Application

**Objective:** Build a client-server chat application using Java sockets and multithreading to handle multiple users.

**Status:** Completed
