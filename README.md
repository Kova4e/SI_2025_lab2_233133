# David Kovaceski 233133

# Control Flow Graph
![Untitled Diagram drawio](https://github.com/user-attachments/assets/76eed33c-ea28-47db-a5a9-8fe8dd5f1853)


# Цикломатска комплексност
Цикломатската комплексност на овој код е 9, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=8, па цикломатската комплексност изнесува 9.

# Тест случаи според критериумот Every statement

TC1
Опис: Листата е null
Влез: allItems = null, cardNumber = "1234567812345678"
Очекуван резултат: RuntimeException - "allItems list can't be null!"

TC2
Опис: Предмет со null име
Влез: allItems = [Item(null, 1, 100, 0.0)], cardNumber = "1234567812345678"
Очекуван резултат: RuntimeException - "Invalid item!"

TC3
Опис: Valid item без попуст, со нормални вредности
Влез: allItems = [Item("Soap", 2, 100, 0.0)], cardNumber = "1234567812345678"
Очекуван резултат: 200.0

TC4
Опис: Valid item со попуст и цена над 300
Влез: allItems = [Item("Monitor", 1, 400, 0.2)], cardNumber = "1234567812345678"
Очекуван резултат: 290.0

TC5
Опис: Valid item, но бројот на картичка има невалиден карактер
Влез: allItems = [Item("Book", 1, 50, 0.0)], cardNumber = "12345678abcd5678"
Очекуван резултат: RuntimeException - "Invalid character in card number!"

TC6
Опис: Valid item, но бројот на картичка не е 16 цифри
Влез: allItems = [Item("Pen", 1, 10, 0.0)], cardNumber = "1234"
Очекуван резултат: RuntimeException - "Invalid card number!"

# Тест случаи според критериумот Multiple Condition

MC1
Price > 300: false
Discount > 0: false
Quantity > 10: false
Опис: Ниеден услов не е исполнет
Очекуван резултат: Не се одзема 30

MC2
Price > 300: true
Discount > 0: false
Quantity > 10: false
Опис: Само цена е над 300
Очекуван резултат: Се одзема 30

MC3
Price > 300: false
Discount > 0: true
Quantity > 10: false
Опис: Само попуст е над 0
Очекуван резултат: Се одзема 30

MC4
Price > 300: false
Discount > 0: false
Quantity > 10: true
Опис: Само количина е над 10
Очекуван резултат: Се одзема 30

MC5
Price > 300: true
Discount > 0: true
Quantity > 10: true
Опис: Сите услови се исполнети
Очекуван резултат: Се одзема 30

MC6
Price > 300: true
Discount > 0: false
Quantity > 10: true
Опис: Цена и количина се исполнети
Очекуван резултат: Се одзема 30

MC7
Price > 300: false
Discount > 0: true
Quantity > 10: true
Опис: Попуст и количина се исполнети
Очекуван резултат: Се одзема 30

MC8
Price > 300: true
Discount > 0: true
Quantity > 10: false
Опис: Цена и попуст се исполнети
Очекуван резултат: Се одзема 30
