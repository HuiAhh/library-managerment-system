<template>
    <div class="admin-form">
        <el-form label-position="right" :model="user">
            <el-form-item label="姓名">
                <el-input clearable v-model="user.name" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-radio-group v-model="user.gender">
                    <el-radio label="0">男</el-radio>
                    <el-radio label="1">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="身份证号">
                <el-input clearable v-model="user.idCard" placeholder="身份证号"></el-input>
            </el-form-item>
            <el-form-item label="电话号码">
                <el-input clearable v-model="user.tel" placeholder="电话/手机"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <el-input clearable v-model="user.addr" placeholder="地址"></el-input>
            </el-form-item>
            <el-form-item label="年份">
                <el-input disabled clearable v-model="user.year" placeholder="年份"></el-input>
            </el-form-item>
            <el-button type="primary" @click="handleSubmit">提交</el-button>
            <el-button @click="user={...emptyUser}">重填</el-button>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "UserRegister", data() {
            return {
                user: {
                    name: '',
                    gender: '',
                    tel: '',
                    addr: '',
                    idCard:'',
                    year:new Date().getFullYear()
                },
                emptyUser: {
                    name: '',
                    gender: '',
                    tel: '',
                    addr: '',
                    idCard:'',
                    year:new Date().getFullYear()
                }
            }
        },
        methods:{
            handleSubmit(){
                console.log(this.user)
                this.axios.post('/reader',JSON.stringify(this.user))
                    .then((response) => {
                        alert('添加了' + response.data + '项')
                        this.$message({
                            type: 'success',
                            message: '注册成功!'
                        })
                    }).catch((error) => {
                    this.$message.error("出错了: -> " + JSON.stringify(error))
                })
            }
        }
    }
</script>

<style scoped>

</style>