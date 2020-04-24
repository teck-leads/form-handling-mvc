<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<div class="container">


	
	<p>User Registration</p>

	<form:form modelAttribute="usersCmd"  method="post" action="users">

		<fieldset class="form-group">

			<c:if test="${idKey ne 0}">
				<label>Registration ID</label>
				<form:input path="id" class="form-control" readonly="true" />
			</c:if>

			<label>Name</label>
			<form:input path="name" class="form-control" required="required" oninvalid="this.setCustomValidity('Enter Name')" oninput="this.setCustomValidity('')"/>
			<label>Age</label>
			<form:input path="age" class="form-control" required="required" oninvalid="this.setCustomValidity('Enter Age')" oninput="this.setCustomValidity('')"/>

			<label>User Location</label>
			<form:input path="userLocation" class="form-control" required="required" oninvalid="this.setCustomValidity('Enter User Location')" oninput="this.setCustomValidity('')"/>

			<label>Hospital Location</label>
			<form:input path="hopitalLocation" class="form-control" required="required" oninvalid="this.setCustomValidity('Enter Hospital Location')" oninput="this.setCustomValidity('')"/>
		</fieldset>
		
		<c:if test="${idKey eq 0}">
    	   <input type="submit" value="Register" class="btn btn-outline-primary">
    	   <input type="reset" value="Reset" class="btn btn-outline-dark">
    	   
	</c:if>
			<c:if test="${idKey gt 0}">
    	  <input type="submit" value="Update" class="btn btn-outline-primary">
	</c:if>
	</form:form>
</div>

<%@include file="common/footer.jspf"%>