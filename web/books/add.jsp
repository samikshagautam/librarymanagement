<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Book</title>
</head>
<body>
<form method="post">
    <div class="row">
        <div class="left">
            <label for="title">Title</label>
        </div>
        <div class="right">
            <input type="text" name="title" placeholder="Enter book title" id="title"/>
        </div>
    </div>

    <div class="row">
        <div class="left">
            <label for="author">Author</label>
        </div>
        <div class="right">
            <input type="text" name="author" placeholder="Enter author name" id="author"/>
        </div>
    </div>

    <div class="row">
        <div class="left">
            <label for="isbn">ISBN</label>
        </div>
        <div class="right">
            <input type="text" name="isbn" placeholder="Enter ISBN number" id="isbn"/>
        </div>
    </div>

    <div class="row">
        <div class="left">
            <label for="edition">Edition</label>
        </div>
        <div class="right">
            <input type="text" name="edition" placeholder="Enter edition" id="edition"/>
        </div>
    </div>

    <div class="row">
        <div class="left">
            <label for="price">Price</label>
        </div>
        <div class="right">
            <input type="text" name="price" placeholder="Enter price" id="price"/>
        </div>
    </div>

    <div class="row">
        <div class="left">
            <button type="submit" id="add-book-button">Submit</button>
        </div>
    </div>

</form>

</body>
</html>
