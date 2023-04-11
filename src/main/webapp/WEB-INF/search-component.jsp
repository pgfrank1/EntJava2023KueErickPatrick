<%-- search container --%>
<div class="text-dark w-100">
    <%-- search bar title --%>
    <h3>Search</h3>
    <%-- search bar --%>
    <form id="apiSearch" method="POST" action="search">
        <%-- text input --%>
        <input type="text" class="form-control" name="query" placeholder="look up a plant" value="${userQuery}">
        <%-- enter and clear button container --%>
        <div class="container mt-3 justify-content-end d-flex p-0">
            <button class="btn btn-light border-black me-3" type="reset">clear</button>
            <button class="btn btn-primary border-black" type="submit" value="beginSearch">search</button>
        </div>
    </form>
</div>