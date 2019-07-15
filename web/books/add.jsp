<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Book</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form method="post">
    <div class="form-group">
        <div class="left">
            <label for="title">Title</label>
        </div>
        <div class="right">
            <input type="text" name="title" placeholder="Enter book title" id="title">
        </div>
    </div>

    <div class="form-group">
        <div class="left">
            <label for="author">Author</label>
        </div>
        <div class="right">
            <input type="text" name="author" placeholder="Enter author name" id="author">
        </div>
    </div>

    <div class="form-group">
        <div class="left">
            <label for="isbn">ISBN</label>
        </div>
        <div class="right">
            <input type="text" name="isbn" placeholder="Enter ISBN number" id="isbn">
        </div>
    </div>

    <div class="form-group">
        <div class="left">
            <label for="edition">Edition</label>
        </div>
        <div class="right">
            <input type="text" name="edition" placeholder="Enter edition" id="edition">
        </div>
    </div>

    <div class="form-group">
        <div class="left">
            <label for="price">Price</label>
        </div>
        <div class="right">
            <input type="text" name="price" placeholder="Enter price" id="price">
        </div>
    </div>

    <div class="form-group">
        <div class="left">
            <button type="submit" id="add-book-button" class="btn btn-primary">Submit</button>
        </div>
    </div>

</form>

</body>
</html>
