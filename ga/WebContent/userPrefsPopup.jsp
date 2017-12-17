<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="popupInner">
	<h1>User Preferences</h1>
</div>
<div class="popupInner popupContent">
	<p>${cookie.username.value}'s preferences</p>
	<p>Preferred Gerrymandering Measures</p>
	<div>
		<c:choose>
			<c:when test="${requestScope.efficiencyGapPref == 'true'}">
				<input id="efficiencyGapPref" type="checkbox"
					name="efficiencyGapPref" value="${requestScope.efficiencyGapPref}"
					checked />
			</c:when>
			<c:otherwise>
				<input id="efficiencyGapPref" type="checkbox"
					name="efficiencyGapPref" value="${requestScope.efficiencyGapPref}" />
			</c:otherwise>
		</c:choose>
		<label>Efficiency Gap</label>
	</div>
	<div>
		<c:choose>
			<c:when test="${requestScope.consistentAdvantagePref == 'true'}">
				<input id="consistentAdvantagePref" type="checkbox"
					name="consistentAdvantagePref"
					value="${requestScope.consistentAdvantagePref}" checked />
			</c:when>
			<c:otherwise>
				<input id="consistentAdvantagePref" type="checkbox"
					name="consistentAdvantagePref"
					value="${requestScope.consistentAdvantagePref}" />
			</c:otherwise>
		</c:choose>
		<label>Consistent Advantage</label>

	</div>
	<br> <a href="#savePrefs" onclick="savePrefs();">Save</a>
</div>
<a class="fullPageAnchor" href="#"></a>
