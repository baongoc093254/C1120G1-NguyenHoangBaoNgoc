use classicmodels;
SELECT productCode, productName, buyprice, quantityInStock
FROM products
WHERE buyprice > 56.76 and quantityInStock > 10;

SELECT productCode, productName, buyprice, textDescription
FROM products
INNER JOIN productlines
ON products.productLine = productlines.productLine
WHERE buyPrice > 56.76 AND buyPrice < 95.59;

SELECT productCode, productName, buyPrice, quantityInStock, productVendor, productLine
FROM products
WHERE productLine = 'Classic Cars' or productVendor = 'Min Lin Diecast';