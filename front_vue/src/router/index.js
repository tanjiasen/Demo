import Vue from 'vue'
import Router from 'vue-router'
import MainPage from "../components/main";
import test01 from "../components/test01";
import test02 from "../components/test02";
import CustomerInfo from '../components/tjs/CustomerInfo';
Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/',
      name: 'main',
      component: MainPage,
      meta:{
        isShow: true
      },
      children:[
        {
          path: '/test01',
          name: 'test01',
          component: test01
        },
        {
          path: '/test02',
          name: 'test02',
          component: test02
        },
        {
          path: '/components/tjs/CustomerInfo',
          name: 'CustomerInfo',
          component: CustomerInfo
        }
      ]
    }
  ]
})
