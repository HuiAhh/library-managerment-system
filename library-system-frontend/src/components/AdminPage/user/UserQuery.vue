<template>
    <div class="page-form">
        <h2 class="page-title">
            用户查询
        </h2>
        <el-form label-position="right" :model="user">
            <el-form-item label="姓名">
                <el-input clearable v-model="user.name" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-radio-group v-model="user.gender">
                    <el-radio label="男" value="0"></el-radio>
                    <el-radio label="女" value="1"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="电话号码">
                <el-input clearable v-model="user.tel" placeholder="电话/手机"></el-input>
            </el-form-item>
            <el-button type="primary" @click="queryReader"><i class="el-icon-search"></i>&ensp;查询</el-button>
            <el-button><i class="el-icon-delete"></i>&ensp;清空</el-button>
        </el-form>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "BookQuery", data() {
            return {
                user: {
                    name: '',
                    gender: '',
                    tel: ''
                }
            }
        },
        methods:{
            queryReader() {
                let self = this
                let url = '/reader'
                axios.get(url,
                    {
                        params: this.user
                    }
                ).then(function (response) {
                    if (response['status'] === 200) {
                        let data = response['data']
                        self.$store.commit('putUserQueryResult', data)
                        self.$router.push('/admin/user/result')
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>