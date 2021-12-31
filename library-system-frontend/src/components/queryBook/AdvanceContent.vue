<template>
    <div style="text-align: center">
        <h2 class="page-title">
            高级查询
        </h2>
        <el-form label-width="80px" class="page-form" :model="form" label-position="right">
            <el-form-item label="书名">
                <el-input v-model="form.name" clearable placeholder="书名"></el-input>
            </el-form-item>
            <el-form-item label="作者">
                <el-input v-model="form.author" clearable placeholder="作者"></el-input>
            </el-form-item>
            <el-form-item label="出版社">
                <el-input v-model="form.publishing" clearable placeholder="出版社"></el-input>
            </el-form-item>
            <el-form-item label="剩余量">
                <el-input v-model="form.remain" clearable placeholder="大于等于几本"></el-input>
            </el-form-item>
            <el-button type="primary" @click="queryBook"><i class="el-icon-search"></i>&ensp;查询</el-button>
            <el-button><i class="el-icon-delete"></i>&ensp;清空</el-button>
        </el-form>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "AdvanceContent",
        data() {
            return {
                form: {
                    name: '',
                    author: '',
                    publishing: '',
                    remain: 0
                }
            }
        },
        methods: {
            queryBook() {
                let self = this
                let url = '/book/advance'
                axios.get(url,
                    {
                        params: this.form
                    }
                ).then(function (response) {
                    if (response['status'] === 200) {
                        let data = response['data']
                        self.$store.commit('putBookQueryResult', data)
                        self.$router.push('/result')
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>