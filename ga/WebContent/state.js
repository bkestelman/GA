function isRepublican(state) {
	console.log(state.republican_Electoral);
	console.log(state.democratic_Electoral);
	console.log("is republican?");
	console.log(state.republican_Electoral > state.democratic_Electoral);
	return state.republican_Electoral > state.democratic_Electoral;
}

function isDemocratic(state) {
	console.log(state.republican_Electoral);
	console.log(state.democratic_Electoral);
	console.log("is democratic?");
	console.log(state.republican_Electoral < state.democratic_Electoral);
	return state.republican_Electoral < state.democratic_Electoral;
}