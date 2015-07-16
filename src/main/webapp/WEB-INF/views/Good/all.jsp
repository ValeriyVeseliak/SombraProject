<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<table>
<c:forEach items="${goods}" var="good">
<tr>
	<td>${good.goodName}</td>
	<td></td>
	<td></td>
</tr>
</c:forEach>
</table>
<select>
	
</select>

<select>
	<option value="5">5</option>
	<option value="10">10</option>
	<option value="25">25</option>
</select>

<label for=price>Price</label>
<input type=range min=0 max="${maxPrice}" value="${maxPrice}"  id=price oninput="outputUpdate(value)" step=10>
<output for=price id=newPrice>${maxPrice}</output>
<script>
function outputUpdate(vol) {
document.querySelector('#newPrice').value = vol;
}
</script>

