<template>
	<router-view />
</template>
<script>
	const debounce = (fn, delay) => {
		let timer = null;
		return function() {
			let context = this;
			let args = arguments;
			clearTimeout(timer);
			timer = setTimeout(function() {
				fn.apply(context, args);
			}, delay);
		}
	}

	const _ResizeObserver = window.ResizeObserver;
	window.ResizeObserver = class ResizeObserver extends _ResizeObserver {
		constructor(callback) {
			callback = debounce(callback, 16);
			super(callback);
		}
	}
</script>
<style lang="scss">
	body {
		margin: 0;
	}
	* {
		box-sizing: border-box;
	}
	.app-contain {
		width: 100%;
		// padding: 0 8%;
		// box-sizing: border-box;
	}
	.section_title {
		border-radius: 0;
		padding: 8px 30px 8px;
		margin: 0 auto;
		color: #113961;
		background: #fff;
		font-weight: 600;
		font-size: 22px;
		border-color: #113961;
		border-width: 1px 1px 2px;
		border-style: solid;
		text-align: center;
	}

	#app {
		font-family: Avenir, Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		// text-align: center;
		color: #2c3e50;
	}

	nav {
		padding: 30px;

		a {
			font-weight: bold;
			color: #2c3e50;

			&.router-link-exact-active {
				color: #42b983;
			}
		}
	}
</style>