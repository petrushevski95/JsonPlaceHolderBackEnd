
# Test Cases

## Test Case 1: Successful Get Request (Get All Users) (PASS)

**GIVEN** a GET all request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts`,  
**WHEN** the server response is status code: `200 OK`,  
**THEN** the server responds back with body result printed like this:

```json
[
    {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    },
    {
        "userId": 1,
        "id": 2,
        "title": "qui est esse",
        "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
    },
    {
        "userId": 1,
        "id": 3,
        "title": "ea molestias quasi exercitationem repellat qui ipsa sit aut",
        "body": "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
    },
    {
        "userId": 1,
        "id": 4,
        "title": "eum et est occaecati",
        "body": "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"
    }
]
```

## Test Case 2: Successful Get Request (Get a Single User) (PASS)

**GIVEN** a GET request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts/28`,  
**AND** values for the user with an id "28" are:

```json
{
    "userId": 3,
    "id": 28,
    "title": "delectus ullam et corporis nulla voluptas sequi",
    "body": "non et quaerat ex quae ad maiores\nmaiores recusandae totam aut blanditiis mollitia quas illo\nut voluptatibus voluptatem\nsimilique nostrum eum"
}
```
**WHEN** the server response is status code: 200 OK,   
**THEN** the server responds back with body result printed like this:

```json
{
    "userId": 3,
    "id": 28,
    "title": "delectus ullam et corporis nulla voluptas sequi",
    "body": "non et quaerat ex quae ad maiores\nmaiores recusandae totam aut blanditiis mollitia quas illo\nut voluptatibus voluptatem\nsimilique nostrum eum"
}
```

## Test Case 3: Successful Post Request (Default Values) (PASS)

**GIVEN** a POST request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts`,  
**AND** the body request for the new user has these values:

```json
{
    "title": "Default value",
    "body": "Default value"
}
```
**WHEN** the server response is status code: 201 Created,  
**AND** a new user is created,  
**THEN** the server responds back with body result printed like this:

```json
{
    "id": 101,
    "title": "Default value",
    "body": "Default value"
}
```

## Test Case 4: Successful Post Request (Updated Values) (PASS)

**GIVEN** a POST request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts`,          
**AND** the body request for the new user has these values:

```json
{
    "title": "Updated value",
    "body": "Updated value"
}
```
**WHEN** the server response is status code: 201 Created,    
**AND** a new user is created,   
**THEN** the server responds back with body result printed like this:    

```json

{
    "title": "Updated value",
    "body": "Updated value",
    "id": 101
}
```

## Test Case 5: Successful Put Request (Default Values) (PASS)

**GIVEN** a PUT request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts/28`,  
**AND** the user with the id "28" has values like this:

```json
{
    "userId": 3,
    "id": 28,
    "title": "delectus ullam et corporis nulla voluptas sequi",
    "body": "non et quaerat ex quae ad maiores\nmaiores recusandae totam aut blanditiis mollitia quas illo\nut voluptatibus voluptatem\nsimilique nostrum eum"
}
```
**AND** a body request is sent with structure like this:

```json
{
    "id": 28,
    "title": "Default value",
    "body": "Default value"
}
```
**WHEN** the server response is status code: 200 OK,   
**THEN** the server responds back with body result printed like this:

```json

{
    "id": 28,
    "title": "Default value",
    "body": "Default value"
}
```

## Test Case 5: Successful Put Request (Updated Values) (PASS)

**GIVEN** a PUT request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts/28`,  
**AND** the user with the id "28" has values like this:

```json
{
    "userId": 3,
    "id": 28,
    "title": "delectus ullam et corporis nulla voluptas sequi",
    "body": "non et quaerat ex quae ad maiores\nmaiores recusandae totam aut blanditiis mollitia quas illo\nut voluptatibus voluptatem\nsimilique nostrum eum"
}
```
**AND** a body request is sent with structure like this:

```json
{
    "id": 28,
    "title": "Updated value",
    "body": "Updated value"
}
```
**WHEN** the server response is status code: 200 OK,   
**THEN** the server responds back with body result printed like this:

```json

{
    "id": 28,
    "title": "Updated value",
    "body": "Updated value"
}
```

## Test Case 7: Successful Delete Request (PASS)  
**GIVEN** a delete request is sent to the endpoint https://jsonplaceholder.typicode.com/posts/20,   
**WHEN** the server response is status code: 200 OK,     
**THEN** the server responds back with body result printed like this:
```json
{}
```

