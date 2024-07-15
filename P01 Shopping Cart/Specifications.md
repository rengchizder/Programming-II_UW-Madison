# Specifications
## Objective
Develop a shopping cart application in Java to perform basic shopping operations such as adding items, removing items, displaying the cart, and checking out.

## Market Items
A perfect-size two-dimensional array stores the available items in the market. Each item is identified by an index, description, and unit price.

```{java}
public static final String[][] MARKET_ITEMS = new String[][] {
    {"Apple", "$1.59"}, {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"},
    {"Blueberry", "$6.89"}, {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"},
    {"Cereal", "$3.69"}, {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"},
    {"Cookie", "$9.5"}, {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"},
    {"Ice Cream", "$5.39"}, {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"},
    {"Pepper", "$1.99"}, {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"},
    {"Tomato", "$1.79"}
};
```

## Constants
Define constants to represent the shopping cart's capacity and the sales tax rate.
```{java}
private static final int CART_CAPACITY = 20;
private static final double TAX_RATE = 0.05;
```

## Functional Requirements
Implement the following static methods in the ShoppingCart class:
- Print Market Catalog
    - Print all available items in the market.
- Add Item to Cart
    - Add an item to the cart based on its identifier.
- Remove Item from Cart
    - Remove an item from the cart based on its identifier.
- Display Cart Content
    - Display the current items in the cart.
- Checkout
    - Calculate and display the subtotal, tax, and total cost of the items in the cart.
- Count Occurrences of an Item
    - Count and display the number of occurrences of a specific item in the cart based on its identifier.

## Testing and Validation
Implement test-driven development (TDD) to ensure code reliability and maintainability. Write unit tests for each method to verify its functionality and handle edge cases.

### Example Unit Test
```{java}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void testAddItemToCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItemToCart(0); // Add Apple
        assertEquals(1, cart.countOccurrences(0)); // Apple count should be 1
    }

    // Additional tests for other methods
}
```

For more information, refer to the [original assignment page](https://web.archive.org/web/20190128221701/http://cs300-www.cs.wisc.edu/wp/2019/01/19/p01-shopping-cart/).



