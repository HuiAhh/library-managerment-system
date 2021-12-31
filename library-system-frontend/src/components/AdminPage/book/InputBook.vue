<template>
    <div class="admin-form">
        <h2 class="page-title">新图书入库</h2>
        <el-form label-position="right" :model="book">
            <el-form-item label="图书名">
                <el-input clearable v-model="book.name" placeholder="图书名"></el-input>
            </el-form-item>
            <el-form-item label="作者">
                <el-input clearable v-model="book.author" placeholder="作者"></el-input>
            </el-form-item>
            <el-form-item label="出版社">
                <el-input clearable v-model="book.publishing" placeholder="出版社"></el-input>
            </el-form-item>
            <el-form-item label="ISBN">
                <el-input clearable v-model="book.isbn" placeholder="ISBN"></el-input>
            </el-form-item>
            <el-form-item label="入库数量">
                <el-input clearable type="number" v-model="book.count" placeholder="入库数量"></el-input>
            </el-form-item>
            <el-form-item label="现库存数量">
                <el-input clearable type="number" v-model="book.remain" placeholder="入库数量"></el-input>
            </el-form-item>
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="book={...emptyBook}">重填</el-button>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "InputBook",
        data() {
            return {
                book: {
                    name: '',
                    author: '',
                    publishing: '',
                    isbn: '',
                    count: 0,
                    remain: 0
                },
                emptyBook: {
                    name: '',
                    author: '',
                    publishing: '',
                    isbn: '',
                    count: 0,
                    remain: 0
                }
            }
        },
        methods: {
            submitForm() {
                this.axios.post('/book', JSON.stringify(this.book))
                    .then((response) => {
                    alert('添加了' + response.data + '项')
                    this.$message({
                        type: 'success',
                        message: '添加成功!'
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