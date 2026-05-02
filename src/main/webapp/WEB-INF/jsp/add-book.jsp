<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="navbar">
    <h2>📚 BookStore</h2>
    <div>
        <a href="/books">Home</a>
    </div>
</div>

<div class="container">

    <h2>Add New Book</h2>

    <form action="/saveBook" method="post">

        <input type="text" name="title" placeholder="Enter Book Title" required/>

        <input type="number" name="price" placeholder="Enter Price" required/>

        <select name="author.id">
            <c:forEach items="${authors}" var="a">
                <option value="${a.id}">${a.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Save Book</button>

    </form>

</div>

</body>
</html>