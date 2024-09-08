import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import cheliangList from '@/views/pages/cheliang/list'
import cheliangDetail from '@/views/pages/cheliang/formModel'
import cheliangAdd from '@/views/pages/cheliang/formAdd'
import cheliangleixingList from '@/views/pages/cheliangleixing/list'
import cheliangleixingDetail from '@/views/pages/cheliangleixing/formModel'
import cheliangleixingAdd from '@/views/pages/cheliangleixing/formAdd'
import zucheList from '@/views/pages/zuche/list'
import zucheDetail from '@/views/pages/zuche/formModel'
import zucheAdd from '@/views/pages/zuche/formAdd'
import huiyuanList from '@/views/pages/huiyuan/list'
import huiyuanDetail from '@/views/pages/huiyuan/formModel'
import huiyuanAdd from '@/views/pages/huiyuan/formAdd'
import huiyuanRegister from '@/views/pages/huiyuan/register'
import huiyuanCenter from '@/views/pages/huiyuan/center'
import huiyuanzucheList from '@/views/pages/huiyuanzuche/list'
import huiyuanzucheDetail from '@/views/pages/huiyuanzuche/formModel'
import huiyuanzucheAdd from '@/views/pages/huiyuanzuche/formAdd'
import quchedidianList from '@/views/pages/quchedidian/list'
import quchedidianDetail from '@/views/pages/quchedidian/formModel'
import quchedidianAdd from '@/views/pages/quchedidian/formAdd'
import haicheList from '@/views/pages/haiche/list'
import haicheDetail from '@/views/pages/haiche/formModel'
import haicheAdd from '@/views/pages/haiche/formAdd'
import huiyuanhaicheList from '@/views/pages/huiyuanhaiche/list'
import huiyuanhaicheDetail from '@/views/pages/huiyuanhaiche/formModel'
import huiyuanhaicheAdd from '@/views/pages/huiyuanhaiche/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'cheliangList',
			component: cheliangList
		}, {
			path: 'cheliangDetail',
			component: cheliangDetail
		}, {
			path: 'cheliangAdd',
			component: cheliangAdd
		}
		, {
			path: 'cheliangleixingList',
			component: cheliangleixingList
		}, {
			path: 'cheliangleixingDetail',
			component: cheliangleixingDetail
		}, {
			path: 'cheliangleixingAdd',
			component: cheliangleixingAdd
		}
		, {
			path: 'zucheList',
			component: zucheList
		}, {
			path: 'zucheDetail',
			component: zucheDetail
		}, {
			path: 'zucheAdd',
			component: zucheAdd
		}
		, {
			path: 'huiyuanList',
			component: huiyuanList
		}, {
			path: 'huiyuanDetail',
			component: huiyuanDetail
		}, {
			path: 'huiyuanAdd',
			component: huiyuanAdd
		}
		, {
			path: 'huiyuanCenter',
			component: huiyuanCenter
		}
		, {
			path: 'huiyuanzucheList',
			component: huiyuanzucheList
		}, {
			path: 'huiyuanzucheDetail',
			component: huiyuanzucheDetail
		}, {
			path: 'huiyuanzucheAdd',
			component: huiyuanzucheAdd
		}
		, {
			path: 'quchedidianList',
			component: quchedidianList
		}, {
			path: 'quchedidianDetail',
			component: quchedidianDetail
		}, {
			path: 'quchedidianAdd',
			component: quchedidianAdd
		}
		, {
			path: 'haicheList',
			component: haicheList
		}, {
			path: 'haicheDetail',
			component: haicheDetail
		}, {
			path: 'haicheAdd',
			component: haicheAdd
		}
		, {
			path: 'huiyuanhaicheList',
			component: huiyuanhaicheList
		}, {
			path: 'huiyuanhaicheDetail',
			component: huiyuanhaicheDetail
		}, {
			path: 'huiyuanhaicheAdd',
			component: huiyuanhaicheAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
	,{
		path: '/huiyuanRegister',
		component: huiyuanRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
