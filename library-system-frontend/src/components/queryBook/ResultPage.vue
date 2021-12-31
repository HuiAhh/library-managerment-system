<template>
    <div>
        <h2 class="page-title">查询结果</h2>
        <el-page-header style="margin-top: 20px" @back="back" content="查询结果">
        </el-page-header>
        <el-table
                style="margin-top: 20px;"
                :data="result"
                height="100%"
                stripe
        >
            <el-table-column prop="id" label="ID" width="50px" align="right"></el-table-column>
            <el-table-column prop="name" label="书名" width="250px"></el-table-column>
            <el-table-column prop="author" label="作者"></el-table-column>
            <el-table-column prop="publishing" label="出版社"></el-table-column>
            <el-table-column prop="isbn" label="ISBN"></el-table-column>
            <el-table-column prop="count" label="总量" width="50px" align="center"></el-table-column>
            <el-table-column prop="remain" label="余量" width="50px" align="center"></el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "ResultPage",
        data() {
            return {
                result: ''
            }
        },
        methods: {
            back() {
                this.$router.go(-1);
            }
        },
        mounted() {
            this.result = this.$store.state.bookQueryResult
        }
    }
</script>

<style scoped>

</style>