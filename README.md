# myretail-service

RestFUL Service to retrive and product information.

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
