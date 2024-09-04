# Grocery-Shop

![image](https://github.com/Vidhi093/Grocery-Shop-JDBC/assets/149268685/5fe2d45f-92bd-4979-8723-9bbdc2b21583)
![image](https://github.com/Vidhi093/Grocery-Shop-JDBC/assets/149268685/38fe0447-8677-44ff-a456-92ed7821539c)
![image](https://github.com/Vidhi093/Grocery-Shop-JDBC/assets/149268685/678e84fb-2f1c-482a-aa47-3619b1e2a3fd)

### `ShopController` Class

#### Description:
The `ShopController` class manages database operations related to product management in an online shop.

#### Methods:
1. `addProduct(int id, String name, int price, int quantity, boolean avaliability): int`:
    - Adds a single product to the database with the provided details.
    - Parameters:
        - `id`: Product ID.
        - `name`: Product name.
        - `price`: Product price.
        - `quantity`: Quantity of the product available.
        - `availability`: Boolean indicating product availability.
    - Returns the number of rows affected.

2. `addMultipleProducts(ArrayList<Product> products): void`:
    - Adds multiple products to the database.
    - Parameter:
        - `products`: List of `Product` objects.
    - Does not return any value.

3. `fetchProduct(int id): ResultSet`:
    - Retrieves product details from the database based on the provided ID.
    - Parameter:
        - `id`: Product ID.
    - Returns a `ResultSet` containing the product information.

4. `removeProduct(int id): int`:
    - Removes a product from the database based on the provided ID.
    - Parameter:
        - `id`: Product ID.
    - Returns the number of rows affected.

5. `updateProductName(int id, String name): int`:
    - Updates the name of a product in the database based on the provided ID.
    - Parameters:
        - `id`: Product ID.
        - `name`: New product name.
    - Returns the number of rows affected.

6. `updateProductPrice(int id, int price): int`:
    - Updates the price of a product in the database based on the provided ID.
    - Parameters:
        - `id`: Product ID.
        - `price`: New product price.
    - Returns the number of rows affected.

7. `updateProductQuantity(int id, int quantity, boolean available): int`:
    - Updates the quantity and availability of a product in the database based on the provided ID.
    - Parameters:
        - `id`: Product ID.
        - `quantity`: New quantity of the product.
        - `available`: Boolean indicating product availability.
    - Returns the number of rows affected.

### `Product` Class

#### Description:
The `Product` class represents a product entity in the shop.

#### Fields:
- `p_id` (int): Product ID.
- `p_name` (String): Product name.
- `p_price` (int): Product price.
- `p_quantity` (int): Quantity of the product available.
- `p_availability` (boolean): Product availability status.

#### Getters and Setters:
- `getP_id(): int` and `setP_id(int id)`: Accesses and modifies the product ID.
- `getP_name(): String` and `setP_name(String name)`: Accesses and modifies the product name.
- `getP_price(): int` and `setP_price(int price)`: Accesses and modifies the product price.
- `getP_quantity(): int` and `setP_quantity(int quantity)`: Accesses and modifies the product quantity.
- `isP_availability(): boolean` and `setP_availability(boolean availability)`: Accesses and modifies the product availability status.

### `ShopView` Class

#### Description:
The `ShopView` class provides a console-based user interface for managing products in the shop.

#### Methods:
- `main(String[] args) throws SQLException`:
    - The main entry point of the application.
    - Displays a menu for users to perform various operations on products.
    - Handles adding, removing, updating, and fetching product details using user input through the console.

The class uses a `Scanner` to receive user inputs and interacts with the `ShopController` for performing operations on the shop's products. It implements a loop to continuously prompt the user for actions until they choose to exit.
