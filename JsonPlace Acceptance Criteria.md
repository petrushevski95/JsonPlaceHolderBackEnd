# Acceptance Criteria

## Test Scenario 1: Successful Get Request (Get All Users)
**GIVEN** a get all request is sent to the endpoint [https://jsonplaceholder.typicode.com/posts](https://jsonplaceholder.typicode.com/posts),  
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

## Test Scenario 2: Successful Get Request (Get a Single User)

**GIVEN** a GET request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts/28`,  
**WHEN** the server response is status code: `200 OK`,  
**THEN** the server responds back with the body result printed like this:

```json
{
    "userId": 3,
    "id": 28,
    "title": "delectus ullam et corporis nulla voluptas sequi",
    "body": "non et quaerat ex quae ad maiores\nmaiores recusandae totam aut blanditiis mollitia quas illo\nut voluptatibus voluptatem\nsimilique nostrum eum"
}
```

## Test Scenario 3: Successful Post Request

**GIVEN** a POST request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts`,  
**AND** the sent body request is like this:

```json
{
    "title": "value",
    "body": "value"
}
```
**WHEN** the server response is status code: 201 Created,  
**THEN** the server responds back with the body result printed like this:

```json
{
    "id": 101,
    "title": "value",
    "body": "value"
}
```

## Test Scenario 4: Successful Put Request

**GIVEN** a PUT request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts/[id]`,  
**AND** the sent body request is like this:

```json
{
    "id": [id],
    "title": "value",
    "body": "value"
}
```
**WHEN** the server response is status code: 200 OK,  
**THEN** the server responds back with the body result printed like this:

```json
{
    "id": [id],
    "title": "value",
    "body": "value"
}
```

## Test Scenario 5: Delete User

**GIVEN** a DELETE request is sent to the endpoint `https://jsonplaceholder.typicode.com/posts/[id]`,  
**WHEN** the server response is status code: `200 OK`,  
**THEN** the server responds back with the body result printed like this:

```json
{}
```
