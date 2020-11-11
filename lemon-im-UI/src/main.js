import Vue from "vue";
import router from './router'
import store from './store'

import App from "./App.vue";

import LemonIMUI from '../packages'

import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(LemonIMUI);
Vue.use(Element, {
  size: 'medium', // set element-ui default size
})

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
