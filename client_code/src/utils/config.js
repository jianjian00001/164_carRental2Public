const config = {
  get() {
    return {
      url:
        process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
      name: process.env.VUE_APP_BASE_API,
      menuList: [
        // {
        // 	name: '会员管理',
        // 	icon: '${frontMenu.fontClass}',
        // 	child:[
        // 		{
        // 			name:'会员',
        // 			url:'/index/huiyuanList'
        // 		},
        // 	]
        // },
        {
          name: '车辆管理',
          icon: '${frontMenu.fontClass}',
          child: [
            {
              name: '车辆',
              url: '/index/cheliangList',
            },
          ],
        },
      ],
    }
  },
  getProjectName() {
    return {
      projectName: '车辆租赁管理',
    }
  },
}
export default config
