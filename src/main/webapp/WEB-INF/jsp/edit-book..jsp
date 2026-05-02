<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
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

    <h2>Edit Book</h2>

    <form action="/updateBook" method="post">

        <input type="hidden" name="id" value="${book.id}"/>

        <input type="text" name="title" value="${book.title}" required/>

        <input type="number" name="price" value="${book.price}" required/>

        <select name="author.id">
            <c:forEach items="${authors}" var="a">
                <option value="${a.id}"
                        <c:if test="${book.author != null && a.id == book.author.id}">
                            selected
                        </c:if>
                >
                        ${a.name}
                </option>
            </c:forEach>
        </select>

        <button type="submit">Update Book</button>

    </form>

</div>

</body>
</html>