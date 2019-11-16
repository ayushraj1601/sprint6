<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page import="com.cg.ibs.rm.model.CreditCard"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>unapprovedrequests</title>
</head>
<body>
	<jsp:include page="/rmadmin"></jsp:include>
	<h2>Beneficiaries</h2>


	<c:choose>
		<c:when test="${beneficiaries==null or beneficiaries.size()==0 }">
			<p>
				<strong>No Records Available</strong>
			</p>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>Beneficiary Account No</th>
					<th>Beneficiary Account Name</th>
					<th>Bank Ifsc Code</th>
					<th>Bank Name</th>
					<th>Account Type</th>
					<th>Current Status</th>
					<th>Request Time</th>
					<th colspan="2">Approve/Decline</th>
				</tr>
				<c:forEach var="beneficiary" items="${beneficiaries}">
					<tr>
						<td>${beneficiary.accountNumber}</td>
						<td>${beneficiary.accountName}</td>
						<td>${beneficiary.ifscCode}</td>
						<td>${beneficiary.bankName}</td>
						<td>${beneficiary.type}</td>
						<td>${beneficiary.status}</td>
						<td>${beneficiary.timestamp}</td>
						<td colspan="2">&nbsp;
							<form action="acceptBeneficiaries">
								<input type="hidden" name="accountNumber"
									value="${beneficiary.accountNumber}"> <input
									type="submit" name="decision" value="Approve">
								&nbsp;&nbsp; <input type="submit" name="decision"
									value="Decline"> &nbsp;
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>

</html>