@@ JSON

- ✅JSON was based on a subset of the JavaScript scripting language
- ✅Its a language independant data format.
- ✅JSON support for many programming languages and systems, including: ActionScript, C, C++, C#, Cold Fusion, Java, Lisp, Perl, Objective-C, OCAML, PHP, Python, Ruby.
- ✅

## What is Json?
- its a text based way of representing object literals, arrays, scalar data.
- it is easy to read write also easy for software to parse.



# parsing:
- code is taken from the preprocessor, broken into smaller pieces and analyzed so other software can understand it.

# serializing?
- Serialization or marshaling is the process of converting object state into a format that can be transmitted or stored.




# Is JSON an API language?
- JSON (JavaScript Object Notation) API is an application programming interface designed for lightweight data interchange (text-based data exchange format) 
between two computer applications operating on the same hardware device or between different computers in different geographical areas.
- ✅

## What is Rest-API?
- Representational state transfer (REST) is a software architectural style that was created to guide the design and development of the architecture for the World Wide Web. 
- rest defines a set of (limits)constraints. 
- it defines how the architecture of an Internet-scale distributed hypermedia system


# why Rest api?
- `Scalability`: RESTful APIs allow for scalable architecture by separating the client and server. This separation enables multiple clients to interact with a single server, allowing for increased flexibility and the ability to handle large numbers of concurrent requests.

- `Platform Independence`: RESTful APIs are based on the HTTP protocol, which is a standard protocol used on the internet. This makes RESTful APIs platform-independent, meaning they can be used by clients and servers implemented in different programming languages and running on different platforms.

- `Simplicity`: RESTful APIs are relatively simple and easy to understand compared to other architectural styles. They utilize standard HTTP methods (GET, POST, PUT, DELETE) to perform operations on resources, and URLs (Uniform Resource Locators) to identify and access those resources.

-`Flexibility`: RESTful APIs provide flexibility in terms of the data formats that can be used. They commonly support JSON (JavaScript Object Notation), which is lightweight and widely supported across different programming languages. This allows for easy integration and data exchange between different systems.

- `Wide Adoption`: RESTful APIs have become the de facto standard for building web services due to their simplicity, scalability, and widespread adoption. Many modern web applications, mobile apps, and third-party services provide APIs following REST principles, making it easier to integrate and interact with their systems.

- `Statelessness`: RESTful APIs are stateless, meaning that each request is independent and does not rely on the server storing any client-specific information between requests. This simplifies the server's implementation and allows for improved reliability and scalability






# How REST APIs work
- REST APIs communicate via HTTP requests to perform standard database functions like creating, reading, updating, and deleting records (also known as CRUD) within a resource.
- For example, a REST API would use a GET request to retrieve a record, a POST request to create one, a PUT request to update a record, and a DELETE request to delete one. All HTTP methods can be used in API calls. 
- The state of a resource at any particular instant, or timestamp, is known as the resource representation.
- This information can be delivered to a client in virtually any format including JavaScript Object Notation (JSON), HTML, XLT, Python, PHP, or plain text.
- JSON is popular because it’s readable by both humans and machines—and it is programming language-agnostic.

# The Headers
- Headers are used to provide information to both the client and server. It can be used for many purposes, such as authentication and providing information about the body content
- HTTP Headers are property-value pairs that are separated by a colon
        
        - "Content-Type: application/json". Missing the opening ".
- You can send HTTP headers with curl through the -H or --header option. To send the above header to Github’s API, you use this command:

        curl -H "Content-Type: application/json" https://api.github.com
        
 ## why header?
 - HTTP headers let the client and the server pass additional information with an HTTP request or response.
 - Client hints:
- HTTP Client hints are a set of request headers that provide useful information about the client such as device type and network conditions, and allow servers to optimize what is served for those conditions.





