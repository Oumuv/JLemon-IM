import Vue from 'vue'
import Vuex from "vuex";
import VuexAlong from "vuex-along";
import user from './modules/user'
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    user
  },
  plugins:[
      VuexAlong({
        // 设置保存的集合名字，避免同站点下的多项目数据冲突
        name: "hello-vuex-along"
      })
  ],
  getters
})

export default store
