<template>
    <div style="align-content: center;height: 100%;width: 40%;margin: 0 auto;">
        <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-width="80px">
            <el-form-item label="账号" prop="username">
                <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="loginForm.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="handleLogin">登 录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import Cookies from "js-cookie";

    export default {
        name:'login',
        data() {
            return {
                loginForm:{
                    username:'',
                    password:''
                },
                loginRules: {
                    username: [
                        { required: true, trigger: "blur", message: "用户名不能为空" }
                    ],
                    password: [
                        { required: true, trigger: "blur", message: "密码不能为空" }
                    ],
                },
            }

        },
        methods:{
            handleLogin() {
                this.$refs.loginForm.validate(valid => {
                    if (valid) {
                        this.$store
                            .dispatch("Login", this.loginForm)
                            .then(() => {
                                this.$router.push({ path: "/index"});
                            })
                    }
                });
            }
        }
    }
</script>