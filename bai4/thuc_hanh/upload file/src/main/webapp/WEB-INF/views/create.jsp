<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="/layout :: head"></head>
<body>
<h3>Add Product</h3>
<p>
    <a th:href="@{/product}">
        Back to product list
    </a>
</p>
<div id="form">
    <form th:action="@{/product/save}" th:object="${productForm}"
          method="POST" novalidate="novalidate" enctype="multipart/form-data">
        <input type="hidden" th:field="*{id}"/>
        <div>
            <label>Name</label>
            <input type="text" th:field="*{name}"/>
        </div>
        <div>
            <label>Description</label>
            <input type="text" th:field="*{description}"/>
        </div>
        <div>
            <label>Image</label>
            <input type="file" th:field="*{image}"/>
        </div>
        <input type="submit" value="Save"/>
    </form>
</div>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>