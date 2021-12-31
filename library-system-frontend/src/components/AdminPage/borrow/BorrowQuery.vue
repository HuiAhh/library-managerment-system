<template>
    <div style="text-align: center">
        <h2 class="page-title">
            借还查询
        </h2>
        <el-form label-width="80px" class="page-form" :model="form" label-position="right">
            <el-form-item label="书名">
                <el-input v-model="form.bookName" clearable placeholder="书名"></el-input>
            </el-form-item>
            <el-form-item label="读者姓名">
                <el-input v-model="form.readerName" clearable placeholder="读者姓名"></el-input>
            </el-form-item>
            <el-form-item label="借书时间范围">
                <el-form-item label="开始时间">
                    <el-input v-model="form.start" type="datetime-local" clearable></el-input>
                </el-form-item>
                <el-form-item label="结束时间">
                    <el-input v-model="form.end" type="datetime-local" clearable></el-input>
                </el-form-item>
            </el-form-item>
            <el-button type="primary" @click="queryBorrow"><i class="el-icon-search"></i>&ensp;查询</el-button>
            <el-button><i class="el-icon-delete"></i>&ensp;清空</el-button>
        </el-form>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "BookQuery",
        data() {
            return {
                form: {
                    bookName: '',
                    readerName: '',
                    start: null,
                    end: null
                }
            }
        },
        methods: {
            queryBorrow() {
                let self = this
                let url = '/borrow'
                axios.get(url, {params: this.form})
                    .then(function (response) {
                    if (response['status'] === 200) {
                        self.$store.commit('putBorrowParameter', response['data'])
                        self.$router.push('/admin/borrow/result')
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>