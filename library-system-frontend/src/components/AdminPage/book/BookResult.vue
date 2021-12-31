<template>
    <div>

        <el-page-header style="margin-top: 20px" @back="back" content="查询结果">
        </el-page-header>
        <el-table
                style="margin-top: 20px;"
                :data="result"
                height="100%"
                stripe
                @selection-change="handleSelectionChange"
        >
            <el-table-column type="selection" width="50"></el-table-column>
            <el-table-column prop="id" label="ID" width="50px" align="right"></el-table-column>
            <el-table-column prop="name" label="书名" width="250px"></el-table-column>
            <el-table-column prop="author" label="作者"></el-table-column>
            <el-table-column prop="publishing" label="出版社"></el-table-column>
            <el-table-column prop="isbn" label="ISBN"></el-table-column>
            <el-table-column prop="count" label="总量" width="50px" align="center"></el-table-column>
            <el-table-column prop="remain" label="余量" width="50px" align="center"></el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.row,scope.$index)">编辑
                    </el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.row,scope.$index)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="编辑图书" :visible.sync="editVisible">
            <p style="color: red">要修改的字段填入，不修改的字段不要输入任何字符！！</p>
            <p>页面信息不会即时更改</p>
            <table class="el-table">
                <tr>
                    <td class="table-header"></td>
                    <td class="table-header">旧值</td>
                    <td class="table-header">
                        新值
                    </td>
                </tr>
                <tr>
                    <td class="table-header">书名</td>
                    <td>{{editBook.name}}</td>
                    <td>
                        <el-input clearable :placeholder="editBook.name" v-model="changeItems.name"></el-input>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">作者</td>
                    <td>{{editBook.author}}</td>
                    <td>
                        <el-input clearable :placeholder="editBook.author" v-model="changeItems.author"></el-input>

                    </td>
                </tr>
                <tr>
                    <td class="table-header">出版社</td>
                    <td>{{editBook.publishing}}</td>
                    <td>
                        <el-input clearable :placeholder="editBook.publishing"
                                  v-model="changeItems.publishing"></el-input>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">ISBN</td>
                    <td>{{editBook.isbn}}</td>
                    <td>
                        <el-input clearable :placeholder="editBook.isbn" v-model="changeItems.isbn"></el-input>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">总量</td>
                    <td>{{editBook.count}}</td>
                    <td>
                        <el-input clearable :placeholder="editBook.count" type="number"
                                  v-model="changeItems.count"></el-input>

                    </td>
                </tr>
                <tr>
                    <td class="table-header">余量</td>
                    <td>{{editBook.remain}}</td>
                    <td>
                        <el-input clearable :placeholder="editBook.remain" type="number"
                                  v-model="changeItems.remain"></el-input>
                    </td>
                </tr>
            </table>
            <div style="text-align: center">
                <el-button type="primary" @click="handleUpdate">修改</el-button>
                <el-button type="danger" @click="changeItems={...emptyChangeItems}">清空</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "BookResult",
        data() {
            return {
                result: [],
                editBook: {},
                changeItems: {},
                editVisible: false,
                emptyChangeItems: {}
            }
        },
        methods: {
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            back() {
                this.$router.go(-1);
            },
            handleEdit(row, index) {
                this.editVisible = true
                this.editBook = this.result[index]
                this.emptyChangeItems = {
                    id: row.id,
                    author: '',
                    publishing: '',
                    isbn: '',
                    count: null,
                    remain: null
                }
                this.changeItems = {...this.emptyChangeItems}
            },
            handleDelete(row, index) {
                this.$confirm('此操作将永久删除该图书, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.axios.delete('/book/' + row.id).then((response) => {
                        // console.log(response.data)
                        alert('删除了' + response.data + '项')
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        })
                    }).catch((error) => {
                        this.$message.error("出错了: -> " + JSON.stringify(error))
                    })

                    this.result.splice(index, 1)
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            handleUpdate() {
                let data = this.changeItems;
                console.log(data)
                this.axios.put('/book/' + data.id, data)
                    .then((response) => {
                        alert('改变了' + response.data + '项')
                        this.$message({
                            type: 'success',
                            message: '修改成功!'
                        })
                        this.editVisible=false

                    })
                    .catch((error) => {
                        this.$message({
                            type: 'error',
                            message: "出错了: -> " + JSON.stringify(error)
                        })
                    })
            }
        },
        mounted() {
            this.result = this.$store.state.bookQueryResult
        }
    }
</script>

<style scoped>
    .table-header {
        color: darkslategrey;
        font-weight: bold;
    }
</style>