import store from "../store"

const rejectAuthUser = (to, from , next) => {
  if(store.state.isLogin === true){
    // 이미 로그인된 유저니까 막아야 한다.
    alert("이미 로그인 되었다")
    next("/") // 홈으로 리다이렉션 시킨다
  } else{
    next()
  }
}
const onlyAuthUser = (to, from , next) => {
  if(store.state.isLogin === false){
    // 아직 로그인안된 유저니까 막아야 한다.
    alert("로그인이 필요한 기능입니다")
    next("/") // 홈으로 리다이렉션 시킨다
  } else{
    next()
  }
}


const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: 'detail/:itemId', component: () => import('pages/Detail.vue') },
      { path: 'buy/:itemId', component: () => import('pages/Buy.vue') },
      { path: '/test', component: () => import('pages/Test.vue')},
      { path: '/stuff', component: () => import('pages/Stuff_upload.vue')},
      { path: '/profile', component: () => import('pages/Profile.vue')},
      { path: '/main2', component: () => import('pages/Main2.vue')},
      // { path: '/new_main',component: () => import('pages/asdfasdf.vue')}
    ]
  },
  { 
    path: '/login', 
    component: () => import('pages/Login.vue')
  },
  { 
    path: '/login2', 
    component: () => import('components/Login2.vue')
  },
  { 
    path: '/register', 
    component: () => import('pages/Register.vue')
  },
  { 
    path: '/mainhome', 
    component: () => import('pages/Mainhome.vue')
  },

  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
] 

export default routes
