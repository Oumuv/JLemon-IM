import {login, logout} from '@/api/login'
import {getToken, setToken, removeToken} from '@/utils/auth'

const user = {
    state: {
        token: getToken(),
        username: '',
        nickname: '',
        avatar: '',
    },
    mutations: {
        SET_TOKEN: (state, token) => {
            state.token = token
        },
        SET_NAME: (state, username) => {
            state.username = username
        },
        SET_NICKNAME: (state, nickname) => {
            state.nickname = nickname
        },
        SET_AVATAR: (state, avatar) => {
            state.avatar = avatar
        },
    },

    actions: {
        // 登录
        Login({commit}, userInfo) {
            const username = userInfo.username.trim()
            const password = userInfo.password
            return new Promise((resolve,reject) => {
                login(username, password).then(res => {
                    setToken(res.data.token);
                    commit('SET_TOKEN', res.data.token)
                    commit('SET_NAME', res.data.user.username)
                    commit('SET_NICKNAME', res.data.user.nick)
                    commit('SET_AVATAR', res.data.user.avatar)
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })

        },

        // 获取用户信息
        // GetInfo({ commit, state }) {
        // return new Promise((resolve, reject) => {
        //   getInfo(state.token).then(res => {
        //     const user = res.user
        //     const avatar = user.avatar == "" ? require("@/assets/image/profile.jpg") : process.env.VUE_APP_BASE_API + user.avatar;
        //     if (res.roles && res.roles.length > 0) { // 验证返回的roles是否是一个非空数组
        //       commit('SET_ROLES', res.roles)
        //       commit('SET_PERMISSIONS', res.permissions)
        //     } else {
        //       commit('SET_ROLES', ['ROLE_DEFAULT'])
        //     }
        //     commit('SET_NAME', user.username)
        //     commit('SET_AVATAR', avatar)
        //     resolve(res)
        //   }).catch(error => {
        //     reject(error)
        //   })
        // })
        // },

        // 退出系统
        LogOut({commit, state}) {
            return new Promise((resolve, reject) => {
                logout(state.token).then(() => {
                    commit('SET_TOKEN', '')
                    removeToken()
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },

        // 前端 登出
        FedLogOut({commit}) {
            return new Promise(resolve => {
                commit('SET_TOKEN', '')
                removeToken()
                resolve()
            })
        }
    }
};

export default user
