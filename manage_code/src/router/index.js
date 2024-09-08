	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import huiyuanhaiche from '@/views/huiyuanhaiche/list'
	import haiche from '@/views/haiche/list'
	import huiyuanzuche from '@/views/huiyuanzuche/list'
	import cheliang from '@/views/cheliang/list'
	import quchedidian from '@/views/quchedidian/list'
	import yonghu from '@/views/yonghu/list'
	import zuche from '@/views/zuche/list'
	import huiyuan from '@/views/huiyuan/list'
	import config from '@/views/config/list'
	import cheliangleixing from '@/views/cheliangleixing/list'
	import users from '@/views/users/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/huiyuanhaiche',
			name: '会员还车',
			component: huiyuanhaiche
		}
		,{
			path: '/haiche',
			name: '还车',
			component: haiche
		}
		,{
			path: '/huiyuanzuche',
			name: '会员租车',
			component: huiyuanzuche
		}
		,{
			path: '/cheliang',
			name: '车辆',
			component: cheliang
		}
		,{
			path: '/quchedidian',
			name: '取车地点',
			component: quchedidian
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/zuche',
			name: '租车',
			component: zuche
		}
		,{
			path: '/huiyuan',
			name: '会员',
			component: huiyuan
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/cheliangleixing',
			name: '车辆类型',
			component: cheliangleixing
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
