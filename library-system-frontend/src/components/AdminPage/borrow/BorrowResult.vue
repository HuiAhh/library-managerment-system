<template>
    <div>
        <el-page-header style="margin-top: 20px" @back="back" content="查询结果">
        </el-page-header>

        <p style="color:gray">租期为0意味着已经还书了。</p>
        <el-table
                style="margin-top: 20px;"
                :data="result"
                stripe
                @selection-change="handleSelectionChange"
        >
            <el-table-column type="selection" width="50"></el-table-column>
            <el-table-column prop="id" label="ID" width="50px" align="center"></el-table-column>
            <el-table-column prop="readerId" label="读者ID" width="50px" align="center"></el-table-column>
            <el-table-column prop="readerName" label="姓名" width="100px" align="left"></el-table-column>
            <el-table-column prop="bookId" label="书本ID" width="50px" align="center"></el-table-column>
            <el-table-column prop="bookName" label="书名" align="left"></el-table-column>
            <el-table-column prop="borrowTime" label="借书时间" width="250px" align="left"></el-table-column>
            <el-table-column prop="returnBorrow" label="租期" width="50px" align="center"></el-table-column>
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
        <el-dialog title="编辑借还信息" :visible.sync="editVisible">
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
                    <td class="table-header">借书时间</td>
                    <td>{{editBorrow.borrowTime}}</td>
                    <td>
                        <el-input clearable type="datetime-local" :placeholder="editBorrow.borrowTime" v-model="changeItems.borrowTime"></el-input>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">租期</td>
                    <td>{{editBorrow.returnBorrow}}</td>
                    <td>
                        <el-input clearable type="number" :placeholder="editBorrow.returnBorrow" v-model="changeItems.returnBorrow"></el-input>
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
    import axios from "axios";

    export default {
        name: "BorrowResult",
        data() {
            return {
                result: [],
                editBorrow: {},
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
                this.editBorrow = this.result[index]
                this.emptyChangeItems = {
                    id: row.id,
                    borrowTime:'',
                    returnBorrow:null
                }
                this.changeItems = {...this.emptyChangeItems}
            },
            handleDelete(row, index) {
                this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.axios.delete('/borrow/' + row.id).then((response) => {
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
                this.axios.put('/borrow/' + data.id, data)
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
            },
            queryAllResult() {
                let self = this
                let url = '/borrow'
                axios.get(url).then(function (response) {
                    if (response['status'] === 200) {
                        self.result=response['data']
                    }
                }).catch((error)=>alert(JSON.stringify(error)))
            },
            queryResultByConditions() {
                //

                this.result=this.$store.state.borrowParameter
            },
        },
        mounted() {
            if(this.$route.path==='/admin/borrow') {
                this.queryAllResult()
            }else if(this.$route.path==='/admin/borrow/result'){
                this.queryResultByConditions()
            }
        }
    }
</script>

<style scoped>
    .table-header {
        color: darkslategrey;
        font-weight: bold;
    }
</style>