<template>
    <el-menu
            background-color="lavender"
            text-color="darkslategrey"
            :default-active="activeIndex" mode="horizontal" router>
        <el-menu-item index="/">首页</el-menu-item>
        <el-menu-item index="/query">图书查询</el-menu-item>
        <el-menu-item index="/borrow">图书借还</el-menu-item>
        <el-menu-item index="/admin">管理员人口</el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "HeaderLink",
        data() {
            return {
                activeIndex: '/'
            }
        },
        mounted() { this.userName=this.$store.state.userLogin.userName;
        }
    }
</script>

<style scoped>

</style>