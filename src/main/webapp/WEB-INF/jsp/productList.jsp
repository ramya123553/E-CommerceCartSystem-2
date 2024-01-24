<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        p {
            margin: 10px 0;
        }
    </style>
</head>
<body>

<h2>Product List</h2>

<!-- Static table structure -->
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Availability</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <!-- Sample product row -->
        <tr>
            <td>1</td>
            <td>Product 1</td>
            <td>$19.99</td>
            <td>Available</td>
            <td>
                <form action="/products/add" method="post">
                    <input type="hidden" name="productId" value="1">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        <!-- Repeat this block for each product -->
    </tbody>
</table>

<h3>Your Cart</h3>

<!-- Static cart summary -->
<p>You have 3 items in your cart.</p>
<p>Total Bill: $59.97</p>

</body>
</html>
