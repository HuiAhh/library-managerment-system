<template>
    <div>
        <p>模拟扫描书本图书馆藏条形码。也就是书本ID。</p>
        <el-form :model="borrow" label-position="right">
            <el-form-item label="书本标识码">
                <el-input v-model="borrow.bookId" clearable placeholder="书本标识码"/>
            </el-form-item>
            <el-form-item label="租期">
                <el-input v-model="borrow.returnBorrow" clearable type="number" placeholder="租期">
                </el-input>
            </el-form-item>
            <p>模拟刷身份证借还书。</p>
            <el-form-item label="身份证号码">
                <el-input v-model="borrow.idCard" clearable placeholder="身份证号码">
                </el-input>
            </el-form-item>
            <el-button type="primary" @click="handleSubmit">提交</el-button>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "BorrowBook",
        data() {
            return {
                borrow: {
                    bookId:"",
                    returnBorrow:0,
                    idCard:''
                }
            }
        },methods:{
            handleSubmit(){
                this.axios.post('/borrow', JSON.stringify(this.borrow))
                    .then((response) => {
                        alert('添加了' + response.data + '项')
                        this.$message({
                            type: 'success',
                            message: '借书成功!'
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