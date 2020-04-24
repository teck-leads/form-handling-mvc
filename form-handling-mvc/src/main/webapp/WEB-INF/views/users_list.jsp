<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>



<div class="container">




	<table class="table table-striped">


		<thead>
			<tr>
				<th>Registration ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>User Location</th>
				<th>Hospital Location</th>
				<th>Edit</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${usersList }" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.userLocation}</td>
					<td>${user.hopitalLocation}</td>
					<td><a href="/form-handling-mvc/users/edit/${user.id}" class="btn btn-info">Update</a></td>
					<td>
					<%-- <a href="/form-handling-mvc/users/delete/${user.id}" class="deleteRecord">Delete
					 <span class="glyphicon glyphicon-remove"></span>
					</a> --%>
					<%-- <a href="/form-handling-mvc/users/delete/${user.id}" data-toggle="modal" data-target="#exampleModal">Delete
					</a> --%>
					
					<a href="#" data-href="/form-handling-mvc/users/delete/${user.id}" data-toggle="modal" data-target="#confirm-delete" class="btn btn-danger">Delete</a>
					</td>
					
					
				</tr>
			</c:forEach>

		</tbody>

	</table>





</div>

<%@include file="common/footer.jspf"%>