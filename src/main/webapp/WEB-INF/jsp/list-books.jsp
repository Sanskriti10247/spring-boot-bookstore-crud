<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Dashboard</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="navbar">
    <h2>📚 BookStore</h2>
    <div>
        <a href="/books">Home</a> |
        <a href="/addBook">Add Book</a>
    </div>
</div>

<div class="container">

    <h1>📖 Book Dashboard</h1>

    <a href="/addBook" class="btn">+ Add Book</a>

    <table>
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th>Author</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${books}" var="b">
            <tr>
                <td>${b.title}</td>
                <td>₹ ${b.price}</td>
                <td>${b.author.name}</td>
                <td>
                    <a href="/editBook/${b.id}">✏️ Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>