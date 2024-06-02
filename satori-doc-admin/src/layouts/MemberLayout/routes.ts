import { RouteRecordRaw } from "vue-router";
import { homePath } from "@/config/settings";

const MemberLayoutRoutes: RouteRecordRaw[] = [
	{
		meta: {
			title: "member-layout.menu.home",
			icon: "menu-home",
		},
		path: homePath,
		component: () => import("@/pages/doc/index.vue"),
	},
	{
		meta: {
			title: "member-layout.menu.doc",
			icon: "router",
		},
		path: "/doc",
		children: [
			{
				meta: {
					title: "member-layout.menu.doc.list",
				},
				path: "list",
				component: () => import("@/pages/doc/index.vue"),
			},
			{
				meta: {
					title: "member-layout.menu.doc.add",
				},
				path: "add",
				component: () => import("@/pages/doc/components/add.vue"),
			},
		],
	},
];

export default MemberLayoutRoutes;
