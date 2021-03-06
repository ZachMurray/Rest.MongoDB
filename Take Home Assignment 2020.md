# Take Home Assignment


## Objective

The goal of this assignment is to write a very simple Product REST API storing data in a SQL database. \
We will evaluate the project on adherence to the guidelines, code style and clarity and simplicity of the solution.


## Tasks

Write a HTTP REST API for product resource able to do the following operations:

* Insertion of a product. \
  The response must return the result of the insertion (the product entity data itself)
    * Sample Input:
  ```json
    {
      "name": "Red Shirt",
      "description": "Red hugo boss shirt",
      "brand": "Hugo Boss",
      "tags": [
        "red",
        "shirt", 
        "slim fit"
      ],
      "category": "apparel"
    }
  ```
  
  * Sample Output:
  ```json 
    {
      "id": "b6afac37-cf9a-4fd4-8257-f096dbb5d34d",
      "name": "Red Shirt",
      "description": "Red hugo boss shirt",
      "brand": "Hugo Boss",
      "tags": [
        "red",
        "shirt",
        "slim fit"
      ],
      "category": "apparel",
      "created_at": "2017-04-15T01:02:03Z"
    }
  ```

* Search of products by category, using an exact match on the text of the ‘category’ field,
  supporting pagination by page number and max entries per page.  
  This will return the list of products matching the criteria 
  sorted by created_at from newest to oldest. 
  * Sample Output
    ```json
    [ 
      {
        "id": "b6afac37-cf9a-4fd4-8257-f096dbb5d34d",
        "name": "Red Shirt",
        "description": "Red hugo boss shirt",
        "brand": "Hugo Boss",
        "tags": [
          "red",
          "shirt",
          "slim fit"
        ], 
        "category": "apparel", 
        "created_at": "2017-04-15T01:02:03Z" }, 
      {
        "id": "357cd2c8-6f69-4bea-a6fa-86e40af0d867",
        "name": "Blue Shirt",
        "description": "Blue hugo boss shirt",
        "brand": "Hugo Boss",
        "tags": [
          "blue",
        "shirt"
        ], 
        "category": "apparel", 
        "created_at": "2017-04-14T01:02:03Z" 
      }
  
    ]
    ```


## Guidelines

* The code must be written in Java (Use of java 8+ recommended) 
* You have entire freedom of the libraries to use for implementation  
  for persistence, serialization, http server, etc... \
  Pick the libraries/frameworks you are most familiar with.
* The REST API must consume application/json 
* The timestamp must be formatted as ISO8601 format 
* The path to the resource must be /v1/products
* The rest service should have some basic error handling
  * Stack traces should not be returned to the client
  * The service should return a generic 400 Bad Request and 500 Server Error for the respective errors of those types
* Please include some meaningful tests for your code
  * Ideally we would like to see both unit tests and functional tests at the api level
* Do not comment on the obvious but feel free to add comments that adds value to the reader
* Provide a short README that gives the instructions to compile and run your sample
* Assume your database is running on localhost with database name products, username centric and no password
  * Feel free to use an in memory database like H2 if you wish


## Returning the assignment

Make it available online using GitHub, 
and communicate the url to your Centric’s contact.


## Thank you

Thank you for your assistance with this assignment. 
You are welcome to give feedback about this process or instructions, 
your feedback matters to us.