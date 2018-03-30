# myretail-service

RestFUL Service to retrive and product information. This is a Spring Boot application which comes with embedded MongoDB to store and retreive product info.

Payload for adding Product information.
{
    "name": "Test Product",
    "productPrice": {
        "price": 100.00,
        "currencyType": "USD"
    }
}

Get Call:
domain/products/{productid}

Sample Response:
{"id":15117729,"name":"Test Product","productPrice":{"price":100.0,"currencyType":"USD"}}
