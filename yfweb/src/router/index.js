import Vue from 'vue'
import Router from 'vue-router'
import YfHeader from 'components/header/yf-header'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'YfHeader',
      component: YfHeader
    }
  ]
})
