function isRepublican(state) {
	return state.republican_Electoral > state.democratic_Electoral;
}

function isDemocratic(state) {
	return state.republican_Electoral < state.democratic_Electoral;
}