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
            <el-table-column prop="name" label="姓名" width="250px"></el-table-column>
            <el-table-column prop="sex" label="性别">
            </el-table-column>
            <el-table-column prop="year" label="年份"></el-table-column>
            <el-table-column prop="idCard" label="身份证"></el-table-column>
            <el-table-column prop="tel" label="电话" width="50px" align="center"></el-table-column>
            <el-table-column prop="addr" label="地址" width="50px" align="center"></el-table-column>
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
        <el-dialog title="编辑读者信息" :visible.sync="editVisible">
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
                    <td class="table-header">姓名</td>
                    <td>{{editUser.name}}</td>
                    <td>
                        <el-input clearable :placeholder="editUser.name" v-model="changeItems.name"></el-input>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">性别</td>
                    <td>
                        {{editUser.gender===0?'男':'女'}}
                    </td>
                    <td>
                        <el-radio-group v-model="changeItems.gender">
                            <el-radio label="0">男</el-radio>
                            <el-radio label="1">女</el-radio>
                        </el-radio-group>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">身份证</td>
                    <td>{{editUser.idCard}}</td>
                    <td>
                        <el-input clearable :placeholder="editUser.idCard" v-model="changeItems.idCard"></el-input>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">电话</td>
                    <td>{{editUser.tel}}</td>
                    <td>
                        <el-input clearable :placeholder="editUser.tel"
                                  v-model="changeItems.tel"></el-input>
                    </td>
                </tr>
                <tr>
                    <td class="table-header">地址</td>
                    <td>{{editUser.addr}}</td>
                    <td>
                        <el-input clearable :placeholder="editUser.addr" type="number"
                                  v-model="changeItems.addr"></el-input>
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
        name: "UserResult",
        data() {
            return {
                result: [],
                editUser: {},
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
                this.editUser = this.result[index]
                this.emptyChangeItems = {
                    id: row.id,
                    name: '',
                    gender: '',
                    tel: '',
                    addr: '',
                    idCard:'',
                    year:new Date().getFullYear()
                }
                this.changeItems = {...this.emptyChangeItems}
            },
            handleDelete(row, index) {
                this.$confirm('此操作将永久删除该读者, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.axios.delete('/reader/' + row.id).then((response) => {
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
                this.axios.put('/reader/' + data.id, data)
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
            let stateResult = this.$store.state.userQueryResult;
            stateResult=stateResult.map(elem=> {
                elem.sex=elem.gender===0?'男':'女'
                return elem
            })
            this.result = stateResult
        }
    }
</script>

<style scoped>
    .table-header {
        color: darkslategrey;
        font-weight: bold;
    }
</style>