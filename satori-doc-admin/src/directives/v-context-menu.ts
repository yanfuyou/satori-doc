import { DirectiveBinding } from "vue";

const ContextMenu = {
	mounted(el: any, binding: DirectiveBinding) {
		const menu = binding.value;
		if (!menu) {
			return;
		}
		el.addEventListener("contextmenu", (e: any) => {
			e.preventDefault();

			const mouseX = e.clientX;
			const mouseY = e.clientY;
			// 创建一个菜单元素并添加到body
			const menuElement = document.createElement("div");
			menuElement.style.position = "absolute";
			menuElement.style.left = `${mouseX}px`;
			menuElement.style.top = `${mouseY}px`;
			menuElement.style.backgroundColor = "white";
			menuElement.style.zIndex = "1000";
			menuElement.style.border = "1px solid #ccc";

			// 构建菜单项
			menu.forEach((item: any) => {
				const menuItem = document.createElement("div");
				menuItem.textContent = item.label;
				menuItem.style.padding = "5px";
				menuItem.style.cursor = "pointer";
				menuItem.addEventListener("click", item.action);
				menuElement.appendChild(menuItem);
			});

			document.body.appendChild(menuElement);
		});
		// 清理菜单元素
		el.addEventListener("click", () => {
			const menuElements = document.querySelectorAll(".context-menu");
			menuElements.forEach((menuElement) => {
				menuElement.remove();
			});
		});
	},
};

export default ContextMenu;
