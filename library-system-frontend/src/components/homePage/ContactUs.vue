<template>
    <div>
        <h2 class="page-title">
            客户订阅
        </h2>
        <p style="color: red">此功能仅作模板用，没数据交互。</p>
        <el-form label-position="right">
            <el-form-item label="名字">
                <el-input clearable v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="QQ">
                <el-input clearable v-model="form.qq"></el-input>
            </el-form-item>
            <el-form-item label="手机">
                <el-input clearable v-model="form.mobile"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
                <el-input clearable v-model="form.email"></el-input>
            </el-form-item>
            <el-button icon="el-icon-check" type="primary" size="large">提交</el-button>
        </el-form>
        <h2 class="page-title">
            联系方式
        </h2>
        <div class="page-content">
            <p style="color: red">联系方式是假的，Fate! 作页面内容补充用。</p>
            <p style="text-decoration: line-through">图书馆微信公众号：GDUF图书馆</p>
            <p style="text-decoration: line-through">图书馆官方微博：@GDUF图书馆</p></div>
    </div>
</template>

<script>
    export default {
        name: "ContactUs",
        data() {
            return {
                form: {
                    name: '',
                    qq: '',
                    mobile: '',
                    email: ''
                }
            }
        }
    }
</script>

<style scoped>

</style>